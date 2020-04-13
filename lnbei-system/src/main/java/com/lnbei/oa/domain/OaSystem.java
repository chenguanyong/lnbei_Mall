package com.lnbei.oa.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 系统注册表 oa_system
 * 
 * @author lnbei
 * @date 2019-03-19
 */
public class OaSystem extends OaBase
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 系统名称 */
	private String sysName;
	/** 运维 */
	private String operation;
	/** 开发公司 */
	private String company;
	/** 状态 */
	private String status;
	/** 删除 */
	private String delFlag;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新人 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/**  */
	private String phone;
	/**排序**/
	private Integer sort;
	/**标识**/
	private String flag;
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSysName(String sysName) 
	{
		this.sysName = sysName;
	}

	public String getSysName() 
	{
		return sysName;
	}
	public void setOperation(String operation) 
	{
		this.operation = operation;
	}

	public String getOperation() 
	{
		return operation;
	}
	public void setCompany(String company) 
	{
		this.company = company;
	}

	public String getCompany() 
	{
		return company;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sysName", getSysName())
            .append("operation", getOperation())
            .append("company", getCompany())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("phone", getPhone())
            .toString();
    }
}
