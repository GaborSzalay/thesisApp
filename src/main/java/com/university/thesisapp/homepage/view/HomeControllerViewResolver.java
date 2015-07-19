package com.university.thesisapp.homepage.view;

import com.university.thesisapp.homepage.model.HomeContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class HomeControllerViewResolver {
    private static final String HOME_VIEW_NAME = "home";
    private static final String CONTEXT = "context";

    public ModelAndView resolveView(HttpServletRequest request, Model model, HomeContext homeContext) {
        model.addAttribute(CONTEXT, homeContext);
        return new ModelAndView(HOME_VIEW_NAME, model.asMap());
    }
}
