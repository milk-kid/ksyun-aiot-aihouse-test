package com.ksyun.aiot;


import cn.hutool.http.HttpRequest;
import com.ksyun.aiot.callback.EventListener;
import com.ksyun.aiot.callback.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ksyun.aiot.callback.EventObject;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
class AihouseTestApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    EventSource eventSource;

    @BeforeTest
    public void setUp() {

    }

    @Test
    public void turnoff() {
        String url = "http://dev.gaea.ksyun.com/api/ks-aihouse/device/switch?deviceId=mi.01001.light.2.efef99f2-9e81-4b74-a778-e085a08d020c&switchOn=1";
        Map<String, String> head = new HashMap<>();
        head.put("ACCOUNT", "ksaihouse");
        head.put("ACCOUNT_TYPE", "ksc");
        head.put("Content-Type", "application/json");
        head.put("AIOT_TOKEN", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiIyMDAwMDk3NjM2IiwiY29ycElkIjoxMDAwMywibG9naW5OYW1lIjoiMTYwNzMyNzMyMzE0OSIsInR5cGUiOiJ3ZWIiLCJ1c2VyTmFtZSI6InRlc3RhaWhvdXNlIiwiZXhwIjoxNjA4NjIzMzIzLCJpYXQiOjE2MDczMjczMjMsImFjY291bnQiOiJ0ZXN0YWlob3VzZSIsImFpaG91c2UiOiJob2xkX215X2JlZXIifQ.XXA0iFSEwidojgGki6TzNgRFK90JEp4WISsgGWbGoQ4\"");
        String body = HttpRequest.get(url).addHeaders(head).execute().body();
        log.info("response = {}", body);

         Temp temp = new Temp();

        eventSource.addListener(new EventListener() {


            @Override
            public void handle(EventObject eventObject) {
//                eventObject.parseBody()
                temp.setCount(temp.getCount()+1);
                if(temp.getCount()>=5){
                    temp.setFlag(false);
                }

                log.info("eventObject = {}", eventObject);

            }
        });

        while (temp.getFlag()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }


        }

    }
}
class Temp{
   private  int count=0;
   private boolean flag = true;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}