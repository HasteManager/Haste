package com.haste.Service;

import com.haste.Pojo.OnlinePlayerInfo;


import java.util.List;

/**
 * 作者：臧立昆
 * 2020/10/9 14:35
 */


public interface PlayerService {

    //查询在线玩家信息
    List<OnlinePlayerInfo> getInfo(Integer PageNum,Integer PageSize);

    //查询在线玩家数量
    public Integer Count();

    //根据角色名字修改角色种族、脸
    Integer ChangeCharRace(String charname, String password, Integer race, Integer face);

    Integer CountChars();

    Integer changeName(String oldName, String newName);
}
