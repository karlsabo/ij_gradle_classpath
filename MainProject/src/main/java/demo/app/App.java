package demo.app;

import java.io.InputStream;

public class App {
    public static void main(String[] args) {
        System.out.println("Classpath=" + System.getProperty("java.class.path"));
        final String resourceName = "hello.txt";
        final InputStream resourceAsStream = App.class.getClassLoader().getResourceAsStream(resourceName);
        if (resourceAsStream == null) {
            throw new RuntimeException("Couldn't find resource " + resourceName);
        }
        System.out.println("Everything ran a-ok!");
    }
}
