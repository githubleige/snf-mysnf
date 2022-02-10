package it.heima.it.heima.bean;

import java.sql.Timestamp;

public class DeductFeeBean {
    //杂项类型
    private String deductType;

    //渠道
    private String distChannel;

    //一级科目
    private String feeNo;

    //二级科目
    private String subFeeNo;

    //科目名称
    private String subjectsName;

    private Timestamp createdTime;

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public String getDistChannel() {
        return distChannel;
    }

    public void setDistChannel(String distChannel) {
        this.distChannel = distChannel;
    }

    public String getFeeNo() {
        return feeNo;
    }

    public void setFeeNo(String feeNo) {
        this.feeNo = feeNo;
    }

    public String getSubFeeNo() {
        return subFeeNo;
    }

    public void setSubFeeNo(String subFeeNo) {
        this.subFeeNo = subFeeNo;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

    @Override
    public String toString() {
        return "DeductFeeBean{" +
                "deductType='" + deductType + '\'' +
                ", distChannel='" + distChannel + '\'' +
                ", feeNo='" + feeNo + '\'' +
                ", subFeeNo='" + subFeeNo + '\'' +
                ", subjectsName='" + subjectsName + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
