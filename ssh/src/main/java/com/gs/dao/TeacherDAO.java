package com.gs.dao;

import com.gs.bean.Teacher;

import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {

    void saveClasses(Long teacherId, List<Long> classIds);

}
