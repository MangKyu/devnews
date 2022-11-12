package com.mangkyu.devnews.config.feign;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ImportAutoConfiguration({
        FeignConfig.class,
        FeignAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
})
public @interface FeignTest {

}