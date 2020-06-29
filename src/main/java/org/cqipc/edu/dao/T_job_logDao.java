package org.cqipc.edu.dao;

import org.cqipc.edu.bean.T_job_log;
import org.cqipc.edu.bean.T_login_log;

import java.util.List;

public interface T_job_logDao {
    public int addLog(T_job_log t_job_log);
    public int addLoginLog(T_login_log t_login_log);
    public List<T_job_log> selectJobLog();
    public int selectJobLogCount();
    public List<T_login_log> selectLoginLog();
    public int selectLoginLogCount();

}
