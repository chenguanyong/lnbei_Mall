package com.lnbei.home.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 文章主表 home_article
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class HomeArticle extends HomeBase {
	private static final long serialVersionUID = 1L;

	/**  */
	private String mid;
	/** 编号 */
	private String mark;
	/** 文章标题 */
	private String title;
	/** 摘要 */
	private String abstracts;
	/** 文章图片 */
	private String img;
	/** 分类ID */
	private Integer sort;
	/**  */
	private String classifyId;
	/** wenzhan */
	private String aSize;
	/** 作者 */
	private String author;
	/** 发布日期 */
	private Date releaseDate;
	/**  */
	private String status;
	/** 是否审核 */
	private String isVerify;

	/**  */
	private String flag;
	/** 访问类型 */
	private String accessType;
	/** 文章类型 */
	private String type;
	/** 点击量 */
	private Long clicks;

	private HomeArticleInfo mHomeArticleInfo;

	private String classify;

	private String auditor;

	private String auditorId;

	private String auditorOpinion;

	private String isHot;
	private String isRecom;
	private String isSale;
	private String isNew;
	private String isBest;

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getIsRecom() {
		return isRecom;
	}

	public void setIsRecom(String isRecom) {
		this.isRecom = isRecom;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getIsBest() {
		return isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditorOpinion() {
		return auditorOpinion;
	}

	public void setAuditorOpinion(String auditorOpinion) {
		this.auditorOpinion = auditorOpinion;
	}

	public String getaSize() {
		return aSize;
	}

	public void setaSize(String aSize) {
		this.aSize = aSize;
	}

	public HomeArticleInfo getmHomeArticleInfo() {
		return mHomeArticleInfo;
	}

	public void setmHomeArticleInfo(HomeArticleInfo mHomeArticleInfo) {
		this.mHomeArticleInfo = mHomeArticleInfo;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMid() {
		return mid;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return mark;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyId() {
		return classifyId;
	}

	public void setASize(String aSize) {
		this.aSize = aSize;
	}

	public String getASize() {
		return aSize;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}

	public String getIsVerify() {
		return isVerify;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getClicks() {
		return clicks;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("mid", getMid())
				.append("mark", getMark()).append("title", getTitle()).append("abstract", getAbstracts())
				.append("img", getImg()).append("sort", getSort()).append("classifyId", getClassifyId())
				.append("aSize", getASize()).append("author", getAuthor()).append("releaseDate", getReleaseDate())
				.append("status", getStatus()).append("isVerify", getIsVerify()).append("delFlag", getDelFlag())
				.append("flag", getFlag()).append("accessType", getAccessType()).append("type", getType())
				.append("clicks", getClicks()).append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();
	}
}
