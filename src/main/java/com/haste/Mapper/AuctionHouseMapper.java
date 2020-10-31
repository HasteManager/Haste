package com.haste.Mapper;

import com.haste.Pojo.AuctionHouse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuctionHouseMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(AuctionHouse record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(AuctionHouse record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    AuctionHouse selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AuctionHouse record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AuctionHouse record);
}