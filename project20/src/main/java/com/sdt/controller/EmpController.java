package com.sdt.controller;

import com.sdt.domain.Emp;
import com.sdt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public ModelAndView empPage(Model model){
        ModelAndView mav = new ModelAndView();
        List<Emp> emps = empService.findAll();
        mav.addObject("emps",emps);
        mav.setViewName("empPage");
        return mav;
    }

    @RequestMapping("/add")
    public String addEmp(Emp emp){
        empService.addEmp(emp);
        return "forward:/emp/list";
    }

    @RequestMapping("/updatePage")
    public ModelAndView updatePage(Integer empno,Model model){
        ModelAndView mav = new ModelAndView();
        Emp emp = empService.findById(empno);
        mav.addObject("emp",emp);
        mav.setViewName("updatePage");
        return mav;
    }

    @RequestMapping("/update")
    public String updateEmp(Emp emp){
        empService.updateEmp(emp);
        return "forward:/emp/list";
    }

    @RequestMapping("/delete")
    public String deleteEmp(Integer empno){
        empService.deleteEmp(empno);
        return "forward:/emp/list";
    }

    @RequestMapping("/findEmpById")
    @ResponseBody
    public Emp findEmpById(Integer mgrno){
        System.out.println(mgrno);
        Emp emp = empService.findById(mgrno);
        System.out.println(emp);
        return emp;
    }

}
