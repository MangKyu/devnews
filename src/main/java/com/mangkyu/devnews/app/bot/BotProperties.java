/*
 *
 *  BotProperties.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot;

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
@ConfigurationProperties(prefix = "openapi.bot")
public class BotProperties {

    private int id;
    private String secret;

}
