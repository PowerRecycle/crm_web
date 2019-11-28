package com.crazycode.service.impl;

import com.crazycode.mapper.SyslogMapper;
import com.crazycode.pojo.Syslog;
import com.crazycode.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SyslogServiceImpl
 *
 * @author Power
 */
@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogMapper syslogMapper;

    /**
     * 查找所有日志
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Syslog> findAllSyslogs() throws Exception {
        return syslogMapper.selectAll();
    }

    /**
     * 添加日志
     *
     * @return
     * @throws Exception
     */
    @Override
    public int addSyslog(Syslog syslog) throws Exception {
        return syslogMapper.insert(syslog);
    }
}
