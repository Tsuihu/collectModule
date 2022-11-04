package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.BoxDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {

    @Autowired
    BoxDao boxDao;

    /**
     * 查询所有箱子
     * @param pointId
     * @return allBox
     */
    @Override
    public List<Box> getAllBox(Integer pointId) {
        List<Box> allBox = boxDao.getAllBox(pointId);
        return allBox;
    }

    /**
     * 开箱操作
     * @param box boxCode,collectorId,pointId
     */
    @Override
    public void addBox(Box box) throws BusinessException {
        Box boxCode = boxDao.getBoxCode(box.getBoxCode());
        if (StringUtils.isEmpty(boxCode)){
            boxDao.addBox(box);
        }
        else {
            throw new BusinessException("转运箱编码已存在，请重新输入", ResultCodeEnum.ERROR);
        }
    }

    /**
     * 封箱操作
     * @param box status,closeTime
     */
    @Override
    public void closeBox(Box box) {
        boxDao.closeBox(box);
    }
}
