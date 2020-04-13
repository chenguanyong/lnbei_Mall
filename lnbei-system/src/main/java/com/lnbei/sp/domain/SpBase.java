package com.lnbei.sp.domain;

import java.util.Calendar;
import java.util.Date;

import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysUser;

public class SpBase extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 创建日期 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 创建人 */
	private String createBy;
	/** 更新人 */
	private String updateUp;
	/** 备注 */
	private String remark;
	/** 排序 */
	private Integer sort;
	/**  */
	private Integer year;
	/**  */
	private Integer month;

	/**  */
	private Integer day;
	
	/** 删除标志 */
	private String delFlag;
	
	private String memberId;
	
	private String userId;
	
	private String deptId;
	
	private String deptName;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateUp() {
		return updateUp;
	}

	public void setUpdateUp(String updateUp) {
		this.updateUp = updateUp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public void initInsert(SysUser mmSysUser) {
		this.userId = mmSysUser.getId();
		this.createBy = mmSysUser.getId();
		Calendar ca = Calendar.getInstance();
		this.year = ca.get(Calendar.YEAR);
		this.month = ca.get(Calendar.MONTH);
		this.day = ca.get(Calendar.DAY_OF_MONTH);
	}
	public void initInsert(MemberUser mmSysUser) {
		this.memberId = mmSysUser.getMid();
		this.createBy = mmSysUser.getMid();
		Calendar ca = Calendar.getInstance();
		this.year = ca.get(Calendar.YEAR);
		this.month = ca.get(Calendar.MONTH);
		this.day = ca.get(Calendar.DAY_OF_MONTH);
	}	
	
	public void initUpdate(SysUser mmSysUser) {
		this.updateUp = mmSysUser.getId();
	}
	public void initUpdate(MemberUser mmSysUser) {
		this.updateUp = mmSysUser.getMid();
	}
	public void initUpdate(Object object) {
		if(object instanceof SysUser) {
			initUpdate((SysUser)object);
		}else if (object instanceof MemberUser) {
			initUpdate((MemberUser)object);
		}
	}
	
	public void initInsert(Object object) {
		if(object instanceof SysUser) {
			initInsert((SysUser)object);
		}else if (object instanceof MemberUser) {
			initInsert((MemberUser)object);
		}
	}
}
