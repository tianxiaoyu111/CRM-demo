package cn.txy.service;

import cn.txy.dto.CustomerQuery;
import cn.txy.pojo.CrmCustomer;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("customer-service")
public interface FeignApiCustomer {

    @PostMapping("selectCustomerList")
    PageInfo<CrmCustomer> selectCustomerList(@RequestBody CustomerQuery customerQuery);

    @GetMapping("selectCustomerById/{id}")
    CrmCustomer selectCustomerById(@PathVariable("id") Long id);

    @PostMapping("updateCustomer")
    boolean updateCustomer(@RequestBody CrmCustomer customer);

    @GetMapping("deleteCustomerById/{id}")
    boolean deleteCustomerById(@PathVariable("id") Long id);
}
