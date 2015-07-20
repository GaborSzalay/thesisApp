package com.university.thesisapp.admin.adminpage.context;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.20..
 */
@Component
public class AdminListContextFactory {
    @Autowired
    private ThesisUserDao thesisUserDao;

    public AdminListContext create() {
        AdminListContext adminListContext = new AdminListContext();
        adminListContext.setAdmins(thesisUserDao.getThesisUsersByAuthority(ThesisAuthority.ADMIN));
        return adminListContext;
    }
}
