package com.lnbei.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lnbei.oa.domain.OaBase;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 线表 sys_line
 * 
 * @author lnbei
 * @date 2019-03-11
 */
public class SysLine extends OaBase
{
	private static final long serialVersionUID = 1L;
	
	/** 表主键 */
	private String id;
	/** 线路代码 */
	private String number;
	/** 线路名称 */
	private String name;
	/**  */
	private String shortName;
	/** 线路等级：例如客运专线，繁忙干线,干线,其他等 */
	private String classid;
	/** 部(1)/局(2)线别名称标志 */
	private String flag;
	/** 线路类型：单线，复线，三线，四线 */
	private String lineNumber;
	/** 该线路所属局的ID */
	private String orgId;
	/** 线路级别0：主线（被分段），1：主线，2：支线，3：区段 */
	private Integer level;
	/** 排序号 */
	private Integer sort;
	/** 标识数据的服务器来源 */
	private String serverFlag;
	/**  */
	private String mainId;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/** 备注 */
	private String remark;
	/**车站数量*/
	private Integer stationSize;
	/**
	 * 组织机构名称
	 */
	private String orgName;
	
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
	public void setShortName(String shortName) 
	{
		this.shortName = shortName;
	}

	public String getShortName() 
	{
		return shortName;
	}
	public void setClassid(String classid) 
	{
		this.classid = classid;
	}

	public String getClassid() 
	{
		return classid;
	}
	public void setFlag(String flag) 
	{
		this.flag = flag;
	}

	public String getFlag() 
	{
		return flag;
	}
	public void setLineNumber(String lineNumber) 
	{
		this.lineNumber = lineNumber;
	}

	public String getLineNumber() 
	{
		return lineNumber;
	}
	public void setOrgId(String orgId) 
	{
		this.orgId = orgId;
	}

	public String getOrgId() 
	{
		return orgId;
	}
	public void setLevel(Integer level) 
	{
		this.level = level;
	}

	public Integer getLevel() 
	{
		return level;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setServerFlag(String serverFlag) 
	{
		this.serverFlag = serverFlag;
	}

	public String getServerFlag() 
	{
		return serverFlag;
	}
	public void setMainId(String mainId) 
	{
		this.mainId = mainId;
	}

	public String getMainId() 
	{
		return mainId;
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
	public Integer getStationSize() 
	{
		return this.stationSize;
	}
	public void setStationSize(Integer stationSize) 
	{
		this.stationSize = stationSize;
	}
	public void setOrgName(String orgNme)
	{
		this.orgName = orgNme;
	}
	public String getOrgName() 
	{
		return this.orgName;
	}
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("number", getNumber())
            .append("name", getName())
            .append("shortName", getShortName())
            .append("classid", getClassid())
            .append("flag", getFlag())
            .append("lineNumber", getLineNumber())
            .append("orgId", getOrgId())
            .append("level", getLevel())
            .append("sort", getSort())
            .append("serverFlag", getServerFlag())
            .append("mainId", getMainId())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
