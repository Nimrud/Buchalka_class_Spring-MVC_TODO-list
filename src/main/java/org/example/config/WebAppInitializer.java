package org.example.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dyspozytor";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("onStartup called");

        // tworzymy kontekst aplikacji Springa
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        // rejestrujemy klasę WebConfig
        context.register(WebConfig.class);

        // tworzymy dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // rejestrujemy (używając nazwy własnej) i konfigurujemy dispatcher servlet
        ServletRegistration.Dynamic registration =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
