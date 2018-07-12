package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
@SpringBootApplication
public class EmInfoCrawlerApplication {

    /**
     * 线程池
     */
    @Bean
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(3);
        executor.setKeepAliveSeconds(300);

        //设置拒绝策略
        //主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中
        executor.setRejectedExecutionHandler((r, executor1) -> executor1.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()));
        return executor;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EmInfoCrawlerApplication.class);
        application.run(args);
    }
}
