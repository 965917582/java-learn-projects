package com.service.impl;

import com.dao.ActionDao;
import com.pojo.SysAction;
import com.pojo.User;
import com.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionDao actionDao;

    @Override
    public List<String> findAllName() {
        return actionDao.findAllName();
    }

    @Override
    public List<String> findAllNameByRole(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginUser");
        if(user==null){
            return null;
        }
        return actionDao.findAllNameByRoleId(user.getRoleId());
    }

    @Override
    public List<String> findAllNameByType(Integer type) {
        return actionDao.findAllNameByType(type);
    }

    @Override
    public List<SysAction> findActionListByMenuIdAndType(Integer menuId, Integer type) {
        return actionDao.findActionListByMenuIdAndType(menuId,type);
    }

    @Override
    public List<SysAction> findActionListByMenuId(Integer menuId) {
        return actionDao.findActionListByMenuId(menuId);
    }

    @Override
    public void updateActionName(SysAction sysaction) {
        actionDao.updateActionName(sysaction);
    }

    @Override
    public void add(SysAction sysaction) {
        actionDao.add(sysaction);
    }

    @Override
    public SysAction findByActionId(Integer actionId) {
        return actionDao.findByActionId(actionId);
    }

    @Override
    public void update(SysAction sysaction) {
        actionDao.update(sysaction);
    }

    @Override
    public void deleteByActionId(Integer actionId) {
        actionDao.deleteByActionId(actionId);
    }


}
