package cn.txy.service.impl;

import cn.txy.dao.CrmCustomerMapper;
import cn.txy.dao.CrmDictMapper;
import cn.txy.dto.CustomerQuery;
import cn.txy.pojo.CrmCustomer;
import cn.txy.pojo.CrmCustomerExample;
import cn.txy.pojo.CrmDict;
import cn.txy.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CrmCustomerMapper customerMapper;

    @Autowired
    private CrmDictMapper dictMapper;

    @Override
    public PageInfo<CrmCustomer> selectCustomerList(CustomerQuery customerQuery) {
        // 1.构造条件对象
        CrmCustomerExample crmCustomerExample = new CrmCustomerExample();
        CrmCustomerExample.Criteria criteria = crmCustomerExample.createCriteria();
        // 2.添加4个查询参数
        //模糊匹配
        if (StringUtils.isNotEmpty(customerQuery.getCustName())) {
            criteria.andCustNameLike("%" + customerQuery.getCustName() + "%");
        }
        //行业
        if (StringUtils.isNotEmpty(customerQuery.getCustIndustry())) {
            criteria.andCustIndustryEqualTo(customerQuery.getCustIndustry());
        }
        //来源
        if (StringUtils.isNotEmpty(customerQuery.getCustSource())) {
            criteria.andCustSourceEqualTo(customerQuery.getCustSource());
        }
        //级别
        if (StringUtils.isNotEmpty(customerQuery.getCustLevel())) {
            criteria.andCustLevelEqualTo(customerQuery.getCustLevel());
        }
        // 3.PageHelper拦截sql语句, 通过页号和每页条数它就可以算出limit x,y
        PageHelper.startPage(customerQuery.getPage(), customerQuery.getSize());
        // 4.查询
        List<CrmCustomer> customers = customerMapper.selectByExample(crmCustomerExample);
        // 5.遍历customers, 将每个元素的三个dict_id改为对应名称
        convertCustomers(customers);
        // 6.封装结果, 带上分页的信息
        PageInfo<CrmCustomer> pageInfo = new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public CrmCustomer selectCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateCustomer(CrmCustomer customer) {
        return customerMapper.updateByPrimaryKey(customer) > 0;
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        return customerMapper.deleteByPrimaryKey(id) > 0;
    }

    private void convertCustomers(List<CrmCustomer> customers) {
        // 将字段从ID更新为ItemName
        for (CrmCustomer customer : customers) {
            CrmDict sourceDict = dictMapper.selectByPrimaryKey(customer.getCustSource());
            CrmDict industryDict = dictMapper.selectByPrimaryKey(customer.getCustIndustry());
            CrmDict levelDict = dictMapper.selectByPrimaryKey(customer.getCustLevel());

            customer.setCustSource(sourceDict.getDictItemName());
            customer.setCustIndustry(industryDict.getDictItemName());
            customer.setCustLevel(levelDict.getDictItemName());
        }
    }


}