package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
@SpringBootApplication
public class EmInfoCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EmInfoCrawlerApplication.class);
        application.run(args);
    }
}
