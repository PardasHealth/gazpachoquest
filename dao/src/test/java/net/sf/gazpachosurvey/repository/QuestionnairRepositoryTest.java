package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairRepositoryTest {

    @Autowired
    private QuestionnairRepository repository;

    @Autowired
    private StudyRepository studyRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Test
    public void findOneTest() {
        Questionnair questionnair = repository.findOne(127);

        Set<BrowsedElement> browsedElements = questionnair.getBrowsedElements();
        assertThat(browsedElements).isNotEmpty();
    }

    @Test
    public void saveTest() {
        Study running = studyRepository.findOne(62);

        Questionnair questionnair = new Questionnair();
        questionnair.setStudy(running);
        questionnair.setAnswersId(999);
        Questionnair created = repository.save(questionnair);

        assertThat(created.getId()).isGreaterThan(0);
    }

}
