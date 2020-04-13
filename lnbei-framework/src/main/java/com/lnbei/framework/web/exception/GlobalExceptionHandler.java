package com.lnbei.framework.web.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.exception.BusinessException;
import com.lnbei.common.exception.DemoModeException;
import com.lnbei.common.utils.ServletUtils;
import com.lnbei.exception.EditExecption;
import com.lnbei.exception.NoEditExecption;
import com.lnbei.exception.StocksSizeException;
import com.lnbei.exception.SysdeptNullException;
import com.lnbei.exception.ObjectNullExecption;
import com.lnbei.framework.util.PermissionUtils;

/**
 * 全局异常处理器
 * 
 * @author lnbei
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 权限校验失败
     */
    @ExceptionHandler(AuthorizationException.class)
    public AjaxResult handleAuthorizationException(AuthorizationException e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(PermissionUtils.getMsg(e.getMessage()));
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public AjaxResult handleException(HttpRequestMethodNotSupportedException e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult notFount(RuntimeException e)
    {
        log.error("运行时异常:", e);
        return AjaxResult.error("运行时异常:" + e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error("服务器错误，请联系管理员");
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public AjaxResult businessException(BusinessException e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 演示模式异常
     */
    @ExceptionHandler(DemoModeException.class)
    public AjaxResult demoModeException(DemoModeException e)
    {
        return AjaxResult.error("演示模式，不允许操作");
    }
    @ExceptionHandler(CommonExecption.class)
    public Object commonException(HttpServletRequest request, CommonExecption e)
    {
        log.error(e.getMessage(), e);
        if (ServletUtils.isAjaxRequest(request))
        {
            return AjaxResult.error(e.getMessage());
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/com");
            modelAndView.addObject("msg", e.getMessage());
            return modelAndView;
        }
    }
    @ExceptionHandler(ObjectNullExecption.class)
    public Object ObjectNullExecption(HttpServletRequest request, ObjectNullExecption e)
    {
        log.error(e.getMessage(), e);
        if (ServletUtils.isAjaxRequest(request))
        {
            return AjaxResult.error(e.getMessage());
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/com");
            modelAndView.addObject("msg", e.getMessage());
            return modelAndView;
        }
    }    
    /**
     * 库存不足的时候
     * @param e
     * @return
     */
    @ExceptionHandler(StocksSizeException.class)
    public AjaxResult stocksSizeException(StocksSizeException e) {
    	return AjaxResult.error(e.getMessage());
    }
    /**
     * 当部门为空指针的时候
     * @param e
     * @return
     */
    @ExceptionHandler(SysdeptNullException.class)
    public AjaxResult sysdeptNullException(SysdeptNullException e) {
    	return AjaxResult.error(e.getMessage());
    }
    
    @ExceptionHandler(EditExecption.class)
    public Object handleEditException(HttpServletRequest request, EditExecption e)
    {
        log.error(e.getMessage(), e);
        if (ServletUtils.isAjaxRequest(request))
        {
            return AjaxResult.error(e.getMessage());
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/edit");
            return modelAndView;
        }
    }

    @ExceptionHandler(NoEditExecption.class)
    public Object handleNoEditException(HttpServletRequest request, NoEditExecption e)
    {
        log.error(e.getMessage(), e);
        if (ServletUtils.isAjaxRequest(request))
        {
            return AjaxResult.error(e.getMessage());
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/edit");
            return modelAndView;
        }
    }    
}
