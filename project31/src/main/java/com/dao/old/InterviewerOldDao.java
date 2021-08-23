package com.dao.old;

import com.pojo.IntervieweesOld;
import com.pojo.InterviewerOld;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerOldDao {
    List<InterviewerOld> findAll();

    List<IntervieweesOld> findIntervieweesOldByInterveId(Integer id);
}
