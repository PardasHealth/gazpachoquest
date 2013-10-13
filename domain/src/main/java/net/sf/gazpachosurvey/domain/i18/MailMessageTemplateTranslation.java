package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class MailMessageTemplateTranslation extends AbstractAuditable implements
        Translation<MailMessageTemplateLanguageSettings> {

    private static final long serialVersionUID = 6847847400152631889L;

    @ManyToOne(fetch = FetchType.LAZY)
    private MailMessageTemplate mailMessageTemplate;

    @Enumerated(EnumType.STRING)
    @Column(insertable = true, updatable = true)
    private Language language;

    @Embedded
    private MailMessageTemplateLanguageSettings languageSettings;

    public MailMessageTemplateTranslation() {
        super();
    }

    public MailMessageTemplate getMailMessageTemplate() {
        return mailMessageTemplate;
    }

    public void setMailMessageTemplate(MailMessageTemplate mailMessageTemplate) {
        this.mailMessageTemplate = mailMessageTemplate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public MailMessageTemplateLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(MailMessageTemplateLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

}