package net.sf.gazpachosurvey.domain.core;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class Questionnair extends AbstractAuditable {

    private static final long serialVersionUID = -5466079670655149390L;

    public final static String USER_NAME = "questionnair";

    @OneToMany(mappedBy = "questionnair", fetch = FetchType.LAZY)
    private Set<BrowsedElement> browsedElements;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime submitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionnairDefinition questionnairDefinition;

    @ManyToOne(fetch = FetchType.LAZY)
    private Participant participant;

    public Questionnair() {
        super();
    }

    public Set<BrowsedElement> getBrowsedElements() {
        return browsedElements;
    }

    public DateTime getSubmitDate() {
        return submitDate;
    }

    public Study getStudy() {
        return study;
    }

    public void setBrowsedElements(final Set<BrowsedElement> browsedElements) {
        this.browsedElements = browsedElements;
    }

    public void setSubmitDate(final DateTime submitDate) {
        this.submitDate = submitDate;
    }

    public void setStudy(final Study study) {
        this.study = study;
    }

    public QuestionnairDefinition getQuestionnairDefinition() {
        return questionnairDefinition;
    }

    public void setQuestionnairDefinition(QuestionnairDefinition questionnairDefinition) {
        this.questionnairDefinition = questionnairDefinition;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Set<BrowsedElement> browsedElements;
        private DateTime submitDate;
        private Study study;
        private QuestionnairDefinition questionnairDefinition;
        private Participant participant;

        public Builder browsedElements(Set<BrowsedElement> browsedElements) {
            this.browsedElements = browsedElements;
            return this;
        }

        public Builder submitDate(DateTime submitDate) {
            this.submitDate = submitDate;
            return this;
        }

        public Builder study(Study study) {
            this.study = study;
            return this;
        }

        public Builder questionnairDefinition(QuestionnairDefinition questionnairDefinition) {
            this.questionnairDefinition = questionnairDefinition;
            return this;
        }

        public Builder participant(Participant participant) {
            this.participant = participant;
            return this;
        }

        public Questionnair build() {
            Questionnair questionnair = new Questionnair();
            questionnair.browsedElements = browsedElements;
            questionnair.submitDate = submitDate;
            questionnair.study = study;
            questionnair.questionnairDefinition = questionnairDefinition;
            questionnair.participant = participant;
            return questionnair;
        }
    }
}