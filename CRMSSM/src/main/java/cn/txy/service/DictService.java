package cn.txy.service;

import cn.txy.pojo.CrmDict;

import java.util.List;

public interface DictService {
    List<CrmDict> selectDictByTypeCode(String s);
}
