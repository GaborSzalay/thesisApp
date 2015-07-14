package com.university.thesisapp.web.cookie;

import com.university.thesisapp.ThesisAuthority;
import com.university.thesisapp.util.Validation;
import com.university.thesisapp.web.provider.CookieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gábor on 2015.07.15..
 */
@Component
public class UserCookieManager {
    @Autowired
    private CookieValueProvider cookieValueProvider;

    public void createUserCookie(HttpServletRequest request, HttpServletResponse response, ThesisAuthority thesisAuthority) {
        final String thesisAuthorityName = thesisAuthority.toString();
        Cookie userCookie = cookieValueProvider.findCookie(request, CookieProvider.USER);

        if (Validation.Empty(userCookie)) {
            response.addCookie(createNewUserCookie(thesisAuthorityName));
        } else {
            if (!thesisAuthorityName.equals(userCookie.getValue())) {
                modifyExistingUserCookie(thesisAuthorityName, userCookie);
                response.addCookie(userCookie);
            }
        }
    }

    private Cookie createNewUserCookie(String thesisAuthorityName) {
        Cookie userCookie = new Cookie(CookieProvider.USER, thesisAuthorityName);
        setUpCookie(userCookie);
        return userCookie;
    }

    private void modifyExistingUserCookie(String thesisAuthorityName, Cookie userCookie) {
        userCookie.setValue(thesisAuthorityName);
        setUpCookie(userCookie);
    }

    private void setUpCookie(Cookie userCookie) {
        userCookie.setPath("/");
        userCookie.setMaxAge(31536000);
    }
}
