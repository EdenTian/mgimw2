package com.mgi.bean;

import com.mgi.util.DateUtil;

import java.io.Serializable;

public class MgiLog implements Serializable {
    private Long logId;
    private String taskName;
    private String taskDesc;
    private String taskStatus;
    private String taskDate;
    private String taskContent;

    public static MgiLog insertSuccessLog(int i,StringBuffer successIds,String name) {
        return new MgiLog(name,
                name+"数据传输", "成功"
                , DateUtil.getNow(), name+"数据传输成功,时间为:" + DateUtil.getNow() + "传输个数为:" + i
                +"成功Id为:"+ successIds);

    }
    public static MgiLog insertErrorLog(int i,String e,StringBuffer errorIds,StringBuffer successIds,String name) {
        return new MgiLog(name,
                name+"数据传输", "失败"
                , DateUtil.getNow(), name+"数据传输失败,时间为:" + DateUtil.getNow() + "传输个数为:" + i
                + "失败原因 : "+ e +"失败id为:"+errorIds+"成功id为:"+successIds );
    }


    @Override
    public String toString() {
        return "MgiLog{" +
                "logId=" + logId +
                ", taskName='" + taskName + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskDate=" + taskDate +
                ", taskContent='" + taskContent + '\'' +
                '}';
    }

    public MgiLog() {
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public MgiLog(Long logId, String taskName, String taskDesc, String taskStatus, String taskDate, String taskContent) {
        this.logId = logId;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskStatus = taskStatus;
        this.taskDate = taskDate;
        this.taskContent = taskContent;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public MgiLog(String taskName, String taskDesc, String taskStatus, String taskDate, String taskContent) {
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskStatus = taskStatus;
        this.taskDate = taskDate;
        this.taskContent = taskContent;
    }
}
