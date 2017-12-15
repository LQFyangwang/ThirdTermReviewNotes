package com.gs.service;

import com.gs.bean.Teacher;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {

    void saveClasses(Long teacherId, String classIds);

}
