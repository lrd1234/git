package com.itcast.dao;

import com.itcast.domain.SysLog;

import java.util.List;

public interface SysLogDao {

    void saveLog(SysLog sysLog);

    List<SysLog> findAll();
}
