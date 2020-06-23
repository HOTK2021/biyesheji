package org.cqipc.edu.service.impl;

import org.cqipc.edu.bean.T_plague;
import org.cqipc.edu.bean.T_plague_info;
import org.cqipc.edu.bean.T_plague_user;
import org.cqipc.edu.bean.T_user;
import org.cqipc.edu.dao.T_plagueDao;
import org.cqipc.edu.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SystemService")
public class SystemServiceImpl implements SystemService {
    @Autowired(required = false)
    T_plagueDao tp;


    @Override
    public List<T_plague> selectPlauge() {
        return tp.selectPlauge();
    }

    @Override
    public List<T_plague_info> selectPlaugeInfo() {
        return tp.selectPlaugeInfo();
    }

    @Override
    public int selectPlaugeInfoCount() {
        return tp.selectPlaugeInfoCount();
    }

    @Override
    public List<T_user> selectUserToPlauge() {
        return tp.selectUserToPlauge();
    }

    @Override
    public int selectUserToPlaugeCount(){
        return tp.selectUserToPlaugeCount();
    }

    @Override
    public int addPlague(T_plague_info t_plague_info) {
        return tp.addPlague(t_plague_info);
    }

    @Override
    public int addPlagueUser(List<T_plague_user> list) {
        return tp.addPlagueUser(list);
    }

    @Override
    public List<T_plague_user> selectPlagueUser(int plague_info_id){
        return tp.selectPlagueUser(plague_info_id);
    }
}
