package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Area;

import java.util.List;

/**
 * @Author: zxw
 * @Date: Created in 19:31 2022/8/11
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * **/
    List<Area> queryArea();
}
