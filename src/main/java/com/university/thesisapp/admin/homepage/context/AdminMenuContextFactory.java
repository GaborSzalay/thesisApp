package com.university.thesisapp.admin.homepage.context;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.19..
 */
@Component
public class AdminMenuContextFactory {

    public AdminMenuContext create() {
        AdminMenuContext adminMenuContext = new AdminMenuContext();
        adminMenuContext.setListAdminsLink(UrlProvider.LIST_ADMINS_URL);
        adminMenuContext.setListTeachersLink(UrlProvider.LIST_TEACHERS_URL);
        adminMenuContext.setListStudentsLink(UrlProvider.LIST_STUDENTS_URL);
        adminMenuContext.setListCoursesLink(UrlProvider.LIST_COURSES_URL);
        adminMenuContext.setListMajorsLink(UrlProvider.LIST_MAJORS_URL);
        return adminMenuContext;
    }

}
