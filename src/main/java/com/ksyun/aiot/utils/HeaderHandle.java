package com.ksyun.aiot.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "header")
public class HeaderHandle {
    String aiot_token;
    String account;
    String account_type;
}
