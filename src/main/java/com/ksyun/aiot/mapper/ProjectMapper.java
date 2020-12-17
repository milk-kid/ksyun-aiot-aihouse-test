package com.ksyun.aiot.mapper;


import com.ksyun.aiot.entity.Project;

import java.util.List;

public interface ProjectMapper {
    List<Project> selectByProjectName(String projectName);

    void deleteById(int projectId);
}