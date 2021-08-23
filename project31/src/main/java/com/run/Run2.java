package com.run;

import com.dao.old.InterviewerOldDao;
import com.dao.xin.InterviewerNewDao;
import com.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 新数据库需要：
 * interviewresult面试结果:
 * 到面时间  interviewees的mssj
 * 面试细节(含时间，面试反馈)  interviewees的mssj，rl
 * 面试官姓名 无
 * 面试结果 interviewees的msjg
 *
 * invitation邀请：
 * 邀约人  interviewee的yyr
 * 邀约类型(待跟进，已约面)  interviewee的mslx
 * 邀约时间  interviewee的yysj
 * 面试岗位 interviewee的gw
 * 邀约细节  空着就行
 * whetherTofaceOrNot(是否到面) interviewee的sfdm
 * remarks  空着就行
 *
 * 思路：遍历老数据库所有人，拿到interviewresult和invitation的bean，查到interviewId后根据它添加到两个表
 *      注意，如果这两个表这个interviewId已经有数据，拿出来看看，先不要覆盖
 * 现在interviewresult有100条，invitation有3185条
 */
public class Run2 {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisOld.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        InterviewerOldDao interviewerOldDao = session.getMapper(InterviewerOldDao.class);


        InputStream inNew = Resources.getResourceAsStream("mybatisNew.xml");
        SqlSessionFactoryBuilder builderNew = new SqlSessionFactoryBuilder();
        SqlSessionFactory factoryNew = builderNew.build(inNew);
        SqlSession sessionNew = factoryNew.openSession();
        InterviewerNewDao interviewerNewDao = sessionNew.getMapper(InterviewerNewDao.class);


        //获取全部旧数据bean
        List<InterviewerOld> olds = interviewerOldDao.findAll();
        for (InterviewerOld old : olds) {
            //获取新数据库interviewId
            List<InterviewerNew> Interviewer = interviewerNewDao.findByNameAndPhone(old.getName(), old.getTel());
            System.out.println("旧数据库面试者:"+old);
            //System.out.println("新数据库面试者数量:"+Interviewer.size());
            System.out.println("新数据库面试者："+Interviewer);
            if(Interviewer.size()==0){
                System.out.println("===============================================================================================================================================");
                continue;
            }


            //填充新bean
            System.out.println("旧数据库相关数据：");
            List<IntervieweesOld> intervieweess = interviewerOldDao.findIntervieweesOldByInterveId(old.getId());

            InterviewresultNew interviewresultBean=new InterviewresultNew();
            InvitationNew invitationBean =new InvitationNew();

            if(intervieweess==null || intervieweess.size()==0){
                System.out.println("interviewees为空");
            }else{
                System.out.println(intervieweess);
                IntervieweesOld interviewees = intervieweess.get(0);
                interviewresultBean.setInterviewerId(Interviewer.get(0).getInterviewerid());
                interviewresultBean.setArrivalTime(interviewees.getMssj());
                interviewresultBean.setInterviewDetails(interviewees.getRl());
                switch (interviewees.getMsjg()){
                    case "28":
                        interviewresultBean.setInterviewResults("面试通过");
                        break;
                    case "29":
                        interviewresultBean.setInterviewResults("面试失败");
                        break;
                    case "30":
                        interviewresultBean.setInterviewResults("继续跟踪");
                        break;
                    default:
                        System.out.println("面试结果为"+interviewees.getMsjg());
                        return;
                }
            }



            invitationBean.setInterviewerId(Interviewer.get(0).getInterviewerid());
            invitationBean.setInvitingPerson(old.getYyr());
            switch (old.getMslx()){
                case "4":
                    invitationBean.setTypeOfInvitation("已约面");
                    break;
                case "5":
                    invitationBean.setTypeOfInvitation("待跟进");
                    break;
                case "6":
                    invitationBean.setTypeOfInvitation("未接");
                    break;
                default:
                    System.out.println("面试类型为"+old.getMslx());
                    return;
            }
            //invitationBean.setInvitationTime(old.getYysj());

            switch (old.getGw()){
                case "7":
                    invitationBean.setInterviewPosition("前端");
                    break;
                case "8":
                    invitationBean.setInterviewPosition("软件测试");
                    break;
                case "9":
                    invitationBean.setInterviewPosition("java开发");
                    break;
                case "10":
                    invitationBean.setInterviewPosition("net开发");
                    break;
                case "11":
                    invitationBean.setInterviewPosition("软件运维");
                    break;
                case "12":
                    invitationBean.setInterviewPosition("软件实施");
                    break;
                case "13":
                    invitationBean.setInterviewPosition("UI");
                    break;
                case "14":
                    invitationBean.setInterviewPosition("硬件运维");
                    break;
                case "15":
                    invitationBean.setInterviewPosition("行政");
                    break;
                case "16":
                    invitationBean.setInterviewPosition("HR");
                    break;
                case "17":
                    invitationBean.setInterviewPosition("销售");
                    break;
                case "31":
                    invitationBean.setInterviewPosition("会计");
                    break;
                default:
                    System.out.println("面试岗位为"+old.getGw());
                    return;
            }
            invitationBean.setWhetherToFaceOrNot(old.getSfdm());

            System.out.println("将添加入新数据库：");
            System.out.println(interviewresultBean);
            System.out.println(invitationBean);


            //查看新数据库情况
            InterviewresultNew interviewresult= interviewerNewDao.findInterviewresultByInterviewId(Interviewer.get(0).getInterviewerid());
            InvitationNew invitation = interviewerNewDao.findInvitationByInterviewId(Interviewer.get(0).getInterviewerid());

            System.out.println("新数据库已存在数据：");
            System.out.println("interviewresult:");
            if(interviewresult!=null){
                System.out.println(interviewresult);
            }else{
                //有数据才添加
                if(interviewresultBean.getInterviewerId()!=null){
                    System.out.println("无，添加");
                    try{
                        interviewerNewDao.insertIntoResult(interviewresultBean);
                    }catch (Exception e){
                        e.printStackTrace();;
                    }
                }
            }

            System.out.println("invitation:");
            if(invitation!=null){
                System.out.println(invitation);
            }else{
                System.out.println("无，添加");
                try{
                    interviewerNewDao.insertIntoInvitation(invitationBean);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }



            System.out.println("===============================================================================================================================================");
        }
    }
}
