package com.imooc.o2o.web.superadmin;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.apache.commons.collections.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modeMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<Area>();
        try {
            list = areaService.getAreaList();
            modeMap.put("rows", list);
            modeMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modeMap.put("success",false);
            modeMap.put("errMsg",e.toString());
        }
        return modeMap;
    }
}
