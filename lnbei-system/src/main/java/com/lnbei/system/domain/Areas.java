package com.lnbei.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.oa.domain.OaBase;

/**
 * 城市管理表 sys_areas
 * 
 * @author lnbei
 * @date 2020-02-04
 */
public class Areas extends SysBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String parentId;
	/**  */
	private String areaName;
	/**  */
	private String isShow;
	/**  */
	private Integer sort;
	/**  */
	private String areaKey;
	/**  */
	private String areaType;
	/**  */
	private String delFlag;
	/**  */
	private Date createTime;
	/**  */
	private Date updateTime;
	/**  */
	private String createBy;
	/**  */
	private String updateBy;
	/**  */
	private String remark;
	/**  */
	private String userId;
	/**  */
	private String memberId;
	/** 审核标识 */
	private String flag;
	/** 下级数量 */
	private Integer childCount;
	
	private String path;
	
	private String level;
	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setAreaName(String areaName) 
	{
		this.areaName = areaName;
	}

	public String getAreaName() 
	{
		return areaName;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setAreaKey(String areaKey) 
	{
		this.areaKey = areaKey;
	}

	public String getAreaKey() 
	{
		return areaKey;
	}
	public void setAreaType(String areaType) 
	{
		this.areaType = areaType;
	}

	public String getAreaType() 
	{
		return areaType;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
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
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setFlag(String flag) 
	{
		this.flag = flag;
	}

	public String getFlag() 
	{
		return flag;
	}
	public void setChildCount(Integer childCount) 
	{
		this.childCount = childCount;
	}

	public Integer getChildCount() 
	{
		return childCount;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("parentId", getParentId())
            .append("areaName", getAreaName())
            .append("isShow", getIsShow())
            .append("sort", getSort())
            .append("areaKey", getAreaKey())
            .append("areaType", getAreaType())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("memberId", getMemberId())
            .append("flag", getFlag())
            .append("childCount", getChildCount())
            .toString();
    }
}
