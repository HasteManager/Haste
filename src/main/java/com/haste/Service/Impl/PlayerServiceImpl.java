package com.haste.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.haste.Mapper.PlayerMapper;
import com.haste.Pojo.OnlinePlayerInfo;
import com.haste.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 作者：臧立昆
 * 2020/10/9 14:36
 */

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    // 查询在线玩家信息
    @Override
    public List<OnlinePlayerInfo> getInfo(Integer PageNum,Integer PageSize) {
        PageHelper.startPage(PageNum, PageSize);
        List<OnlinePlayerInfo> info = playerMapper.getInfo();
        String[] Jobs= {"","WAR","MNK","WHM","BLM","RDM","THF","PLD","DRK","BST","BRD","RNG","SAM","NIN","DRG","SMN","BLU","COR","PUP","DNC","SCH","GEO","RUN"};
            String[] Rank = {"Sand‘Oria","Bastok","Windurst"};
        String[] Race = {"人类 ♂","人类 ♀","精灵 ♂","精灵 ♀","矮人 ♂","矮人 ♀","猫♀","卡鲁"};
        Integer[] RankLevel;
        for (OnlinePlayerInfo onlinePlayerInfo : info) {
            //RankLevel= [Integer.parseInt(onlinePlayerInfo.getRank_bastok()),Integer.parseInt(onlinePlayerInfo.getRank_sandoria()),Integer.parseInt(onlinePlayerInfo.getRank_windurst())]
            RankLevel= new Integer[]{Integer.parseInt(onlinePlayerInfo.getRank_bastok()), Integer.parseInt(onlinePlayerInfo.getRank_sandoria()), Integer.parseInt(onlinePlayerInfo.getRank_windurst())};
            //RankLevel= new String[]{onlinePlayerInfo.getRank_bastok(), onlinePlayerInfo.getRank_sandoria(), onlinePlayerInfo.getRank_windurst()};
            onlinePlayerInfo.setMjob(Jobs[Integer.parseInt(onlinePlayerInfo.getMjob())]);
            onlinePlayerInfo.setSjob(Jobs[Integer.parseInt(onlinePlayerInfo.getSjob())]);
            Integer nation = Integer.valueOf(onlinePlayerInfo.getNation());
            Optional<Integer> max = Arrays.stream(RankLevel).max(Integer::compareTo);
            //onlinePlayerInfo.setNation(Rank[nation]+" ："+max.get());
            onlinePlayerInfo.setNation(Rank[nation]);
            if(onlinePlayerInfo.getPartyid() == null){
                onlinePlayerInfo.setPartyid("未组队");
            }else {
                onlinePlayerInfo.setPartyid("组队中  队伍号:"+onlinePlayerInfo.getPartyid());
            }
            onlinePlayerInfo.setRace(Race[(Integer.parseInt(onlinePlayerInfo.getRace())-1)]);
            onlinePlayerInfo.setPos_zone(onlinePlayerInfo.getPos_zone().replace("_"," "));
        }
        return info;
    }

    @Override
    public Integer Count() {
        return playerMapper.Count();
    }

    @Override
    public Integer ChangeCharRace(String charname, String password, Integer race, Integer face) {
        return playerMapper.ChangeCharRace(charname,password,race,face);
    }

    @Override
    public Integer CountChars() {
        return playerMapper.CountChars();
    }

    @Override
    public Integer changeName(String oldName, String newName) {
        return playerMapper.changeName( oldName,  newName);
    }
}
