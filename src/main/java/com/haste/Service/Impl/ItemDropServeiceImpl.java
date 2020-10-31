package com.haste.Service.Impl;

import com.haste.Mapper.ItemDropMapper;
import com.haste.Pojo.DropInfo;
import com.haste.Service.ItemDropServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：臧立昆
 * 2020/10/14 18:53
 */

@Service
public class ItemDropServeiceImpl implements ItemDropServeice {

    @Autowired
    ItemDropMapper itemDropMapper;

    @Override
    public List<DropInfo> getAllInfo(Integer pageNum, Integer pageSize) {
        return itemDropMapper.getAllInfo();
    }

    @Override
    public Integer getAllNum() {
        return itemDropMapper.getAllNum();
    }
}
