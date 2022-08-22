package com.imooc.o2o.web.superadmin;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.apache.commons.collections.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = (Logger) LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listArea() {
        logger.info("===start===");
        long startTime = System.currentTimeMillis();
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
        logger.error("test error");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("===end===");
        return modeMap;
    }
}
