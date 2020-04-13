package com.lnbei.framework.shiro.authenticator;


import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;

import org.apache.shiro.realm.Realm;
import org.slf4j.LoggerFactory;

import com.lnbei.framework.shiro.token.MemberToken;
import com.lnbei.framework.shiro.type.VirtualType;

import org.slf4j.Logger;

public class MemberModularRealmAuthenticator extends ModularRealmAuthenticator {
	private static final Logger logger = LoggerFactory.getLogger(MemberModularRealmAuthenticator.class);
	
	
	 @Override
	    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
	            throws AuthenticationException {
	        logger.info("UserModularRealmAuthenticator:method doAuthenticate() execute ");
	        // 判断getRealms()是否返回为空
	        assertRealmsConfigured();
	        // 强制转换回自定义的CustomizedToken
	        MemberToken userToken = (MemberToken) authenticationToken;
	        // 登录类型
	        VirtualType virtualType = userToken.getVirtualType();
	        // 所有Realm
	        Collection<Realm> realms = getRealms();
	        // 登录类型对应的所有Realm
	        Collection<Realm> typeRealms = new ArrayList<>();
	        for (Realm realm : realms) {
	        	
	        	String mmString = virtualType.toString();
	            if (realm.getName().contains(mmString))// 注：这里使用类名包含枚举，区分realm
	                typeRealms.add(realm);
	        }
	        // 判断是单Realm还是多Realm
	        if (typeRealms.size() == 1) {
	            logger.info("doSingleRealmAuthentication() execute ");
	            return doSingleRealmAuthentication(typeRealms.iterator().next(), userToken);
	        } else {
	            logger.info("doMultiRealmAuthentication() execute ");
	            return doMultiRealmAuthentication(typeRealms, userToken);
	        }
	    }
	 
}
