package com.lnbei.home.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 分类表 home_category
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class HomeCategory extends HomeBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String category;
	/** 英文标识 */
	private String flag;
	/** 编号 */
	private String mark;
	/**  */
	private String parentId;
	/** 访问类型 */
	private String accessType;
	/**  */
	private String delFlag;
	/**  */
	private String status;
	/**  */
	private Date createTime;
	/**  */
	private Date updateTime;
	/**  */
	private String createBy;
	/**  */
	private String updateUp;
	/**  */
	private String remark;
	/**  */
	private Integer sort;
	/**  */
	private Integer year;
	/**  */
	private Integer month;
	/**  */
	private Integer day;
	
	private String path;
	
	private String pathString;
	
	public String getPathString() {
		return pathString;
	}

	public void setPathString(String pathString) {
		this.pathString = pathString;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getCategory() 
	{
		return category;
	}
	public void setFlag(String flag) 
	{
		this.flag = flag;
	}

	public String getFlag() 
	{
		return flag;
	}
	public void setMark(String mark) 
	{
		this.mark = mark;
	}

	public String getMark() 
	{
		return mark;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setAccessType(String accessType) 
	{
		this.accessType = accessType;
	}

	public String getAccessType() 
	{
		return accessType;
	}

	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setUpdateUp(String updateUp) 
	{
		this.updateUp = updateUp;
	}

	public String getUpdateUp() 
	{
		return updateUp;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setYear(Integer year) 
	{
		this.year = year;
	}

	public Integer getYear() 
	{
		return year;
	}
	public void setMonth(Integer month) 
	{
		this.month = month;
	}

	public Integer getMonth() 
	{
		return month;
	}
	public void setDay(Integer day) 
	{
		this.day = day;
	}

	public Integer getDay() 
	{
		return day;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("category", getCategory())
            .append("flag", getFlag())
            .append("mark", getMark())
            .append("parentId", getParentId())
            .append("accessType", getAccessType())
            .append("userId", getUserId())
            .append("memberId", getMemberId())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateUp", getUpdateUp())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("year", getYear())
            .append("month", getMonth())
            .append("day", getDay())
            .toString();
    }
}
