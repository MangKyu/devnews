package com.mangkyu.devnews.app.message;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.member.MemberConfiguration;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import com.mangkyu.system.TestActiveProfile;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestActiveProfile
@AutoConfigureJson
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@EnableJpaRepositories(basePackageClasses = MemberConfiguration.class)
@EntityScan(basePackageClasses = MemberConfiguration.class)
@AutoConfigureDataJpa
@Transactional
@AutoConfigureCache
@SpringBootTest(classes = {MessageConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class, MemberConfiguration.class})
public @interface MessageTestConfig {

}
