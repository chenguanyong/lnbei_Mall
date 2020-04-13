package com.lnbei.member.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lnbei.common.imp.IUserBase;

/**
 * 会员表 member_user
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class MemberUser extends MemberBase implements IUserBase
{
	private static final long serialVersionUID = 1L;
	private final String classFlag = "MEMBERUSER";
	/**  */
	private String mid;
	/**  */
	private String loginName;
	/**  */
	private Integer loginSecret;
	/**  */
	private String loginPwd;
	/**  */
	private String payPwd;
	/**  */
	private String userType;
	/**  */
	private String userSex;
	/**  */
	private String userName;
	/** 真实姓名 */
	private String trueName;
	/**  */
	private Date brithday;
	/**  */
	private String userPhoto;
	/**  */
	private String userQq;
	/**  */
	private String userPhone;
	/**  */
	private String userEmail;
	/** 用户钱 */
	private Float userMoney;
	/**  */
	private Integer userScore;
	/**  */
	private Integer userTotalScore;
	/**  */
	private String lastIp;
	/**  */
	private Date lastTime;
	/** 保证金 */
	private BigDecimal lockMoney;
	/** 用户状态0表示未激活 1表示激活，2表示停用3，表示禁用  */
	private String userStatus;

	/** 用户级别 */
	private String levelId;
	/** 推荐人ID */
	private String parentId;
	/** 爷爷级ID */
	private String grandfatherId;
	/** 会员所在点位：父节点.位置 */
	private String point;
	/** 推荐关系 */
	private String directPath;
	/** 节点关系 */
	private String nodePath;
	/** 节点路径‘-1-2-3-’ */
	private String path;
	/** 节点个数 */
	private Integer childCnt;
	/** 节点深度 */
	private Integer depth;
	/** 旗下总人数 */
	private Integer totalNumber;
	/** 编号 */
	private String serialNumber;
	/** 直推数量 */
	private Integer ztSize;
	/** 推荐人编号 */
	private String recommendNumber;
	/**  */
	private String token;
	/** 奖金 */
	private Float bonus;
	/** 店铺ID */
	private String shopId;
	/** 位置 */
	private Integer position;
	/** 终端分布0android1：apple 2其他 */
	private String zd;
	/**  */
	private String lang;
	/**  */

	/** 是否实名 */
	private String isAuthname;
	
	private String isShoper;
	
	private String identity;
	
	private String loginIp;
	
	private Date loginDate;

	
	
	public String getRecommendNumber() {
		return recommendNumber;
	}

	public void setRecommendNumber(String recommendNumber) {
		this.recommendNumber = recommendNumber;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getIsShoper() {
		return isShoper;
	}

	public void setIsShoper(String isShoper) {
		this.isShoper = isShoper;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}



	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setLoginSecret(Integer loginSecret) 
	{
		this.loginSecret = loginSecret;
	}

	public Integer getLoginSecret() 
	{
		return loginSecret;
	}
	public void setLoginPwd(String loginPwd) 
	{
		this.loginPwd = loginPwd;
	}

	public String getLoginPwd() 
	{
		return loginPwd;
	}
	public void setPayPwd(String payPwd) 
	{
		this.payPwd = payPwd;
	}

	public String getPayPwd() 
	{
		return payPwd;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String getUserType() 
	{
		return userType;
	}
	public void setUserSex(String userSex) 
	{
		this.userSex = userSex;
	}

	public String getUserSex() 
	{
		return userSex;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setTrueName(String trueName) 
	{
		this.trueName = trueName;
	}

	public String getTrueName() 
	{
		return trueName;
	}
	public void setBrithday(Date brithday) 
	{
		this.brithday = brithday;
	}

	public Date getBrithday() 
	{
		return brithday;
	}
	public void setUserPhoto(String userPhoto) 
	{
		this.userPhoto = userPhoto;
	}

	public String getUserPhoto() 
	{
		return userPhoto;
	}
	public void setUserQq(String userQq) 
	{
		this.userQq = userQq;
	}

	public String getUserQq() 
	{
		return userQq;
	}
	public void setUserPhone(String userPhone) 
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone() 
	{
		return userPhone;
	}
	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}

	public String getUserEmail() 
	{
		return userEmail;
	}
	public void setUserMoney(Float userMoney) 
	{
		this.userMoney = userMoney;
	}

	public Float getUserMoney() 
	{
		return userMoney;
	}
	public void setUserScore(Integer userScore) 
	{
		this.userScore = userScore;
	}

	public Integer getUserScore() 
	{
		return userScore;
	}
	public void setUserTotalScore(Integer userTotalScore) 
	{
		this.userTotalScore = userTotalScore;
	}

	public Integer getUserTotalScore() 
	{
		return userTotalScore;
	}
	public void setLastIp(String lastIp) 
	{
		this.lastIp = lastIp;
	}

	public String getLastIp() 
	{
		return lastIp;
	}
	public void setLastTime(Date lastTime) 
	{
		this.lastTime = lastTime;
	}

	public Date getLastTime() 
	{
		return lastTime;
	}
	public void setLockMoney(BigDecimal lockMoney) 
	{
		this.lockMoney = lockMoney;
	}

	public BigDecimal getLockMoney() 
	{
		return lockMoney;
	}
	public void setUserStatus(String userStatus) 
	{
		this.userStatus = userStatus;
	}

	public String getUserStatus() 
	{
		return userStatus;
	}

	
	public void setLevelId(String levelId) 
	{
		this.levelId = levelId;
	}

	public String getLevelId() 
	{
		return levelId;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setGrandfatherId(String grandfatherId) 
	{
		this.grandfatherId = grandfatherId;
	}

	public String getGrandfatherId() 
	{
		return grandfatherId;
	}
	public void setPoint(String point) 
	{
		this.point = point;
	}

	public String getPoint() 
	{
		return point;
	}
	public void setDirectPath(String directPath) 
	{
		this.directPath = directPath;
	}

	public String getDirectPath() 
	{
		return directPath;
	}
	public void setNodePath(String nodePath) 
	{
		this.nodePath = nodePath;
	}

	public String getNodePath() 
	{
		return nodePath;
	}
	public void setPath(String path) 
	{
		this.path = path;
	}

	public String getPath() 
	{
		return path;
	}
	public void setChildCnt(Integer childCnt) 
	{
		this.childCnt = childCnt;
	}

	public Integer getChildCnt() 
	{
		return childCnt;
	}
	public void setDepth(Integer depth) 
	{
		this.depth = depth;
	}

	public Integer getDepth() 
	{
		return depth;
	}
	public void setTotalNumber(Integer totalNumber) 
	{
		this.totalNumber = totalNumber;
	}

	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
	public void setSerialNumber(String serialNumber) 
	{
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() 
	{
		return serialNumber;
	}
	public void setZtSize(Integer ztSize) 
	{
		this.ztSize = ztSize;
	}

	public Integer getZtSize() 
	{
		return ztSize;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}

	public String getToken() 
	{
		return token;
	}
	public void setBonus(Float bonus) 
	{
		this.bonus = bonus;
	}

	public Float getBonus() 
	{
		return bonus;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setPosition(Integer position) 
	{
		this.position = position;
	}

	public Integer getPosition() 
	{
		return position;
	}
	public void setZd(String zd) 
	{
		this.zd = zd;
	}

	public String getZd() 
	{
		return zd;
	}
	public void setLang(String lang) 
	{
		this.lang = lang;
	}

	public String getLang() 
	{
		return lang;
	}

	
	public void setIsAuthname(String isAuthname) 
	{
		this.isAuthname = isAuthname;
	}

	public String getIsAuthname() 
	{
		return isAuthname;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("loginName", getLoginName())
            .append("loginSecret", getLoginSecret())
            .append("loginPwd", getLoginPwd())
            .append("payPwd", getPayPwd())
            .append("userType", getUserType())
            .append("userSex", getUserSex())
            .append("userName", getUserName())
            .append("trueName", getTrueName())
            .append("brithday", getBrithday())
            .append("userPhoto", getUserPhoto())
            .append("userQq", getUserQq())
            .append("userPhone", getUserPhone())
            .append("userEmail", getUserEmail())
            .append("userMoney", getUserMoney())
            .append("userScore", getUserScore())
            .append("userTotalScore", getUserTotalScore())
            .append("lastIp", getLastIp())
            .append("lastTime", getLastTime())
            .append("lockMoney", getLockMoney())
            .append("userStatus", getUserStatus())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("levelId", getLevelId())
            .append("parentId", getParentId())
            .append("grandfatherId", getGrandfatherId())
            .append("point", getPoint())
            .append("directPath", getDirectPath())
            .append("nodePath", getNodePath())
            .append("path", getPath())
            .append("childCnt", getChildCnt())
            .append("depth", getDepth())
            .append("totalNumber", getTotalNumber())
            .append("serialNumber", getSerialNumber())
            .append("ztSize", getZtSize())
            .append("recommendNumber", getRecommendNumber())
            .append("token", getToken())
            .append("bonus", getBonus())
            .append("shopId", getShopId())
            .append("position", getPosition())
            .append("zd", getZd())
            .append("lang", getLang())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("isAuthname", getIsAuthname())
            .toString();
    }

	@Override
	public String getClassFlag() {
		// TODO Auto-generated method stub
		return this.classFlag;
	}
	/**
	 * 检测是否事店主
	 * @return
	 */
	public boolean isShoper() {
		if(this.isShoper.equals("1")) {
			return true;
		}
		return false;
	}
}
