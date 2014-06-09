package net.sf.gazpachoquest.questionnaires.listener;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.VaadinServletService;

public class AnswerSavedListener implements Serializable {

	private static final long serialVersionUID = 6967998525308434420L;

	private static Logger logger = LoggerFactory
			.getLogger(AnswerSavedListener.class);

	@GazpachoResource
	@Inject
	private QuestionnairResource questionnairResource;

	public void listen(@Observes AnswerSavedEvent event) {
		RespondentAccount respondent = (RespondentAccount) VaadinServletService
				.getCurrentServletRequest().getUserPrincipal();
		Integer questionnairId = respondent.getGrantedQuestionnairIds()
				.iterator().next();

		Answer answer = event.getAnswer();
		String questionCode = event.getQuestionCode();

		logger.debug(
				"Trying to save answer: {}  for questionnair identified with id  = {} and questionCode = {}",
				answer, questionnairId, questionCode);
		questionnairResource.saveAnswer(answer, questionnairId, questionCode);
	}
}