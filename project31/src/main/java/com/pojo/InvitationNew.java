package com.pojo;

import java.util.Date;

public class InvitationNew {
    private Integer interviewerId;
    private String interviewPosition;
    private String invitationDetails;
    private Integer InvitationId;
    private Date invitationTime;
    private String invitingPerson;
    private String remarks;
    private String typeOfInvitation;
    private String whetherToFaceOrNot;

    public Integer getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Integer interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getInterviewPosition() {
        return interviewPosition;
    }

    public void setInterviewPosition(String interviewPosition) {
        this.interviewPosition = interviewPosition;
    }

    public String getInvitationDetails() {
        return invitationDetails;
    }

    public void setInvitationDetails(String invitationDetails) {
        this.invitationDetails = invitationDetails;
    }

    public Integer getInvitationId() {
        return InvitationId;
    }

    public void setInvitationId(Integer invitationId) {
        InvitationId = invitationId;
    }

    public Date getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(Date invitationTime) {
        this.invitationTime = invitationTime;
    }

    public String getInvitingPerson() {
        return invitingPerson;
    }

    public void setInvitingPerson(String invitingPerson) {
        this.invitingPerson = invitingPerson;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeOfInvitation() {
        return typeOfInvitation;
    }

    public void setTypeOfInvitation(String typeOfInvitation) {
        this.typeOfInvitation = typeOfInvitation;
    }

    public String getWhetherToFaceOrNot() {
        return whetherToFaceOrNot;
    }

    public void setWhetherToFaceOrNot(String whetherToFaceOrNot) {
        this.whetherToFaceOrNot = whetherToFaceOrNot;
    }

    @Override
    public String toString() {
        return "InvitationNew{" +
                "interviewerId=" + interviewerId +
                ", interviewPosition='" + interviewPosition + '\'' +
                ", invitationDetails='" + invitationDetails + '\'' +
                ", InvitationId=" + InvitationId +
                ", invitationTime=" + invitationTime +
                ", invitingPerson='" + invitingPerson + '\'' +
                ", remarks='" + remarks + '\'' +
                ", typeOfInvitation='" + typeOfInvitation + '\'' +
                ", whetherToFaceOrNot='" + whetherToFaceOrNot + '\'' +
                '}';
    }
}
