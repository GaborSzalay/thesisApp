package com.university.thesisapp.web.url;

import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.11..
 */
@Component
public class ThesisUrlProvider implements UrlProvider {
    private String indexUrl;
    private String registrationUrl;

    @Override
    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    @Override
    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }
}
