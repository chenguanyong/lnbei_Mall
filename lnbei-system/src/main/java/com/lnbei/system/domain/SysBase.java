package com.lnbei.system.domain;

import java.util.Date;

import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysDept;
import com.lnbei.system.domain.SysUser;

public class SysBase extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  */
	private String deptId;
	/**  */
	private String deptName;
	/**  */
	private String cjId;
	/**  */
	private String cjName;
	/**  */
	private String gqId;
	/**  */
	private String gqName;
	
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
	public String getCjId() {
		return cjId;
	}
	public void setCjId(String cjId) {
		this.cjId = cjId;
	}
	public String getCjName() {
		return cjName;
	}
	public void setCjName(String cjName) {
		this.cjName = cjName;
	}
	public String getGqId() {
		return gqId;
	}
	public void setGqId(String gqId) {
		this.gqId = gqId;
	}
	public String getGqName() {
		return gqName;
	}
	public void setGqName(String gqName) {
		this.gqName = gqName;
	}
	/**
	 * 
	 * @param mUser
	 */
	public void insertData(SysUser mUser) {
		//SysUser mUser = ShiroUtils.getSysUser();
		if(StringUtils.isEmpty(this.deptId)) {
			this.setDeptId(mUser.getDeptId());//设置组织ID
		}
		SysDept mSysDept = mUser.getDept();
		
		if(StringUtils.isEmpty(this.deptName)) {
			this.setDeptName(mSysDept.getName());
		}		
		
		if(mSysDept.isCJ()) {
			this.setCjId(mSysDept.getId());
			this.setCjName(mSysDept.getName());
		}else if(mSysDept.isGQ()) {
			this.setCjId(mSysDept.getParentId());
			this.setCjName(mSysDept.getParentName());
			this.setGqId(mUser.getDeptId());
			this.setGqName(mSysDept.getName());
		}else {
			this.setCjId("");
			this.setCjName("");
			this.setGqId("");
			this.setGqName("");
		}
		this.setCreateBy(mUser.getId());
		if(super.getCreateTime() == null) {
			Date mDate = new Date();
			super.setCreateTime(mDate);
		}
	}
	/**
	 * 
	 * @param mSysUser
	 */
	public void updateData(SysUser mSysUser) {
		this.setCreateBy(mSysUser.getLogName());
	}
	public void insertData(Object object) {
		if(object instanceof SysUser) {
			insertData((SysUser)object);
		}else if (object instanceof MemberUser) {
			
		}
	}
	public void updateData(Object object) {
		if(object instanceof SysUser) {
			updateData((SysUser)object);
		}else if (object instanceof MemberUser) {
			
		}
	}
}
