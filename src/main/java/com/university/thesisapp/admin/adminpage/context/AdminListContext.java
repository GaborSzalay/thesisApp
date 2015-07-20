package com.university.thesisapp.admin.adminpage.context;

import com.university.thesisapp.dao.persistence.model.ThesisUser;

import java.util.List;

/**
 * Created by Gábor on 2015.07.20..
 */
public class AdminListContext {
    List<ThesisUser> admins;

    public List<ThesisUser> getAdmins() {
        return admins;
    }

    public void setAdmins(List<ThesisUser> admins) {
        this.admins = admins;
    }
}
