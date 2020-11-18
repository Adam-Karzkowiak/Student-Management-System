package app;

import app.configuration.Config;
import app.presentation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Run {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ControllerMenu controllerMenu = context.getBean("controllerMenu", ControllerMenu.class);
        controllerMenu.callLoginMenu();

    }
}