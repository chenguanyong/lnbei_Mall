package com.lnbei.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lnbei.common.core.domain.BaseEntity;

/**
 * 部门表 sys_dept
 * 
 * @author lnbei
 */
public class SysDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

	/** 表主键 */
	private String id;
	/** 编号 */
	private String number;
	/** 机构名称 */
	private String name;
	/** 机构类型：1：铁道部  2：集团   3：局  4：分局  5：段  6：车间  7：工区 */
	private Integer type;
	/** 机构类型标志（枚举）  1 行政机构，2 生产机构 3部门 */
	private Integer orgTypeFlag;
	/**  */
	private Integer manProType;
	/**  */
	private String parentId;
	/**  */
	private Integer parentOrgTypeFlag;
	/** 生产机构分类：现场车间，电子车间等，与系统字典表相关 */
	private String classid;
	/** 机构描述信息 */
	private String desc;
	/** 树的叶子节点标记，辅助编程。末级单位标志*，铁道部进行组织机构维护时自动算出，表明是行政机构的最后一级单位，如果出现有的有分局，有的没分局，这时该标志对编程人员来讲非常有用，省去很多麻烦。 */
	private String flagLeaf;
	/** 机构的级别 1：部  2：局   3：段  4： 车间  5： 工区 */
	private Integer level;
	/** 集团-1;集团领导-2;处室-3;处领导-4;处科室-5;段-6;段领导-7;段科室-8;车间-9;工区-10 */
	private Integer orgLevel;
	/** 值班电话 */
	private String phone;
	/** 数字短串ID，用于考勤机 */
	private String nid;
	/** 部门分类：0 业务科室  1 行政科室 */
	private Integer depClass;
	/** 排序号 */
	private Integer sort;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/**子部门id*/
	private String ancestors;
	/**状态*/
	private String status;
	/**父组织名称*/
	private String parentName;
	
	private String shortName;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getNumber() 
	{
		return number;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setOrgTypeFlag(Integer orgTypeFlag) 
	{
		this.orgTypeFlag = orgTypeFlag;
	}

	public Integer getOrgTypeFlag() 
	{
		return orgTypeFlag;
	}
	public void setManProType(Integer manProType) 
	{
		this.manProType = manProType;
	}

	public Integer getManProType() 
	{
		return manProType;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setParentOrgTypeFlag(Integer parentOrgTypeFlag) 
	{
		this.parentOrgTypeFlag = parentOrgTypeFlag;
	}

	public Integer getParentOrgTypeFlag() 
	{
		return parentOrgTypeFlag;
	}
	public void setClassid(String classid) 
	{
		this.classid = classid;
	}

	public String getClassid() 
	{
		return classid;
	}
	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	public String getDesc() 
	{
		return desc;
	}
	public void setFlagLeaf(String flagLeaf) 
	{
		this.flagLeaf = flagLeaf;
	}

	public String getFlagLeaf() 
	{
		return flagLeaf;
	}
	public void setLevel(Integer level) 
	{
		this.level = level;
	}

	public Integer getLevel() 
	{
		return level;
	}
	public void setOrgLevel(Integer orgLevel) 
	{
		this.orgLevel = orgLevel;
	}

	public Integer getOrgLevel() 
	{
		return orgLevel;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setNid(String nid) 
	{
		this.nid = nid;
	}

	public String getNid() 
	{
		return nid;
	}
	public void setDepClass(Integer depClass) 
	{
		this.depClass = depClass;
	}

	public Integer getDepClass() 
	{
		return depClass;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
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
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getStatus() 
	{
		return this.status;
	}
	public void setAncestors(String ancestors) 
	{
		this.ancestors = ancestors;
	}
	public String getAncestors()
	{
		return this.ancestors;
	}
	public void setParentName(String parentName) 
	{
		this.parentName = parentName;
	}
	public String getParentName() 
	{
		return this.parentName;
	}

	public Boolean isCJ() {

		if (this.orgLevel != null && this.orgLevel == 9) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isGQ() {

		if (this.orgLevel != null && this.orgLevel == 10) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isDWD() {

		if (this.orgLevel != null && this.orgLevel == 5) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isKeshi() {

		if (this.type != null && this.type == 8) {
			return true;
		} else {
			return false;
		}
	}
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("number", getNumber())
            .append("name", getName())
            .append("type", getType())
            .append("orgTypeFlag", getOrgTypeFlag())
            .append("manProType", getManProType())
            .append("parentId", getParentId())
            .append("parentOrgTypeFlag", getParentOrgTypeFlag())
            .append("classid", getClassid())
            .append("desc", getDesc())
            .append("flagLeaf", getFlagLeaf())
            .append("level", getLevel())
            .append("orgLevel", getOrgLevel())
            .append("phone", getPhone())
            .append("nid", getNid())
            .append("depClass", getDepClass())
            .append("sort", getSort())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("ancestors", getAncestors())
            .append("parentName", getParentName())
            .toString();
    }
}
