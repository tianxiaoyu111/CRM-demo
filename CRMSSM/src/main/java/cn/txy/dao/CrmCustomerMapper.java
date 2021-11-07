package cn.txy.dao;

import cn.txy.pojo.CrmCustomer;
import cn.txy.pojo.CrmCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmCustomerMapper {
    long countByExample(CrmCustomerExample example);

    int deleteByExample(CrmCustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CrmCustomer record);

    int insertSelective(CrmCustomer record);

    List<CrmCustomer> selectByExample(CrmCustomerExample example);

    CrmCustomer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CrmCustomer record, @Param("example") CrmCustomerExample example);

    int updateByExample(@Param("record") CrmCustomer record, @Param("example") CrmCustomerExample example);

    int updateByPrimaryKeySelective(CrmCustomer record);

    int updateByPrimaryKey(CrmCustomer record);
}