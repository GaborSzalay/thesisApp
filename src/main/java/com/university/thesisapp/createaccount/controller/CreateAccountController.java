package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.createaccount.context.CreateAccountContext;
import com.university.thesisapp.createaccount.context.CreateAccountContextFactory;
import com.university.thesisapp.createaccount.view.CreateAccountViewResolver;
import com.university.thesisapp.homepage.controller.EmailSenderService;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gábor on 2015.07.07..
 */
@Controller
public class CreateAccountController {

    @Autowired
    private CreateAccountContextFactory createAccountContextFactory;
    @Autowired
    private CreateAccountViewResolver createAccountViewResolver;
    @Autowired
    private CreateAccountService createAccountService;
    @Autowired
    EmailSenderService emailSenderService;

    @RequestMapping(value = UrlProvider.CREATE_ACCOUNT_URL, method = RequestMethod.POST)
    public ModelAndView sendCreateAccountMail(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        emailSenderService.sendMailAfterRegistration(email);
        return createAccountViewResolver.resolveView(model);
    }

    @RequestMapping(value = UrlProvider.CREATE_ACCOUNT_URL, method = RequestMethod.GET)
    public ModelAndView createAccount(HttpServletRequest request, Model model) {
        CreateAccountContext createAccountContext = createAccountContextFactory.create(request);
        createAccountService.registerStudent(createAccountContext);
        return createAccountViewResolver.resolveView(model);
    }
}
