package com.university.thesisapp.admin.adminpage.context;

import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.20..
 */
@Component
public class AdminListContextFactory {
    public AdminListContext create() {
        return new AdminListContext();
    }
}
