package com.dao.xin;

import com.pojo.InterviewerNew;
import com.pojo.InterviewerOld;
import com.pojo.InterviewresultNew;
import com.pojo.InvitationNew;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerNewDao {
    void insertIntoInterviewer(InterviewerNew interviewerNew);

    void insertIntoResult(InterviewresultNew interviewresultNew);

    void insertIntoInvitation(InvitationNew invitationNew);

    List<InterviewerNew> findByNameAndPhone(String name,String phone);

    InterviewresultNew findInterviewresultByInterviewId(Integer id);

    InvitationNew findInvitationByInterviewId(Integer id);


}
