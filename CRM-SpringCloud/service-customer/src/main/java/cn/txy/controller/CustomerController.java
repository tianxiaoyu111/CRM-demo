package cn.txy.controller;

import cn.txy.dto.CustomerQuery;
import cn.txy.pojo.CrmCustomer;
import cn.txy.service.CustomerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("selectCustomerList")
    public PageInfo<CrmCustomer> selectCustomerList(@RequestBody CustomerQuery customerQuery) {
        return service.selectCustomerList(customerQuery);
    }

    @GetMapping("selectCustomerById/{id}")
    public CrmCustomer selectCustomerById(@PathVariable Long id) {
        return service.selectCustomerById(id);
    }

    @PostMapping("updateCustomer")
    public boolean updateCustomer(@RequestBody CrmCustomer customer) {
        return service.updateCustomer(customer);
    }

    @GetMapping("deleteCustomerById/{id}")
    public boolean deleteCustomerById(@PathVariable Long id) {
        return service.deleteCustomerById(id);
    }
}
