package cn.txy.service;

import cn.txy.dto.CustomerQuery;
import cn.txy.pojo.CrmCustomer;
import com.github.pagehelper.PageInfo;

public interface CustomerService {
    PageInfo<CrmCustomer> selectCustomerList(CustomerQuery customerQuery);

    CrmCustomer selectCustomerById(Long id);

    boolean updateCustomer(CrmCustomer customer);

    boolean deleteCustomerById(Long id);
}
