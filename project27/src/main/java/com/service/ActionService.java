package com.service;

import com.pojo.SysAction;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ActionService {
    //得到全部动作的URL列表
    List<String> findAllName();

    //根据角色得到动作的URL列表
    List<String> findAllNameByRole(HttpServletRequest req);

    //根据动作类型得到动作的URL列表
    List<String> findAllNameByType(Integer type);

    //根据菜单id得到[指定类型]动作对象列表
    List<SysAction> findActionListByMenuIdAndType(Integer menuId, Integer type);

    List<SysAction> findActionListByMenuId(Integer menuId);

    void updateActionName(SysAction sysaction);

    void add(SysAction sysaction);

    SysAction findByActionId(Integer actionId);

    void update(SysAction sysaction);

    void deleteByActionId(Integer actionId);


}
