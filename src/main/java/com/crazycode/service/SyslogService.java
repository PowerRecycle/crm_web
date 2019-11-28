package com.crazycode.service;

import com.crazycode.pojo.Syslog;

import java.util.List;

/**
 * SyslogService
 *
 * @author Power
 */
public interface SyslogService {
    /**
     * 查找所有日志
     *
     * @return
     * @throws Exception
     */
    List<Syslog> findAllSyslogs() throws Exception;

    /**
     * 添加日志
     *
     * @return
     * @throws Exception
     */
    int addSyslog(Syslog syslog) throws Exception;
}
