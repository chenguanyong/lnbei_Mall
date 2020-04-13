package com.lnbei.framework.util;

import java.security.MessageDigest;
import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.bean.BeanUtils;
import com.lnbei.framework.shiro.realm.MemberRealm;
import com.lnbei.framework.shiro.realm.UserRealm;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysUser;

/**
 * shiro 工具类
 * 
 * @author lnbei
 */
public class ShiroUtils
{
    public static Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }

    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout()
    {
        getSubject().logout();
    }

    public static SysUser getSysUser()
    {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if(obj instanceof SysUser ) {
        	
	        if (StringUtils.isNotNull(obj))
	        {
	            user = new SysUser();
	            BeanUtils.copyBeanProp(user, obj);
	        }
        }
        return user;
    }
    public static Object getUser() {
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
           return obj;
        }
        return null;
    }
    public static MemberUser getMemberUser()
    {
        MemberUser user = null;
        Object obj = getSubject().getPrincipal();
        if(obj instanceof MemberUser ) {
            if (StringUtils.isNotNull(obj))
            {
                user = new MemberUser();
                BeanUtils.copyBeanProp(user, obj);
            } 
        }
        return user;
    }
    
    //public static 
    public static void setSysUser(SysUser user)
    {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static void clearCachedAuthorizationInfo()
    {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
       //UserRealm realm = (UserRealm) rsm.getRealms().iterator().next(); 
        Collection<Realm> mmCollection = rsm.getRealms();
        for (Realm realm2 : mmCollection) {
        	if(realm2 instanceof UserRealm) {
        		UserRealm mRealm = (UserRealm) realm2;
        		mRealm.clearCachedAuthorizationInfo();
        	}else if(realm2 instanceof MemberRealm) {
        		MemberRealm mRealm = (MemberRealm) realm2;
        		mRealm.clearCachedAuthorizationInfo();
        	}		
        }
        
       // 

       
    }

    public static String getUserId()
    {
        return getSysUser().getId();
    }

    public static String getLoginName()
    {
        return getSysUser().getLogName();
    }

    public static String getIp()
    {
        return getSubject().getSession().getHost();
    }

    public static String getSessionId()
    {
        return String.valueOf(getSubject().getSession().getId());
    }

    /**
     * 生成随机盐
     */
    public static String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }
    
    
    public static String toMd5String(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

    
}
