package com.ksyun.aiot;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksyun.aiot.entity.DevicePropertyInfo;
import com.ksyun.aiot.mapper.DevicePropertyInfoMapper;
import com.ksyun.aiot.utils.Constant;
import com.ksyun.aiot.utils.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

@Slf4j
public class VensiTest extends BaseTest {

    @Autowired
    DevicePropertyInfoMapper devicePropertyInfoMapper;
     ObjectMapper mapper = new ObjectMapper();

/*    @Test(dataProviderClass = com.ksyun.aiot.FactoryDataProvider.class, dataProvider = "csvDataProvider")
    public void switchOnSingleKeyPower(String deviceId) throws JsonProcessingException {

        if("vs.02002.switch.1.8da1e629-b36a-4813-bab3-6acbf00ab4d9".equals(deviceId)){
            turnOnOff(deviceId);
        }else {
            temController(deviceId);
        }
    }*/
    @Test(dataProviderClass = com.ksyun.aiot.FactoryDataProvider.class, dataProvider = "csvDataProvider",groups = "turnOnOff")
    private void turnOnOff(String deviceId) throws JsonProcessingException {
        DevicePropertyInfo propertyInfo = devicePropertyInfoMapper.selectById(1354333789559549953l);
        int status = (Integer.parseInt(propertyInfo.getValue())+1) % 2;
        head.put("Content-Type", "application/json");
        String url = requestProperties.getBaseUrl() + Constant.switchDevice + "?deviceId=" + deviceId + "&switchOn=" + status;
        log.info("url = {}", url);
        HttpResponse res = HttpRequest.get(url).addHeaders(head).execute();
        Assert.assertEquals(res.getStatus(), 200);

        ResponseBody responseBody = mapper.readValue(res.body(), ResponseBody.class);
        if (responseBody.getCode() != 200) {
            log.info("errorMsg = {}", responseBody.getMessage());
        }
        Assert.assertEquals(200, responseBody.getCode());
    }

    @Test(dataProviderClass = com.ksyun.aiot.FactoryDataProvider.class, dataProvider = "csvDataProvider",groups = "temController")
    public void temController(String deviceId) throws JsonProcessingException{
        DevicePropertyInfo propertyInfo = devicePropertyInfoMapper.selectById(1347463755897827329l);
        int status = (Integer.parseInt(propertyInfo.getValue())+1) % 2;
        head.put("Content-Type", "application/json");
        String url = requestProperties.getBaseUrl() + Constant.switchDevice + "?deviceId=" + deviceId + "&switchOn=" + status;
        log.info("url = {}", url);
        HttpResponse res = HttpRequest.get(url).addHeaders(head).execute();
        Assert.assertEquals(res.getStatus(), 200);

        ResponseBody responseBody = mapper.readValue(res.body(), ResponseBody.class);
        if (responseBody.getCode() != 200) {
            log.info("errorMsg = {}", responseBody.getMessage());
        }
        Assert.assertEquals(200, responseBody.getCode());
    }


    @AfterMethod
    public void teardown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
    }
}


