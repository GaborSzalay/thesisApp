package com.university.thesisapp.teacher.context;

import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.26..
 */
@Component
public class TeacherMenuContextFactory {
    public TeacherMenuContext create() {
        TeacherMenuContext teacherMenuContext = new TeacherMenuContext();
        teacherMenuContext.setCreateThesisLink(UrlProvider.CREATE_THESIS_PAGE_URL);
        teacherMenuContext.setListOwnThesisesLink(UrlProvider.TEACHER_OWN_THESIS_LIST_PAGE_URL);
        return teacherMenuContext;
    }
}
