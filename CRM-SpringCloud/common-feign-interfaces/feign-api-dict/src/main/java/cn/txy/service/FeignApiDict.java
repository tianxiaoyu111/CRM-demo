package cn.txy.service;

import cn.txy.pojo.CrmDict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient("dict-service")
public interface FeignApiDict {

    @GetMapping("selectDictByTypeCode/{code}")
    List<CrmDict> selectDictByTypeCode(@PathVariable("code") String code);

}
