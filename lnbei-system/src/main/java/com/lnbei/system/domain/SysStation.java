package com.lnbei.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lnbei.oa.domain.OaBase;
/**
 * 站表 sys_sys_station
 * 
 * @author lnbei
 * @date 2019-03-11
 */
public class SysStation extends OaBase 
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 一级归属线别主键 */
	private String lineId;
	/** 车站略号 */
	private String stationNumber;
	/** 车站名称 */
	private String name;
	/**  */
	private String namePy;
	/**  */
	private String shortName;
	/** 建设年 */
	private String build;
	/** 大修年 */
	private String repairHeavy;
	/** 中修年 */
	private String repairMiddle;
	/** 更新改造年 */
	private String replace;
	/** 车站类别(字典)区段站、中间站、其它 */
	private String stationClass;
	/** 联锁类型(字典) */
	private String interlockType;
	/** 计算机联锁厂家(字典) */
	private String interlockWork;
	/** 计算机联锁类型(字典) */
	private String computerType;
	/** 闭塞方式(字典) */
	private String blockMode;
	/** 轨道电路类型(字典) */
	private String trackcuitType;
	/** 电码化方式(字典) */
	private String codeMode;
	/** 电码化类型(字典) */
	private String codeType;
	/** 正线钢轨类型(字典) 75KG、60KG、50KG、43KG、40KG、其他 */
	private String rightRailType;
	/** 侧线钢轨类型(字典) */
	private String sideRailType;
	/** 是否安装微机检测 */
	private String ifEds;
	/** 监控方式(字典) */
	private String supMode;
	/** 设备换算道岔数 */
	private Integer switchForEqu;
	/** 智能电源屏含5KVAUPS设备(字典) */
	private String blockType;
	/**  */
	private String powerType;
	/**  */
	private String powerWork;
	/**  */
	private String powerEqu;
	/** 车站类型:1-大站 其它-小站 */
	private Integer flag;
	/** 1是车站，2是驼峰，3是道口，4是区间 */
	private Integer type;
	/** 公里标 */
	private Integer kmmark;
	/**  */
	private String phone;
	/** 上下行类型  0:上行,1:下行,2:上下行 */
	private Integer updown;
	/** 排序用的序号 */
	private Integer sort;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setLineId(String lineId) 
	{
		this.lineId = lineId;
	}

	public String getLineId() 
	{
		return lineId;
	}
	public void setStationNumber(String stationNumber) 
	{
		this.stationNumber = stationNumber;
	}

	public String getStationNumber() 
	{
		return stationNumber;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setNamePy(String namePy) 
	{
		this.namePy = namePy;
	}

	public String getNamePy() 
	{
		return namePy;
	}
	public void setShortName(String shortName) 
	{
		this.shortName = shortName;
	}

	public String getShortName() 
	{
		return shortName;
	}
	public void setBuild(String build) 
	{
		this.build = build;
	}

	public String getBuild() 
	{
		return build;
	}
	public void setRepairHeavy(String repairHeavy) 
	{
		this.repairHeavy = repairHeavy;
	}

	public String getRepairHeavy() 
	{
		return repairHeavy;
	}
	public void setRepairMiddle(String repairMiddle) 
	{
		this.repairMiddle = repairMiddle;
	}

	public String getRepairMiddle() 
	{
		return repairMiddle;
	}
	public void setReplace(String replace) 
	{
		this.replace = replace;
	}

	public String getReplace() 
	{
		return replace;
	}
	public void setStationClass(String stationClass) 
	{
		this.stationClass = stationClass;
	}

	public String getStationClass() 
	{
		return stationClass;
	}
	public void setInterlockType(String interlockType) 
	{
		this.interlockType = interlockType;
	}

	public String getInterlockType() 
	{
		return interlockType;
	}
	public void setInterlockWork(String interlockWork) 
	{
		this.interlockWork = interlockWork;
	}

	public String getInterlockWork() 
	{
		return interlockWork;
	}
	public void setComputerType(String computerType) 
	{
		this.computerType = computerType;
	}

	public String getComputerType() 
	{
		return computerType;
	}
	public void setBlockMode(String blockMode) 
	{
		this.blockMode = blockMode;
	}

	public String getBlockMode() 
	{
		return blockMode;
	}
	public void setTrackcuitType(String trackcuitType) 
	{
		this.trackcuitType = trackcuitType;
	}

	public String getTrackcuitType() 
	{
		return trackcuitType;
	}
	public void setCodeMode(String codeMode) 
	{
		this.codeMode = codeMode;
	}

	public String getCodeMode() 
	{
		return codeMode;
	}
	public void setCodeType(String codeType) 
	{
		this.codeType = codeType;
	}

	public String getCodeType() 
	{
		return codeType;
	}
	public void setRightRailType(String rightRailType) 
	{
		this.rightRailType = rightRailType;
	}

	public String getRightRailType() 
	{
		return rightRailType;
	}
	public void setSideRailType(String sideRailType) 
	{
		this.sideRailType = sideRailType;
	}

	public String getSideRailType() 
	{
		return sideRailType;
	}
	public void setIfEds(String ifEds) 
	{
		this.ifEds = ifEds;
	}

	public String getIfEds() 
	{
		return ifEds;
	}
	public void setSupMode(String supMode) 
	{
		this.supMode = supMode;
	}

	public String getSupMode() 
	{
		return supMode;
	}
	public void setSwitchForEqu(Integer switchForEqu) 
	{
		this.switchForEqu = switchForEqu;
	}

	public Integer getSwitchForEqu() 
	{
		return switchForEqu;
	}
	public void setBlockType(String blockType) 
	{
		this.blockType = blockType;
	}

	public String getBlockType() 
	{
		return blockType;
	}
	public void setPowerType(String powerType) 
	{
		this.powerType = powerType;
	}

	public String getPowerType() 
	{
		return powerType;
	}
	public void setPowerWork(String powerWork) 
	{
		this.powerWork = powerWork;
	}

	public String getPowerWork() 
	{
		return powerWork;
	}
	public void setPowerEqu(String powerEqu) 
	{
		this.powerEqu = powerEqu;
	}

	public String getPowerEqu() 
	{
		return powerEqu;
	}
	public void setFlag(Integer flag) 
	{
		this.flag = flag;
	}

	public Integer getFlag() 
	{
		return flag;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setKmmark(Integer kmmark) 
	{
		this.kmmark = kmmark;
	}

	public Integer getKmmark() 
	{
		return kmmark;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setUpdown(Integer updown) 
	{
		this.updown = updown;
	}

	public Integer getUpdown() 
	{
		return updown;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lineId", getLineId())
            .append("stationNumber", getStationNumber())
            .append("name", getName())
            .append("namePy", getNamePy())
            .append("shortName", getShortName())
            .append("build", getBuild())
            .append("repairHeavy", getRepairHeavy())
            .append("repairMiddle", getRepairMiddle())
            .append("replace", getReplace())
            .append("stationClass", getStationClass())
            .append("interlockType", getInterlockType())
            .append("interlockWork", getInterlockWork())
            .append("computerType", getComputerType())
            .append("blockMode", getBlockMode())
            .append("trackcuitType", getTrackcuitType())
            .append("codeMode", getCodeMode())
            .append("codeType", getCodeType())
            .append("rightRailType", getRightRailType())
            .append("sideRailType", getSideRailType())
            .append("ifEds", getIfEds())
            .append("supMode", getSupMode())
            .append("switchForEqu", getSwitchForEqu())
            .append("blockType", getBlockType())
            .append("powerType", getPowerType())
            .append("powerWork", getPowerWork())
            .append("powerEqu", getPowerEqu())
            .append("flag", getFlag())
            .append("type", getType())
            .append("kmmark", getKmmark())
            .append("phone", getPhone())
            .append("updown", getUpdown())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
