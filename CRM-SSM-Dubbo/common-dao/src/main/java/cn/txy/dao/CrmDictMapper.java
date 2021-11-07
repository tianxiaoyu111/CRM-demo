package cn.txy.dao;

import cn.txy.pojo.CrmDict;
import cn.txy.pojo.CrmDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmDictMapper {
    long countByExample(CrmDictExample example);

    int deleteByExample(CrmDictExample example);

    int deleteByPrimaryKey(String dictId);

    int insert(CrmDict record);

    int insertSelective(CrmDict record);

    List<CrmDict> selectByExample(CrmDictExample example);

    CrmDict selectByPrimaryKey(String dictId);

    int updateByExampleSelective(@Param("record") CrmDict record, @Param("example") CrmDictExample example);

    int updateByExample(@Param("record") CrmDict record, @Param("example") CrmDictExample example);

    int updateByPrimaryKeySelective(CrmDict record);

    int updateByPrimaryKey(CrmDict record);
}