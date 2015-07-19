package com.university.thesisapp.admin.homepage.context;

import com.university.thesisapp.web.links.ThesisLink;

/**
 * Created by Gábor on 2015.07.19..
 */
public class AdminHomeContext {
    private ThesisLink listAdminsLink;
    private ThesisLink listTeachersLink;
    private ThesisLink listThesisTypesLink;
    private ThesisLink listCoursesLink;
    private ThesisLink listMajorsLink;

    public ThesisLink getListAdminsLink() {
        return listAdminsLink;
    }

    public void setListAdminsLink(ThesisLink listAdminsLink) {
        this.listAdminsLink = listAdminsLink;
    }

    public ThesisLink getListTeachersLink() {
        return listTeachersLink;
    }

    public void setListTeachersLink(ThesisLink listTeachersLink) {
        this.listTeachersLink = listTeachersLink;
    }

    public ThesisLink getListThesisTypesLink() {
        return listThesisTypesLink;
    }

    public void setListThesisTypesLink(ThesisLink listThesisTypesLink) {
        this.listThesisTypesLink = listThesisTypesLink;
    }

    public ThesisLink getListCoursesLink() {
        return listCoursesLink;
    }

    public void setListCoursesLink(ThesisLink listCoursesLink) {
        this.listCoursesLink = listCoursesLink;
    }

    public ThesisLink getListMajorsLink() {
        return listMajorsLink;
    }

    public void setListMajorsLink(ThesisLink listMajorsLink) {
        this.listMajorsLink = listMajorsLink;
    }
}