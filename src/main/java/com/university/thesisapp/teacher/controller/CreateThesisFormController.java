package com.university.thesisapp.teacher.controller;

import com.university.thesisapp.teacher.context.ThesisForm;
import com.university.thesisapp.web.provider.UrlProvider;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * Created by Gábor on 2015.08.05..
 */
@Controller
public class CreateThesisFormController extends SimpleFormController{
    public CreateThesisFormController(){
        setCommandClass(ThesisForm.class);
        setCommandName("command");
    }
    @Autowired
    private CreateThesisControllerViewResolver createThesisControllerViewResolver;

    @RequestMapping(value = UrlProvider.CREATE_THESIS_PAGE_URL, method = RequestMethod.POST)
    public ModelAndView handleCreateThesisForm(Object command, BindException errors, Model model, HttpServletRequest request) {
        ThesisForm thesisForm = (ThesisForm) command;
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getTitleEnInput());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getTitleHuInput());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getRequiredSemestersInput());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getCourseIds().toString());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getThesisTypeInput());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getDescriptionEnInput());
        LoggerFactory.getLogger(CreateThesisController.class).info(thesisForm.getDescriptionHuInput());
        return createThesisControllerViewResolver.resolveCreationView(model);
    }
}
