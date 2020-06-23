package org.cqipc.edu.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_mingjie_lifeanddie;
import org.cqipc.edu.bean.T_user_ov;

import java.util.List;

public interface T_mingjie_lifeanddieDao {
    public int addLifeAndDie(T_mingjie_lifeanddie t_mingjie_lifeanddie);
    public List<T_user_ov> selectLifeAndDie(@Param("user_id") int user_id,
                                            @Param("username") String username,
                                            @Param("pageCount")int pageCount,
                                            @Param("pageSize")int pageSize);
    public  int selectLifeAndDieCount(@Param("user_id") int user_id,
                                      @Param("username") String username);

}
