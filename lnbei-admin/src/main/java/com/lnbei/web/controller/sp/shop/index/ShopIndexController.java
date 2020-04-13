package com.lnbei.web.controller.sp.shop.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.ServletUtils;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.framework.shiro.token.MemberToken;
import com.lnbei.framework.shiro.type.VirtualType;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.system.domain.SysMenu;
import com.lnbei.system.service.ISysMenuService;
/***
 * 
 * 商家店铺后台
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/index")
public class ShopIndexController extends BaseController {
	private String prefix = "spshop/index";
    @Autowired
    private ISysMenuService menuService;
	@GetMapping()
	public String index(ModelMap mmap) {
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByShopMemberUser(ShiroUtils.getUser());
        mmap.put("menus", menus);
		return prefix + "/index";
	}
	/**
	 * 登录
	 * @return
	 */
	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
		return prefix + "/login";
	}
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe)
    {
        MemberToken token = new MemberToken(username, password, rememberMe,VirtualType.User);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }	
}
