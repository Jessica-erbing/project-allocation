package com.usydcapstone.allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.usydcapstone"})
public class ProjectAllocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectAllocationApplication.class, args);
    }


//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
////        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
//        return interceptor;
//    }
}
