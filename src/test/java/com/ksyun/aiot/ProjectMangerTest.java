package com.ksyun.aiot;

import cn.hutool.http.HttpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksyun.aiot.entity.Project;
import com.ksyun.aiot.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class ProjectMangerTest extends AihouseTest {

    @Autowired
    ProjectMapper mapper;

    @Test
    public void createProjecttest() throws JsonProcessingException {
        String url = requestProperties.getBaseUrl()+"/api/aiot-space-service/project";
        ObjectMapper mapper = new ObjectMapper();
        String head = mapper.writeValueAsString(requestProperties);
        Map map = mapper.readValue(head, Map.class);
        String body = HttpRequest.post(url).addHeaders(map).body("{\"projectName\":\"回归测试用\",\"projectType\":\"community\",\"squareMeter\":10,\"addressDetail\":\"啊手动阀手动阀\",\"provinceCode\":\"110000\",\"cityCode\":\"110100\",\"countryCode\":\"110101\",\"longitude\":\"116.416357\",\"latitude\":\"39.928353\"}").execute().body();

        log.info(body);
    }

    @Test
    public void testMapper(){
       List result = mapper.selectByProjectName("酒店");
        for (Object o : result) {
            System.out.println(((Project) o).getProjectName());
        }
    }
}
