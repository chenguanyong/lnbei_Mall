package com.lnbei.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lnbei.common.annotation.Excel;
import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.common.imp.IUserBase;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 * 
 * @author lnbei
 */
public class SysUser extends BaseEntity implements IUserBase
{
    private static final long serialVersionUID = 1L;
    private final String classFlag = "SYSUSER";
	/** 主键 */
	private String id;
	/** 人员工作证号 */
	@Excel(name = "工资号")
	private String number;
	/** 所属机构主键 */
	private String deptId;
	/** 登陆别名，初始时和用户名默认一致 */
	@Excel(name = "登录名")
	private String logName;
	/** 真实姓名 */
	@Excel(name = "真实姓名")
	private String name;
	/** 姓名拼音 */
	private String namePy;
	/** 身份证号码 */
	@Excel(name = "身份证号")
	private String pid;
	/** 登陆密码 */
	private String pwd;
	/** 性别 缺省为 0-男 1-女 */
	@Excel(name = "性别",readConverterExp="0=男,1=女,2=未知")
	private String sex;
	/** 出生年月 */
	@Excel(name = "出生年月",dateFormat="yyyy-MM-dd")
	private Date born;
	/** 职称或技术等级，来自字典表 */
	private String title;
	/** 职务或职名，来自字典表 */
	private String position;
	/** 办公电话 */
	@Excel(name = "办公电话")
	private String tel;
	/** 手机 */
	@Excel(name = "手机")
	private String mobile;
	/** 家庭电话 */
	private String phone;
	/** 工作流中用到用户角色id */
	private Integer flowId;
	/** EMAIL */
	private String mailName;
	/** 工种：和字典表关联 */
	private String worktype;
	/** 籍贯 */
	private String home;
	/** 家庭住址 */
	private String address;
	/** 政治面貌，来自字典表 */
	private String politics;
	/** 入路时间（参加工作时间） */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date joinDate;
	/** 文化程度，来自字典表 */
	private String grade;
	/** 最后编辑人 */
	private String crtr;
	/** 记录日期，输入录入日期或者最后一次编辑或删除的日期 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date crtrdate;
	/** 人员等级（用于区分普通职工，一般干部，主管领导等），来自字典表 */
	private String chiefType;
	/** 用户最近一次使用的子系统编号 */
	private String lastNumber;
	/** 照片id */
	private String photoId;
	/** 岗位工作标准 */
	private String desc;
	/** 廉政承诺书 */
	private String fileid;
	/** 是否为手机登陆用户，默认0 非手机登陆用户，1为手机用户 */
	private Integer mobileAccount;
	/** 手机串号 */
	private String imei;
	/** 用户状态： 0-非系统用户 1-系统用户  9-超级管理员 */
	private Integer status;
	/** 系统排序号 */
	private Integer sort;
	/** 删除标志位 */
	private Integer delFlag;
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
	/**邮箱*/
    private String email;
	/** 备注 */
	private String remark;
	/**组织机构*/
	private SysDept dept;
	/**角色*/
	private List<SysRole> roles;
    /** 角色组 */
    private String[] roleIds;
    /**真实姓名*/
    private String realName;
   
	private String loginIp;
    /** 盐加密 */
    private String salt;
    /** 最后登陆时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginDate;

    /** 岗位组 */
    private String[] postIds;
    /** 用户头像 */
    private String avatar;
    /**是否职员*/
    private Integer isStaff;
    /**是否账户*/
    private Integer isAccount;

	public String[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(String[] postIds)
    {
        this.postIds = postIds;
    }
    
    public String[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds)
    {
        this.roleIds = roleIds;
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
    public boolean isAdmin()
    {
        return isAdmin(this.id);
    }

    public static boolean isAdmin(String userId)
    {
        return userId != null && userId.equals("a1");
    }
	public String getNumber() 
	{
		return number;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setLogName(String logName) 
	{
		this.logName = logName;
	}

	public String getLogName() 
	{
		return logName;
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
	public void setPid(String pid) 
	{
		this.pid = pid;
	}

	public String getPid() 
	{
		return pid;
	}
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	public String getPwd() 
	{
		return pwd;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setBorn(Date born) 
	{
		this.born = born;
	}

	public Date getBorn() 
	{
		return born;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setPosition(String position) 
	{
		this.position = position;
	}

	public String getPosition() 
	{
		return position;
	}
	public void setTel(String tel) 
	{
		this.tel = tel;
	}

	public String getTel() 
	{
		return tel;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setFlowId(Integer flowId) 
	{
		this.flowId = flowId;
	}

	public Integer getFlowId() 
	{
		return flowId;
	}
	public void setMailName(String mailName) 
	{
		this.mailName = mailName;
	}

	public String getMailName() 
	{
		return mailName;
	}
	public void setWorktype(String worktype) 
	{
		this.worktype = worktype;
	}

	public String getWorktype() 
	{
		return worktype;
	}
	public void setHome(String home) 
	{
		this.home = home;
	}

	public String getHome() 
	{
		return home;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setPolitics(String politics) 
	{
		this.politics = politics;
	}

	public String getPolitics() 
	{
		return politics;
	}
	public void setJoinDate(Date joinDate) 
	{
		this.joinDate = joinDate;
	}

	public Date getJoinDate() 
	{
		return joinDate;
	}
	public void setGrade(String grade) 
	{
		this.grade = grade;
	}

	public String getGrade() 
	{
		return grade;
	}
	public void setCrtr(String crtr) 
	{
		this.crtr = crtr;
	}

	public String getCrtr() 
	{
		return crtr;
	}
	public void setCrtrdate(Date crtrdate) 
	{
		this.crtrdate = crtrdate;
	}

	public Date getCrtrdate() 
	{
		return crtrdate;
	}
	public void setChiefType(String chiefType) 
	{
		this.chiefType = chiefType;
	}

	public String getChiefType() 
	{
		return chiefType;
	}
	public void setLastNumber(String lastNumber) 
	{
		this.lastNumber = lastNumber;
	}

	public String getLastNumber() 
	{
		return lastNumber;
	}
	public void setPhotoId(String photoId) 
	{
		this.photoId = photoId;
	}

	public String getPhotoId() 
	{
		return photoId;
	}
	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	public String getDesc() 
	{
		return desc;
	}
	public void setFileid(String fileid) 
	{
		this.fileid = fileid;
	}

	public String getFileid() 
	{
		return fileid;
	}
	public void setMobileAccount(Integer mobileAccount) 
	{
		this.mobileAccount = mobileAccount;
	}

	public Integer getMobileAccount() 
	{
		return mobileAccount;
	}
	public void setImei(String imei) 
	{
		this.imei = imei;
	}

	public String getImei() 
	{
		return imei;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setDelFlag(Integer delFlag) 
	{
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() 
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
	
    public SysDept getDept()
    {
        if (dept == null)
        {
            dept = new SysDept();
        }
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }
    
    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }
    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }
    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }
    public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    public Integer getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Integer isStaff) {
		this.isStaff = isStaff;
	}

	public Integer getIsAccount() {
		return isAccount;
	}

	public void setIsAccount(Integer isAccount) {
		this.isAccount = isAccount;
	}
	//判断是否拥有某种角色
	public boolean isRole(String roleType) {
		
		for (SysRole mSysRole : roles) {
			if(mSysRole.getRoleKey().equals(roleType)) {
				return true;
			}
		}
		return false;
	}
	
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("number", getNumber())
            .append("deptId", getDeptId())
            .append("logName", getLogName())
            .append("email", getEmail())
            .append("name", getName())
            .append("namePy", getNamePy())
            .append("pid", getPid())
            .append("pwd", getPwd())
            .append("sex", getSex())
            .append("born", getBorn())
            .append("title", getTitle())
            .append("position", getPosition())
            .append("tel", getTel())
            .append("mobile", getMobile())
            .append("phone", getPhone())
            .append("flowId", getFlowId())
            .append("mailName", getMailName())
            .append("worktype", getWorktype())
            .append("home", getHome())
            .append("address", getAddress())
            .append("politics", getPolitics())
            .append("joinDate", getJoinDate())
            .append("grade", getGrade())
            .append("crtr", getCrtr())
            .append("crtrdate", getCrtrdate())
            .append("chiefType", getChiefType())
            .append("lastNumber", getLastNumber())
            .append("photoId", getPhotoId())
            .append("desc", getDesc())
            .append("fileid", getFileid())
            .append("mobileAccount", getMobileAccount())
            .append("imei", getImei())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("realName", getRealName())
            .toString();
    }

	@Override
	public String getClassFlag() {
		// TODO Auto-generated method stub
		return this.classFlag;
	}
}
