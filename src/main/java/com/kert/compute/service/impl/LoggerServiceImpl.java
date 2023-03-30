package com.kert.compute.service.impl;

import com.kert.compute.dao.LogMapper;
import com.kert.compute.model.entity.LogInfo;
import com.kert.compute.service.LoggerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerSer {
    @Autowired
    private LogMapper logMapper;
    @Override
    public void insert(LogInfo logInfo) {
        logMapper.insert(logInfo);
    }
}
