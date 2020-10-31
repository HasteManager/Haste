package com.haste.Controller;

import com.haste.Pojo.LimitPage;
import com.haste.Pojo.OnlinePlayerInfo;
import com.haste.Pojo.ResultPage;
import com.haste.Service.PlayerService;
import com.haste.Utils.Name;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作者：臧立昆
 * 2020/10/9 14:22
 */

@Controller
@Slf4j
@RequestMapping("/player")
@Api(tags = "Player管理")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation(value = "在线玩家")
    @ResponseBody
    @GetMapping("/getOnline")
    public ResultPage<List<OnlinePlayerInfo>> getOnline(@ApiParam("pageNum") Integer pageNum, @ApiParam("pageSize") Integer pageSize) {
        try {
            if (pageNum == null || pageSize == null) {
                pageNum = 1;
                pageSize = 30;
            }
            List<OnlinePlayerInfo> info = playerService.getInfo(pageNum, pageSize);
            return new ResultPage<>(true, "查询成功", info, Count());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询在线人数的时候出现了错误,参数 pageNum：" + pageNum + "参数 pageSize：" + pageSize);
        }
        return new ResultPage<>(false, "查询失败", null, 0);
    }

    @ApiOperation(value = "在线玩家数量")
    @ResponseBody
    @GetMapping("/Count")
    public Integer Count() {
        return playerService.Count();
    }

    @ApiOperation(value = "修改角色种族")
    @ResponseBody
    @GetMapping("/ChangeCharRace")
    public ResultPage ChangeCharRace(@ApiParam("角色名字") String charname, @ApiParam("密码，暂时不需要") String password, @ApiParam("种族 1是男人类 2是女人类 3是男精灵 4是女经理 5是男矮子 6是女孩子 7是猫女 8是胖子") Integer Race, @ApiParam("脸") Integer Face) {
        try {
            if (Race == null || Race > 8 || Race < 1) {
                return new ResultPage(false, "非法参数：种族参数应该在1-8之间", null);
            }
            charname = charname.substring(0, 1).toUpperCase() + charname.substring(1);
            System.out.println(System.nanoTime() + " 修改过名字的玩家是:" + charname);
            playerService.ChangeCharRace(charname, password, Race, Face);
            return new ResultPage(true, "修改成功 如角色名字不存在 那么默认不生效,角色在线，角色过地图生效,角色未在线,重上即生效!", null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改种族出现了问题,参数为:");
        }
        return new ResultPage(false, "修改角色种族失败", null);
    }

    @ApiOperation(value = "总玩家数量")
    @ResponseBody
    @GetMapping("/CountChars")
    public Integer CountChars() {
        return playerService.CountChars();
    }

    @ApiOperation(value = "修改玩家角色名")
    @ResponseBody
    @GetMapping("/changeName")
    public ResultPage changeName(@ApiParam("oldName") String oldName, @ApiParam("newName") String newName) {
        try {
            if (newName.isEmpty() || newName == null) {
                return new ResultPage(false, "你不要瞎搞事情!", null);
            }
            if (newName.length() >= 12) {
                return new ResultPage(false, "名字过长!", null);
            }
            newName = Name.UpFirstCharThenlowOtherChars(newName);
            playerService.changeName(oldName, newName);
            return new ResultPage(true, oldName + "更名为" + newName, null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改玩家名字出现了一场 参数为:oldName" + oldName + "newName" + newName);
        }
        return new ResultPage(false, "修改玩家角色名失败!", null);
    }

    @ApiOperation(value = "给玩家发放物品")
    @ResponseBody
    @ApiImplicitParam
    @GetMapping("/sentPlayerItem")
    public ResultPage sentPlayer(@ApiParam("管理员密码") String managerPwd, @ApiParam("角色名字") String chairName, @ApiParam("物品名字") Integer ItemName, @ApiParam("物品数量") Integer ItemNum) {
        try {
            if (managerPwd.isEmpty() || managerPwd == null) {
                return new ResultPage(false, "你无权添加物品!", null);
            }
            if (managerPwd.isEmpty() || managerPwd == null || chairName.length() >= 12) {
                return new ResultPage(false, "玩家名字过长!", null);
            }
            if (ItemName <= 0 || ItemName == null ||ItemName >30000) {
                return new ResultPage(false, "装备号不对!", null);
            }
            if (ItemNum < 1 || ItemNum == null ||ItemNum >99) {
                return new ResultPage(false, "数量不对!一次最多只允许添加99个", null);
            }
           // List<Play playerService.checkCharName(chairName);
            chairName = Name.UpFirstCharThenlowOtherChars(chairName);
            //playerService.changeName(oldName, newName);
            //return new ResultPage(true, oldName + "更名为" + newName, null);
        } catch (Exception e) {
            e.printStackTrace();
            //log.error("修改玩家名字出现了一场 参数为:oldName" + oldName + "newName" + newName);
        }
        return new ResultPage(false, "修改玩家角色名失败!", null);
    }
}
