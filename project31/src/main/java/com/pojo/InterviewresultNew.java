package com.pojo;

import java.util.Date;

public class InterviewresultNew {
    private String arrivalTime;
    private String interviewDetails;
    private Integer interviewerId;
    private Integer interviewResultId;
    private String interviewResults;
    private String nameOfInterviewer;

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(String interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public Integer getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Integer interviewerId) {
        this.interviewerId = interviewerId;
    }

    public Integer getInterviewResultId() {
        return interviewResultId;
    }

    public void setInterviewResultId(Integer interviewResultId) {
        this.interviewResultId = interviewResultId;
    }

    public String getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(String interviewResults) {
        this.interviewResults = interviewResults;
    }

    public String getNameOfInterviewer() {
        return nameOfInterviewer;
    }

    public void setNameOfInterviewer(String nameOfInterviewer) {
        this.nameOfInterviewer = nameOfInterviewer;
    }

    @Override
    public String toString() {
        return "InterviewresultNew{" +
                "arrivalTime='" + arrivalTime + '\'' +
                ", interviewDetails='" + interviewDetails + '\'' +
                ", interviewerId=" + interviewerId +
                ", interviewResultId=" + interviewResultId +
                ", interviewResults='" + interviewResults + '\'' +
                ", nameOfInterviewer='" + nameOfInterviewer + '\'' +
                '}';
    }
}
