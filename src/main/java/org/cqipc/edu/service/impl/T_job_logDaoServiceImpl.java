package org.cqipc.edu.service.impl;

import org.cqipc.edu.bean.T_job_log;
import org.cqipc.edu.bean.T_login_log;
import org.cqipc.edu.dao.T_job_logDao;
import org.cqipc.edu.service.T_job_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("T_job_logService")
public class T_job_logDaoServiceImpl implements T_job_logService {
    @Autowired(required = false)
    T_job_logDao t_job_logDao;

    @Override
    public int addLog(T_job_log t_job_log) {
        return t_job_logDao.addLog(t_job_log);
    }

    @Override
    public int addLoginLog(T_login_log t_login_log){return t_job_logDao.addLoginLog(t_login_log);}

    @Override
    public List<T_job_log> selectJobLog() {
        return t_job_logDao.selectJobLog();
    }

    @Override
    public int selectJobLogCount() {
        return t_job_logDao.selectJobLogCount();
    }

    @Override
    public List<T_login_log> selectLoginLog() {
        return t_job_logDao.selectLoginLog();
    }

    @Override
    public int selectLoginLogCount() {
        return t_job_logDao.selectLoginLogCount();
    }
}
