package com.sdt.controller;

import com.sdt.domain.Dept;
import com.sdt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/deptPage")
    public ModelAndView deptPage(){
        ModelAndView mav = new ModelAndView();
        List<Dept> depts = deptService.findAll();
        mav.addObject("depts",depts);
        mav.setViewName("deptPage");
        return mav;
    }

    @RequestMapping("/updatePage")
    public ModelAndView updatePage(Integer deptno){
        ModelAndView mav = new ModelAndView();
        Dept dept = deptService.findById(deptno);
        mav.addObject("dept",dept);
        mav.setViewName("deptUpdatePage");
        return mav;
    }



    @RequestMapping("/add")
    public String add(Dept dept){
        deptService.add(dept);
        return "forward:/dept/deptPage";
    }

    @RequestMapping("/delete")
    public String delete(Integer deptno){
        deptService.delete(deptno);
        return "forward:/dept/deptPage";
    }

    @RequestMapping("/update")
    public String update(Dept dept){
        deptService.update(dept);
        return "forward:/dept/deptPage";
    }
}
