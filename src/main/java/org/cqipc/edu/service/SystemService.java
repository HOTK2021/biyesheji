package org.cqipc.edu.service;

import org.cqipc.edu.bean.T_plague;
import org.cqipc.edu.bean.T_plague_info;
import org.cqipc.edu.bean.T_plague_user;
import org.cqipc.edu.bean.T_user;

import java.math.BigInteger;
import java.util.List;

public interface SystemService {
    public List<T_plague> selectPlauge();
    public List<T_plague_info> selectPlaugeInfo();
    public int selectPlaugeInfoCount();
    //查询生簿中非公职人员用于瘟疫中随机死去
    public List<T_user> selectUserToPlauge();
    public int selectUserToPlaugeCount();
    //发布瘟疫后向瘟疫信息表中添加
    public int addPlague(T_plague_info t_plague_info);
    public int addPlagueUser(List<T_plague_user> list);
    public List<T_plague_user> selectPlagueUser(int plague_info_id);
    //----------------
    public List<T_user>selectUser1(List<BigInteger> list);
}
