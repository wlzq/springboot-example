package org.allen.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
//        默认启动时输出banner 内容为spring字样
//        如果想输出自己的字样，需要在resource目录下创建banner.txt 并在里边输入自己的字样
//        可以在一下第三方网站转换，拷贝到banner.txt
//        1：字样转换http://www.network-science.de/ascii/
//        2：图片转换http://www.degraeve.com/img2txt.php
      SpringApplication.run(BannerApplication.class, args);

//        启动禁止输出banner
//        SpringApplication application = new SpringApplication(BannerApplication.class);
//        Banner.Mode
//        /OFF：Disable printing of the banner.
//        /LOG：Print the banner to the log file.
//        /CONSOLE：Print the banner to System.out.
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

    }
}
