package com.university.thesisapp.teacher.context;

import org.springframework.stereotype.Component;

/**
 * Created by Gábor on 2015.07.27..
 */
@Component
public class CreateThesisContextFactory {
    public CreateThesisContext create() {
        CreateThesisContext createThesisContext = new CreateThesisContext();
        return createThesisContext;
    }
}
