package com.lnbei.framework.shiro.realm;

import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lnbei.common.exception.user.CaptchaException;
import com.lnbei.common.exception.user.RoleBlockedException;
import com.lnbei.common.exception.user.UserBlockedException;
import com.lnbei.common.exception.user.UserNotExistsException;
import com.lnbei.common.exception.user.UserPasswordNotMatchException;
import com.lnbei.common.exception.user.UserPasswordRetryLimitExceedException;
import com.lnbei.framework.shiro.service.SysLoginService;
import com.lnbei.framework.shiro.token.MemberToken;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.service.IMemberUserRanksService;

import com.lnbei.system.service.ISysMenuService;


/**
 * 自定义Realm 处理登录 权限
 * 
 * @author lnbei
 */
public class MemberRealm extends AuthorizingRealm
{
    private static final Logger log = LoggerFactory.getLogger(MemberRealm.class);

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private IMemberUserRanksService iMemberUserRanksService;

    @Autowired
    private SysLoginService loginService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        MemberUser user = ShiroUtils.getMemberUser();
        // 角色列表
        Set<String> roles = new HashSet<String>();
        // 功能列表
        Set<String> menus = new HashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    
        roles = iMemberUserRanksService.selectRanksKeys(user.getMemberId(), user.getIdentity());//(user.getId());
        menus = menuService.selectPermsByMemberIdAndIdentity(user.getMemberId(), user.getIdentity());
        // 角色加入AuthorizationInfo认证对象
        info.setRoles(roles);
        // 权限加入AuthorizationInfo认证对象
        info.setStringPermissions(menus);
        
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        MemberToken upToken = (MemberToken) token;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null)
        {
            password = new String(upToken.getPassword());
        }

        MemberUser user = null;
        try
        {
            user = loginService.memberLogin(username, password);
        }
        catch (CaptchaException e)
        {
            throw new AuthenticationException(e.getMessage(), e);
        }
        catch (UserNotExistsException e)
        {
            throw new UnknownAccountException(e.getMessage(), e);
        }
        catch (UserPasswordNotMatchException e)
        {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        }
        catch (UserPasswordRetryLimitExceedException e)
        {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        }
        catch (UserBlockedException e)
        {
            throw new LockedAccountException(e.getMessage(), e);
        }
        catch (RoleBlockedException e)
        {
            throw new LockedAccountException(e.getMessage(), e);
        }
        catch (Exception e)
        {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginPwd(), user.getLoginName());
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo()
    {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

    
}
