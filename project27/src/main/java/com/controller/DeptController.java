package com.controller;

import com.pojo.Dept;
import com.pojo.Emp;
import com.service.ActionService;
import com.service.DeptService;
import com.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    ActionService actionService;
    @Autowired
    DeptService deptService;

    /**
     * 需根据角色获取动作URL列表
     */
    @RequestMapping("/emp/deptManage_listDept.do")
    public String deptManage_listDept(Dept dept, Model model, HttpServletRequest req){
        if("yes".equals(req.getAttribute("forward")+"")){
            dept=new Dept();
        }

        //List<String> ListUrl = actionService.findAllName();
        List<String> ListUrl = actionService.findAllNameByRole(req);
        List<Dept> deptList = deptService.findAll(dept);

        model.addAttribute("ListUrl",ListUrl);
        model.addAttribute("deptList",deptList);

        return "basic/dept_list";
    }


    @RequestMapping("/emp/deptManage_toAddDept.do")
    public String deptManage_toAddDept(Dept dept, Model model, HttpServletRequest req){
        return "basic/dept_add";
    }

    @RequestMapping("/emp/deptManage_addDept.do")
    public String deptManage_addDept(Dept dept, HttpServletRequest req){
        deptService.add(dept);

        req.setAttribute("forward" ,"yes");
        return "forward:/emp/deptManage_listDept.do";
    }

    @RequestMapping("/emp/deptManage_toEditDept.do")
    public String deptManage_toEditDept(Integer deptId,Model model){
        Dept dept = deptService.findById(deptId);

        model.addAttribute("deptName",dept.getDeptName());
        model.addAttribute("deptId",dept.getDeptId());
        model.addAttribute("linkman",dept.getLinkman());
        model.addAttribute("tel",dept.getTel());
        model.addAttribute("address",dept.getAddress());
        model.addAttribute("remark",dept.getRemark());
        return "basic/dept_edit";
    }

    @RequestMapping("/emp/deptManage_editDept.do")
    public String deptManage_editDept(Dept dept,HttpServletRequest req){
        deptService.update(dept);

        req.setAttribute("forward" ,"yes");
        return "forward:/emp/deptManage_listDept.do";
    }

    @RequestMapping("/emp/deptManage_delDept.do")
    public String deptManage_delDept(Integer deptId,HttpServletRequest req){
        deptService.deleteByDeptId(deptId);

        req.setAttribute("forward" ,"yes");
        return "forward:/emp/deptManage_listDept.do";
    }
}
