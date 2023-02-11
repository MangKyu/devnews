package com.mangkyu.devnews.system.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("!test")
@Service
public @interface RealService {
}
