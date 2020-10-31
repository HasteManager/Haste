package com.haste.Mapper;

import com.haste.Pojo.OnlinePlayerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：臧立昆
 * 2020/10/9 14:36
 */

@Mapper
public interface PlayerMapper {
    public List<OnlinePlayerInfo> getInfo();

    public Integer Count();

    Integer ChangeCharRace(String charname, String password, Integer race, Integer face);

    Integer CountChars();

    Integer changeName(String oldName, String newName);
}
