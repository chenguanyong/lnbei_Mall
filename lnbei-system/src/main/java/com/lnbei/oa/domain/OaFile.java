package com.lnbei.oa.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文件管理表 oa_file
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public class OaFile extends OaBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 文件名字 */
	private String fileName;
	/** 文件路径 */
	private String filePath;
	/**  */
	private long fileSize;
	/** 文件编号 */
	private String fileNum;
	/** 文件类型 */
	private String fileType;
	/**  */
	private Date createTime;
	/**  */
	private String createBy;
	/**  */
	private Date updateTime;
	/**  */
	private String updateBy;
	/**  */
	private String delFlag;
	/**  */
	private String remark;
	/**  */
	private Integer downSize;
	/** 文件的网络地址 */
	private String fileUrl;
	/** 访问类型 */
	private String accessType;
	/**
	 * 分类名称
	 */
	private String classify;
	/**
	 * 分类ID
	 */
	private String classifyId;
	/**
	 * 关注量
	 */
	private Integer attentionSize;
	/***
	 * 来源ID
	 */
	private String sourceId;
	/**
	 * 引用量
	 */
	private Integer quote;
/**
 * 文件后缀
 */
	private String fileSuffix;
	
	
	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public Integer getQuote() {
		return quote;
	}

	public void setQuote(Integer quote) {
		this.quote = quote;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getAttentionSize() {
		return attentionSize;
	}

	public void setAttentionSize(Integer attentionSize) {
		this.attentionSize = attentionSize;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}

	public void setFileNum(String fileNum) 
	{
		this.fileNum = fileNum;
	}

	public String getFileNum() 
	{
		return fileNum;
	}
	public void setFileType(String fileType) 
	{
		this.fileType = fileType;
	}

	public String getFileType() 
	{
		return fileType;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setDownSize(Integer downSize) 
	{
		this.downSize = downSize;
	}

	public Integer getDownSize() 
	{
		return downSize;
	}
	public void setFileUrl(String fileUrl) 
	{
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() 
	{
		return fileUrl;
	}
	public void setAccessType(String accessType) 
	{
		this.accessType = accessType;
	}

	public String getAccessType() 
	{
		return accessType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("fileSize", getFileSize())
            .append("fileNum", getFileNum())
            .append("fileType", getFileType())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("downSize", getDownSize())
            .append("fileUrl", getFileUrl())
            .append("accessType", getAccessType())
            .toString();
    }
}
