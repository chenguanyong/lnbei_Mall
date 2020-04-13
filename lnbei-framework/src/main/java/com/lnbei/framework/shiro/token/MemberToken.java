package com.lnbei.framework.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.lnbei.framework.shiro.type.VirtualType;

public class MemberToken extends UsernamePasswordToken  {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VirtualType virtualType;
	 
	 public MemberToken(final String username, final String password,final boolean rememberMe, VirtualType mType) {
		 super(username,password,rememberMe);
		 this.virtualType = mType;
	 }

	public VirtualType getVirtualType() {
		return virtualType;
	}

	public void setVirtualType(VirtualType virtualType) {
		this.virtualType = virtualType;
	}
	 
}
