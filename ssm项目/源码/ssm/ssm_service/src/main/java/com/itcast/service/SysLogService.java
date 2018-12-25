package com.itcast.service;

import com.itcast.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void saveLog(SysLog sysLog);

    List<SysLog> findAll();
}
