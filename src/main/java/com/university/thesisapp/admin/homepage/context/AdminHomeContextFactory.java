package com.university.thesisapp.admin.homepage.context;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.19..
 */
@Component
public class AdminHomeContextFactory {

    public AdminHomeContext create() {
        AdminHomeContext adminHomeContext = new AdminHomeContext();
        adminHomeContext.setListAdminsLink(UrlProvider.LIST_ADMINS_URL);
        adminHomeContext.setListTeachersLink(UrlProvider.LIST_TEACHERS_URL);
        adminHomeContext.setListCoursesLink(UrlProvider.LIST_COURSES_URL);
        adminHomeContext.setListMajorsLink(UrlProvider.LIST_MAJORS_URL);
        adminHomeContext.setListThesisTypesLink(UrlProvider.LIST_THESIS_TYPES_URL);
        return adminHomeContext;
    }

}
