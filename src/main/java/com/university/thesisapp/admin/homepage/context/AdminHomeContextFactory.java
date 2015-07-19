package com.university.thesisapp.admin.homepage.context;

import com.university.thesisapp.web.links.ThesisLink;
import com.university.thesisapp.web.messages.Message;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.19..
 */
@Component
public class AdminHomeContextFactory {


    private static final String MESSAGES_ADMIN_HOMEPAGE_LIST_ADMINS = "messages.admin.homepage.list.admins";
    private static final String MESSAGES_ADMIN_HOMEPAGE_LIST_TEACHERS = "messages.admin.homepage.list.teachers";
    private static final String MESSAGES_ADMIN_HOMEPAGE_LIST_COURSES = "messages.admin.homepage.list.courses";
    private static final String MESSAGES_ADMIN_HOMEPAGE_LIST_MAJORS = "messages.admin.homepage.list.majors";
    private static final String MESSAGES_ADMIN_HOMEPAGE_LIST_THESIS_TYPES = "messages.admin.homepage.list.thesis_types";

    public AdminHomeContext create() {
        AdminHomeContext adminHomeContext = new AdminHomeContext();
        adminHomeContext.setListAdminsLink(createListAdminsLink());
        adminHomeContext.setListTeachersLink(createListTeachersLink());
        adminHomeContext.setListCoursesLink(createListCoursesLink());
        adminHomeContext.setListMajorsLink(createListMajorsLink());
        adminHomeContext.setListThesisTypesLink(createListThesisTypesLink());
        return adminHomeContext;
    }

    private ThesisLink createListAdminsLink() {
        ThesisLink thesisLink = new ThesisLink();
        thesisLink.setUrl(UrlProvider.LIST_ADMINS_URL);
        thesisLink.setMessage(new Message(MESSAGES_ADMIN_HOMEPAGE_LIST_ADMINS));
        return thesisLink;
    }

    private ThesisLink createListTeachersLink() {
        ThesisLink thesisLink = new ThesisLink();
        thesisLink.setUrl(UrlProvider.LIST_TEACHERS_URL);
        thesisLink.setMessage(new Message(MESSAGES_ADMIN_HOMEPAGE_LIST_TEACHERS));
        return thesisLink;
    }

    private ThesisLink createListCoursesLink() {
        ThesisLink thesisLink = new ThesisLink();
        thesisLink.setUrl(UrlProvider.LIST_COURSES_URL);
        thesisLink.setMessage(new Message(MESSAGES_ADMIN_HOMEPAGE_LIST_COURSES));
        return thesisLink;
    }

    private ThesisLink createListMajorsLink() {
        ThesisLink thesisLink = new ThesisLink();
        thesisLink.setUrl(UrlProvider.LIST_MAJORS_URL);
        thesisLink.setMessage(new Message(MESSAGES_ADMIN_HOMEPAGE_LIST_MAJORS));
        return thesisLink;
    }

    private ThesisLink createListThesisTypesLink() {
        ThesisLink thesisLink = new ThesisLink();
        thesisLink.setUrl(UrlProvider.LIST_THESIS_TYPES_URL);
        thesisLink.setMessage(new Message(MESSAGES_ADMIN_HOMEPAGE_LIST_THESIS_TYPES));
        return thesisLink;
    }
}
