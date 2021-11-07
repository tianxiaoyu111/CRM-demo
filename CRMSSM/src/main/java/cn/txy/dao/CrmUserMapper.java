package cn.txy.dao;

import cn.txy.pojo.CrmUser;
import cn.txy.pojo.CrmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmUserMapper {
    long countByExample(CrmUserExample example);

    int deleteByExample(CrmUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(CrmUser record);

    int insertSelective(CrmUser record);

    List<CrmUser> selectByExample(CrmUserExample example);

    CrmUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByExample(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByPrimaryKeySelective(CrmUser record);

    int updateByPrimaryKey(CrmUser record);
}