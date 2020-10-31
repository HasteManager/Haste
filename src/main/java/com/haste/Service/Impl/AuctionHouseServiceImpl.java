package com.haste.Service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.haste.Pojo.AuctionHouse;
import com.haste.Mapper.AuctionHouseMapper;
import com.haste.Service.AuctionHouseService;
@Service
public class AuctionHouseServiceImpl implements AuctionHouseService{

    @Resource
    private AuctionHouseMapper auctionHouseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return auctionHouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AuctionHouse record) {
        return auctionHouseMapper.insert(record);
    }

    @Override
    public int insertSelective(AuctionHouse record) {
        return auctionHouseMapper.insertSelective(record);
    }

    @Override
    public AuctionHouse selectByPrimaryKey(Integer id) {
        return auctionHouseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuctionHouse record) {
        return auctionHouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuctionHouse record) {
        return auctionHouseMapper.updateByPrimaryKey(record);
    }

}
