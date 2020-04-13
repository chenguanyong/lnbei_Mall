package com.lnbei.framework.shiro.authenticator;


import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;


import com.lnbei.framework.shiro.realm.MemberRealm;
import com.lnbei.framework.shiro.realm.UserRealm;
import com.lnbei.framework.shiro.type.VirtualType;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysUser;

public class MemberModularRealmAuthorizer extends ModularRealmAuthorizer  {
	   @Override
	    public boolean isPermitted(PrincipalCollection principals, String permission) {
	        assertRealmsConfigured();
	        Object reals = principals.getPrimaryPrincipal();
	        String type="";
	        if (reals instanceof SysUser) {
	        	type = "1";
	        }
	        if (reals instanceof MemberUser) {
	        	type = "2";
			}
	        for (Realm realm : getRealms()) {
	            if (!(realm instanceof Authorizer)){ continue;}
	            switch (type) {
				case "1":
					
				{    
					 if (realm.getName().contains(VirtualType.User.toString()) ) {// 判断realm
			               // if (permission.contains("SYSTEM")) {// 判断是否改realm的资源
			                    return ((UserRealm) realm).isPermitted(principals, permission);    // 使用改realm的授权方法
			              //  }
			            }
					break;}

				case "2":{
		            if (realm.getName().contains(VirtualType.Member.toString()) ) {
			               
	                    return ((MemberRealm) realm).isPermitted(principals, permission);
	               
	            }
					
					break;}
					
					
				}
	            
	        
	        }
	        return false;
	    }
}
