package com.haste.Mapper;

import com.haste.Pojo.DropInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemDropMapper {
    List<DropInfo> getAllInfo();

    Integer getAllNum();
}
