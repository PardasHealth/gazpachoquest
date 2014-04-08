/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.LanguageSettingsDTO;

public class QuestionOptionLanguageSettingsDTO implements LanguageSettingsDTO {

    public static interface Builder {

        QuestionOptionLanguageSettingsDTO build();

        Builder title(String title);

    }

    public static class BuilderImpl implements Builder {

        private String title;

        @Override
        public QuestionOptionLanguageSettingsDTO build() {
            QuestionOptionLanguageSettingsDTO surveyLanguageSettingsDTO = new QuestionOptionLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            return surveyLanguageSettingsDTO;
        }

        @Override
        public BuilderImpl title(final String title) {
            this.title = title;
            return this;
        }
    }

    private static final long serialVersionUID = 8942148329254332833L;

    public static Builder with() {
        return new BuilderImpl();
    }

    private String title;

    public QuestionOptionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
