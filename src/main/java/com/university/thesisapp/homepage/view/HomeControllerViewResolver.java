package com.university.thesisapp.homepage.view;

import com.university.thesisapp.dao.persistence.provider.ThesisUserAuthorityProvider;
import com.university.thesisapp.homepage.model.HomeContext;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeControllerViewResolver {
    private static final String HOME_VIEW_NAME = "home";
    private static final String CONTEXT = "context";

    @Autowired
    private ThesisUserAuthorityProvider thesisUserAuthorityProvider;

    public ModelAndView resolveView(Model model, HomeContext homeContext) {
        model.addAttribute(CONTEXT, homeContext);
        return thesisUserAuthorityProvider.isAdmin() ? createRedirectView() : createNormalView(model);
    }

    private ModelAndView createRedirectView() {
        return new ModelAndView(new RedirectView(UrlProvider.ADMIN_HOME_PAGE_URL));
    }

    private ModelAndView createNormalView(Model model) {
        return new ModelAndView(HOME_VIEW_NAME, model.asMap());
    }
}
