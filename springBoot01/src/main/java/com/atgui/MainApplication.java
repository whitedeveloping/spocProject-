package com.atgui;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
@SpringBootApplication来标注一个主程序类,说明是个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args){
        //启动Spring应用
        SpringApplication.run(MainApplication.class,args);
    }
}
