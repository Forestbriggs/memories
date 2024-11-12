package learn.memories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.memories.ui.Controller;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");

        Controller controller = context.getBean(Controller.class);

        // And so it begins
        controller.run();
    }
}
