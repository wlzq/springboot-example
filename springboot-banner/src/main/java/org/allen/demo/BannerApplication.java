package org.allen.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BannerApplication.class, args);

//        SpringApplication application = new SpringApplication(BannerApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

    }
}
