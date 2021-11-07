package cn.txy.controller;

import cn.txy.dto.CustomerQuery;
import cn.txy.pojo.CrmCustomer;
import cn.txy.service.CustomerService;
import cn.txy.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DictService dictService;

    @Value("${fromType}")
    private String fromTypeCode;
    @Value("${industryType}")
    private String industryTypeCode;
    @Value("${levelType}")
    private String levelTypeCode;

    @RequestMapping("/customerList")
    public String showCustomerList(Model model, CustomerQuery customerQuery) {
        PageInfo<CrmCustomer> pageInfo = customerService.selectCustomerList(customerQuery);
        model.addAttribute("customers", pageInfo.getList());    // 详细列表
        model.addAttribute("pages", pageInfo.getPages());    // pageNavigation.jsp
        model.addAttribute("customerQuery", customerQuery);   // 回显, 这句可以不写, 会自动放入

        //显示三个下拉菜单的options
        model.addAttribute("fromType", dictService.selectDictByTypeCode(fromTypeCode));
        model.addAttribute("industryType", dictService.selectDictByTypeCode(industryTypeCode));
        model.addAttribute("levelType", dictService.selectDictByTypeCode(levelTypeCode));

        return "customer";
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public CrmCustomer customerEdit(Long id) {
        return customerService.selectCustomerById(id);
    }

    @RequestMapping(value = "/customer/update", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String customerUpdate(CrmCustomer customer) {
        if (customerService.updateCustomer(customer)) {
            return "{\"msg\":\"更新成功\"}";
        }
        return "{\"msg\":\"更新失败!\"}";
    }

    @RequestMapping(value = "/customer/delete", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String customerDelete(Long id) {
        if (customerService.deleteCustomerById(id)) {
            return "{\"msg\":\"删除成功\"}";
        }
        return "{\"msg\":\"删除失败!\"}";
    }

}