package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.web.provider.UrlProvider;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gábor on 2015.08.05..
 */
@Controller
public class CreateThesisFormController {

    @Autowired
    private CreateThesisControllerViewResolver createThesisControllerViewResolver;

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateThesisForm(Model model, HttpServletRequest request) {
        String titleHuInput = request.getParameter("titleHuInput");
        String titleEnInput = request.getParameter("titleEnInput");
        String thesisTypeInput = request.getParameter("thesisTypeInput");
        String[] courseIdss = request.getParameterValues("courseIds");
        String requiredSemestersInput = request.getParameter("requiredSemestersInput");
        String descriptionHuInput = request.getParameter("descriptionHuInput");
        String descriptionEnInput = request.getParameter("descriptionEnInput");
        List<String> courseIdList = Arrays.asList(courseIdss);


        LoggerFactory.getLogger(CreateThesisController.class).info(titleHuInput);
        LoggerFactory.getLogger(CreateThesisController.class).info(titleEnInput);
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisTypeInput);
        LoggerFactory.getLogger(CreateThesisController.class).info(courseIdList.toString());
        LoggerFactory.getLogger(CreateThesisController.class).info(requiredSemestersInput);
        LoggerFactory.getLogger(CreateThesisController.class).info(descriptionHuInput);
        LoggerFactory.getLogger(CreateThesisController.class).info(descriptionEnInput);

        return createThesisControllerViewResolver.resolveCreationView(model);
    }
}
