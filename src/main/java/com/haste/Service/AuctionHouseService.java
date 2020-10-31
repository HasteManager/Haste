package com.haste.Service;

import com.haste.Pojo.AuctionHouse;
public interface AuctionHouseService{


    int deleteByPrimaryKey(Integer id);

    int insert(AuctionHouse record);

    int insertSelective(AuctionHouse record);

    AuctionHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuctionHouse record);

    int updateByPrimaryKey(AuctionHouse record);

}
