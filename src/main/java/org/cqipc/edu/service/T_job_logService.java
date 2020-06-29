package org.cqipc.edu.service;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_job_log;
import org.cqipc.edu.bean.T_login_log;
import org.cqipc.edu.controller.SystemServiceLog;

import java.util.List;

public interface T_job_logService {
    @SystemServiceLog(description = "添加测试")
    public int addLog(T_job_log t_job_log);

    public int addLoginLog(T_login_log t_login_log);
    public List<T_job_log> selectJobLog(@Param("pageCount")int pageCount,
                                        @Param("pageSize")int pageSize);
    public int selectJobLogCount();

    public List<T_login_log> selectLoginLog(@Param("pageCount")int pageCount,
                                            @Param("pageSize")int pageSize);
    public int selectLoginLogCount();
}
