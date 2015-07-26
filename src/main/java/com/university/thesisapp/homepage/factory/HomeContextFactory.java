package com.university.thesisapp.homepage.factory;

import com.university.thesisapp.dao.persistence.provider.ThesisUserAuthorityProvider;
import com.university.thesisapp.homepage.model.HomeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeContextFactory {
    @Autowired
    private ThesisUserAuthorityProvider thesisUserAuthorityProvider;

    public HomeContext create(HttpServletRequest request) {
        HomeContext homeContext = new HomeContext();
        if (isContextCreationNeeded()) {

        }
        return homeContext;
    }

    private boolean isContextCreationNeeded() {
        return !thesisUserAuthorityProvider.isAdmin();
    }
}
