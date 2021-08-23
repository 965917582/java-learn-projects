package com.run;

import com.dao.old.InterviewerOldDao;
import com.dao.xin.InterviewerNewDao;
import com.pojo.InterviewerNew;
import com.pojo.InterviewerOld;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 把老数据库面试者(interviewee表)，如果新数据库(interviewer表)不存在这个人，加进去
 * ——->发现都存在
 */
public class Run {

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
        //转到新bean,插入新数据库，如果已经有这个人旧不要插入
        for (InterviewerOld old : olds) {
            List<InterviewerNew> byNameAndPhone = interviewerNewDao.findByNameAndPhone(old.getName(), old.getTel());
            if(byNameAndPhone==null && byNameAndPhone.size()==0){
                //给面试者表-名字，学校，电话
                InterviewerNew interviewerNew = new InterviewerNew();
                interviewerNew.setName(old.getName());
                interviewerNew.setEducationinformation(old.getByxx());
                interviewerNew.setTelephone(old.getTel());

                interviewerNewDao.insertIntoInterviewer(interviewerNew);
                //给面试结果表-是否面试过
                //interviewerNewDao.inertIntoResult(interviewerNew.getInterviewerid(),(old.getSfdm()=="1")?"到面":"未到面");

                System.out.println(interviewerNew+"已添加");
            }else{
                //System.out.println(old+"已存在");
            }

        }



        //6.释放资源
        session.close();
        in.close();
        sessionNew.close();
        inNew.close();

    }
}
