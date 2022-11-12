package com.mangkyu.devnews.app.accesstoken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


// do not add no-args constructor
@Getter
@Builder
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "openapi.secret")
public class AccessTokenProperties {

    private String clientId;
    private String clientSecret;
    private String grantType;
    private String scope;
    private String serviceAccount;
    private String privateKey;

}
