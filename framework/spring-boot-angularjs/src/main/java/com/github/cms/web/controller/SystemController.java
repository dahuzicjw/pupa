package com.github.cms.web.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.github.cms.core.pojo.Result;
import com.github.cms.core.pojo.User;
import com.github.cms.core.util.SessionUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author chenjw
 * @Date 2016年08月20日
 */
@Controller
@RequestMapping("system")
public class SystemController {

    private static JSONObject Menus;

    @ApiOperation(value = "菜单获取", notes = "菜单获取")
    @RequestMapping(value = "init", method = RequestMethod.GET)
    @ResponseBody
    public Result<User> init() {
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser == null) {
            return Result.failure("未登录");
        } else {
            sessionUser.setPrivileges(getMenus().getObject(sessionUser.getRoleType().toString(), List.class));
            return Result.success(sessionUser);
        }
    }

    /**
      menuName:  菜单名
      menuType:  菜单类型 Folder Menu
      iconClass: 图标样式class
      prepend:   html标签内容
      expand:    是否展开0否 1是
      submenu:   子菜单
     * @return
     */
    private JSONObject getMenus() {
        if (Menus == null) {
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            try {
                InputStream in = SystemController.class.getResourceAsStream("/privilege.json");
                inputStreamReader = new InputStreamReader(in, "UTF-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String buffer;
                while ((buffer = bufferedReader.readLine()) != null) {
                    sb.append(buffer);
                }
                Menus = JSON.parseObject(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return Menus;
    }
}
