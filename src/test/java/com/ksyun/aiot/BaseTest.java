package com.ksyun.aiot;


import cn.hutool.http.HttpRequest;
import com.ksyun.aiot.callback.EventListener;
import com.ksyun.aiot.callback.EventSource;
import com.ksyun.aiot.utils.RequestProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ksyun.aiot.callback.EventObject;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    EventSource eventSource;
    @Autowired
    RequestProperties requestProperties;
    final static Map<String,String> head= new HashMap<>();


    @BeforeClass
    public void setUp() {
        head.put("ACCOUNT", requestProperties.getAccount());
        head.put("ACCOUNT_TYPE", requestProperties.getAccount_type());
        head.put("Content-Type", "application/json");
        head.put("AIOT_TOKEN", requestProperties.getAiot_token());

    }
}

