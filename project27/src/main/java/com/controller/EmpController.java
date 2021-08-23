package com.controller;

import com.pojo.Dept;
import com.pojo.Emp;
import com.pojo.EmpType;
import com.service.ActionService;
import com.service.DeptService;
import com.service.EmpService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    ActionService actionService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;

    /**
     * 需根据角色获取动作URL列表
     */
    @RequestMapping("/emp/empManage_listEmp.do")
    public String empManage_listEmp(Model model,Emp emp, HttpServletRequest req){
        if("yes".equals(req.getAttribute("forward")+"")){
            emp=new Emp();
        }

        //List<String> ListUrl = actionService.findAllName();
        List<String> ListUrl = actionService.findAllNameByRole(req);
        List<Emp> empList = empService.findAll(emp);

        model.addAttribute("ListUrl",ListUrl);
        model.addAttribute("empList",empList);

        return "basic/emp_list";
    }

    @RequestMapping("/emp/empManage_toAddEmp.do")
    public String empManage_toAddEmp(Model model){
        List<EmpType> empTypeList = new ArrayList<>();
        empTypeList.add(new EmpType("文员","文员"));
        empTypeList.add(new EmpType("销售员","销售员"));
        empTypeList.add(new EmpType("分析师","分析师"));
        empTypeList.add(new EmpType("经理","经理"));
        empTypeList.add(new EmpType("董事长","董事长"));

        List<Dept> deptList = deptService.findAll(new Dept());

        model.addAttribute("empTypeList",empTypeList);
        model.addAttribute("deptList",deptList);
        return "basic/emp_add";
    }

    @RequestMapping("/emp/empManage_addEmp.do")
    public String empManage_addEmp(Emp emp, HttpServletRequest req){
        empService.add2(emp);

        req.setAttribute("forward" ,"yes");
        return "forward:/emp/empManage_listEmp.do";
    }

    @RequestMapping("/emp/empManage_toEditEmp.do")
    public String empManage_toEditEmp(Integer empId,Model model){
        List<EmpType> empTypeList = new ArrayList<>();
        empTypeList.add(new EmpType("文员","文员"));
        empTypeList.add(new EmpType("销售员","销售员"));
        empTypeList.add(new EmpType("分析师","分析师"));
        empTypeList.add(new EmpType("经理","经理"));
        empTypeList.add(new EmpType("董事长","董事长"));

        List<Dept> deptList = deptService.findAll(new Dept());

        Emp emp = empService.findByEmpId(empId);

        model.addAttribute("empTypeList",empTypeList);
        model.addAttribute("deptList",deptList);
        model.addAttribute("empName",emp.getEmpName());
        model.addAttribute("type",emp.getEmpTypeName());
        model.addAttribute("remark",emp.getRemark());
        model.addAttribute("tel",emp.getTel());
        model.addAttribute("empId",emp.getEmpId());
        return "basic/emp_edit";
    }


    @RequestMapping("/emp/empManage_editEmp.do")
    public String empManage_editEmp(Emp emp,HttpServletRequest req){
        empService.update(emp);

        req.setAttribute("forward" ,"yes");
        return "forward:/emp/empManage_listEmp.do";
    }
}
