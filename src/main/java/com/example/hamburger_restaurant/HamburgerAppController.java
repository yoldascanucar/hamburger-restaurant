    package com.example.hamburger_restaurant;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class HamburgerAppController implements CommandLineRunner {
        public static void main(String[] args) {
            SpringApplication.run(HamburgerAppController.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
            System.out.println("http://localhost:8080/login");
        }
    }
