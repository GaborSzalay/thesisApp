package com.university.thesisapp.createaccount.controller;

import com.university.thesisapp.createaccount.context.CreateAccountContext;
import com.university.thesisapp.createaccount.context.CreateAccountContextFactory;
import com.university.thesisapp.createaccount.view.CreateAccountViewResolver;
import com.university.thesisapp.dao.persistence.dao.ThesisUserDao;
import com.university.thesisapp.dao.persistence.model.ThesisUser;
import com.university.thesisapp.homepage.controller.EmailSenderService;
import com.university.thesisapp.util.Validation;
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
    private EmailSenderService emailSenderService;
    @Autowired
    ThesisUserDao thesisUserDao;

    @RequestMapping(value = UrlProvider.CREATE_ACCOUNT_URL, method = RequestMethod.POST)
    public ModelAndView createAccount(HttpServletRequest request, Model model) {
        CreateAccountContext createAccountContext = createAccountContextFactory.create(request);
        createAccountService.registerStudent(createAccountContext);
        emailSenderService.sendMailAfterRegistration(createAccountContext, request);
        return createAccountViewResolver.resolveView(model);
    }

    @RequestMapping(value = UrlProvider.CREATE_ACCOUNT_URL, method = RequestMethod.GET)
    public ModelAndView activateAccount(HttpServletRequest request, Model model) {
        String verificationToken = request.getParameter("verification");
        if (Validation.notEmpty(verificationToken)) {
            ThesisUser thesisUser = thesisUserDao.enableUserByToken(verificationToken);
            if (Validation.notEmpty(thesisUser)) {
                request.getSession().setAttribute("email", thesisUser.getEmail());
            }

        }
        return createAccountViewResolver.resolveViewActivationView(model);
    }
}
