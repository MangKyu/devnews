package com.mangkyu.devnews.app.message;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.member.MemberConfiguration;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import com.mangkyu.system.TestActiveProfile;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestActiveProfile
@SpringBootTest(classes = {MessageConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class, MemberConfiguration.class})
public @interface MessageTestConfig {

}
