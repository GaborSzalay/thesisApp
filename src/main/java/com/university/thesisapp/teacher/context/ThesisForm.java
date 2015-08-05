package com.university.thesisapp.teacher.context;

import java.util.List;

/**
 * Created by Gábor on 2015.08.05..
 */
public class ThesisForm {
    private String thesisIdInput;
    private String titleHuInput;
    private String titleEnInput;
    private String thesisTypeInput;
    private List<String> courseIds;
    private String requiredSemestersInput;
    private String descriptionHuInput;
    private String descriptionEnInput;

    public String getThesisIdInput() {
        return thesisIdInput;
    }

    public void setThesisIdInput(String thesisIdInput) {
        this.thesisIdInput = thesisIdInput;
    }

    public String getTitleHuInput() {
        return titleHuInput;
    }

    public void setTitleHuInput(String titleHuInput) {
        this.titleHuInput = titleHuInput;
    }

    public String getTitleEnInput() {
        return titleEnInput;
    }

    public void setTitleEnInput(String titleEnInput) {
        this.titleEnInput = titleEnInput;
    }

    public String getThesisTypeInput() {
        return thesisTypeInput;
    }

    public void setThesisTypeInput(String thesisTypeInput) {
        this.thesisTypeInput = thesisTypeInput;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }

    public String getRequiredSemestersInput() {
        return requiredSemestersInput;
    }

    public void setRequiredSemestersInput(String requiredSemestersInput) {
        this.requiredSemestersInput = requiredSemestersInput;
    }

    public String getDescriptionHuInput() {
        return descriptionHuInput;
    }

    public void setDescriptionHuInput(String descriptionHuInput) {
        this.descriptionHuInput = descriptionHuInput;
    }

    public String getDescriptionEnInput() {
        return descriptionEnInput;
    }

    public void setDescriptionEnInput(String descriptionEnInput) {
        this.descriptionEnInput = descriptionEnInput;
    }
}
