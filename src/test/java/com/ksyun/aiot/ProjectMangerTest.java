package com.ksyun.aiot;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksyun.aiot.entity.Project;
import com.ksyun.aiot.mapper.ProjectMapper;
import com.ksyun.aiot.utils.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class ProjectMangerTest extends AihouseTest {

    @Autowired
    ProjectMapper ProjectMapper;
    private static Map header;
    private ObjectMapper mapper;

    @BeforeClass
    public void setUp() {
        String headerStr = null;
        mapper = new ObjectMapper();
        try {
            headerStr = mapper.writeValueAsString(requestProperties);
            header = mapper.readValue(headerStr, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("setUp exception");
        }
    }

    @Test
    public void createProjecttest() throws JsonProcessingException {
        String url = requestProperties.getBaseUrl() + "/api/aiot-space-service/project";

        String body = HttpRequest.post(url).addHeaders(header).body("{\"projectName\":\"回归测试用\",\"projectType\":\"community\",\"squareMeter\":10,\"addressDetail\":\"啊手动阀手动阀\",\"provinceCode\":\"110000\",\"cityCode\":\"110100\",\"countryCode\":\"110101\",\"longitude\":\"116.416357\",\"latitude\":\"39.928353\"}").execute().body();
        System.out.println(body);
        ResponseBody responseBody = mapper.readValue(body, ResponseBody.class);
        Assert.assertEquals(200, responseBody.getCode());
    }

    @Test
    public void deleteProjectTest() throws JsonProcessingException {
        List result = ProjectMapper.selectByProjectName("回归测试用");
        String url = requestProperties.getBaseUrl() + "/api/ks-aihouse/project/delete?projectId=";
        String projectId="";
        for (Object o : result) {
            if (((Project) o).getProjectName() == "回归测试用") {
                projectId = ((Project) o).getId();
                break;
            }
        }
        String body = HttpRequest.post(url + projectId).body("{\"projectId\":\""+projectId+"\"}").addHeaders(header).execute().body();
        log.info("responseBody = {}",body);
        ResponseBody responseBody = mapper.readValue(body, ResponseBody.class);
        Assert.assertEquals(200,responseBody.getCode());

    }
}
