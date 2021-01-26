package com.ksyun.aiot;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksyun.aiot.callback.EventListener;
import com.ksyun.aiot.callback.EventObject;
import com.ksyun.aiot.utils.Constant;
import com.ksyun.aiot.utils.Timekeeper;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Slf4j
public class VensiTest extends BaseTest {

    static int count = 0;


    @Test(dataProviderClass = com.ksyun.aiot.FactoryDataProvider.class, dataProvider = "csvDataProvider")
    public void switchOn(String deviceId) throws JsonProcessingException {
        count++;
        int status = count % 2;
        head.put("Content-Type", "application/json");
        String url = requestProperties.getBaseUrl() + Constant.switchDevice + "?deviceId=" + deviceId + "&switchOn=" + status;
        HttpResponse res = HttpRequest.get(url).addHeaders(head).execute();
        Assert.assertEquals(res.getStatus(), 200);


        Timekeeper timekeeper = new Timekeeper();


       /* eventSource.addListener(new EventListener() {

            @Override
            public void handle(EventObject eventObject) {

                timekeeper.setCount(timekeeper.getCount() + 1);
                if (timekeeper.getCount() >= 1) {
                    timekeeper.setFlag(false);
                }
                log.info("eventObject = {}", eventObject);
                JsonNode rootNode = eventObject.doEvent();
                log.info("rootNode={}", rootNode);
            }
        });

        while (timekeeper.getFlag() ) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
*/
    }

    @AfterMethod
    public void teardown() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


