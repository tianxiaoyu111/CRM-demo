package cn.txy.controller;

import cn.txy.pojo.CrmDict;
import cn.txy.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController {
    @Autowired
    private DictService service;

    @GetMapping("selectDictByTypeCode/{code}")
    public List<CrmDict> selectDictByTypeCode(@PathVariable String code) {
        return service.selectDictByTypeCode(code);
    }
}
