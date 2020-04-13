package com.lnbei.sp.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 消息模板表 sp_template_msgs
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public class SpTemplateMsgs extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String tplType;
	/**  */
	private String tplCode;
	/**  */
	private String tplExternaId;
	/**  */
	private String tplContent;
	/**  */
	private String tplTitle;
	/**  */
	private String tplDesc;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setTplType(String tplType) 
	{
		this.tplType = tplType;
	}

	public String getTplType() 
	{
		return tplType;
	}
	public void setTplCode(String tplCode) 
	{
		this.tplCode = tplCode;
	}

	public String getTplCode() 
	{
		return tplCode;
	}
	public void setTplExternaId(String tplExternaId) 
	{
		this.tplExternaId = tplExternaId;
	}

	public String getTplExternaId() 
	{
		return tplExternaId;
	}
	public void setTplContent(String tplContent) 
	{
		this.tplContent = tplContent;
	}

	public String getTplContent() 
	{
		return tplContent;
	}

	public void setTplDesc(String tplDesc) 
	{
		this.tplDesc = tplDesc;
	}

	public String getTplDesc() 
	{
		return tplDesc;
	}


    public String getTplTitle() {
		return tplTitle;
	}

	public void setTplTitle(String tplTitle) {
		this.tplTitle = tplTitle;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("tplType", getTplType())
            .append("tplCode", getTplCode())
            .append("tplExternaId", getTplExternaId())
            .append("tplContent", getTplContent())
            .append("tplTitle", getTplTitle())
            .append("tplDesc", getTplDesc())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
