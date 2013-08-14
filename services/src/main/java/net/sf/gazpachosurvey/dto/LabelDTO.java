package net.sf.gazpachosurvey.dto;

public class LabelDTO {

    private String title;

    public LabelDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public static Builder with(){
        return new Builder();
    }

    public static class Builder {
        private String title;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public LabelDTO build() {
            LabelDTO labelDTO = new LabelDTO();
            labelDTO.title = title;
            return labelDTO;
        }
    }
}