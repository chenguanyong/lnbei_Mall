package com.lnbei.oa.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文件用户关系表 oa_file_user
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public class OaFileUser extends OaBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 文件ID */
	private String fileId;
	/**  */
	private String memberId;
	/**  */
	private String userId;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFileId(String fileId) 
	{
		this.fileId = fileId;
	}

	public String getFileId() 
	{
		return fileId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("fileId", getFileId())
            .append("memberId", getMemberId())
            .append("userId", getUserId())
            .toString();
    }
}
