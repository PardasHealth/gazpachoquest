package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(QuestionOptionTranslation.class)
public class QuestionOptionTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<QuestionOptionTranslation, QuestionOption> questionOption;
    public static volatile SingularAttribute<QuestionOptionTranslation, QuestionOptionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionOptionTranslation, Language> language;

}