package com.haste.Service;

import com.haste.Pojo.DropInfo;

import java.util.List;

public interface ItemDropServeice {

    List<DropInfo> getAllInfo(Integer pageNum, Integer pageSize);

    Integer getAllNum();
}
