package com.lnbei.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.framework.util.ShiroUtils;

import com.lnbei.oa.service.IOaMessageLogService;
import com.lnbei.system.domain.SysDept;
import com.lnbei.system.domain.SysRole;
import com.lnbei.system.service.ISysDeptService;

/**
 * 部门信息
 * 
 * @author lnbei
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController
{
    private String prefix = "system/dept";

    @Autowired
    private ISysDeptService deptService;
    
    @Autowired
    private IOaMessageLogService oaMessageLogService;

    @RequiresPermissions("system:dept:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

    @RequiresPermissions("system:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDept dept)
    {
    	startPage();
        List<SysDept> deptList = deptService.selectDeptList(dept);
        return getDataTable(deptList);
    }

    /**
     * 新增部门
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap)
    {
    	SysDept mSysDept = new SysDept();
    	if(!id.equals("0")) {
    		mSysDept = deptService.selectDeptById(id);
    	}
        mmap.put("dept", mSysDept);
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:dept:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDept dept)
    {
        dept.setCreateBy(ShiroUtils.getLoginName());
        int result = deptService.insertDept(dept);
        oaMessageLogService.sendMsg("dept", dept.getId(), 0, 0);//向子系统发送消息
        return toAjax(result);
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") String deptId, ModelMap mmap)
    {
        SysDept dept = deptService.selectDeptById(deptId);
        if (StringUtils.isNotNull(dept) && "100" == deptId)
        {
            dept.setParentName("无");
        }
        mmap.put("dept", dept);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dept:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDept dept)
    {
        dept.setUpdateBy(ShiroUtils.getLoginName());
        oaMessageLogService.sendMsg("dept", dept.getId(), 1, 0);//向子系统发送消息
        return toAjax(deptService.updateDept(dept));
    }
    /**
     * 修改排序值
     * @return
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dept:editSort")
    @GetMapping("/editSort/{id}")
    public String editSort(@PathVariable("id") String id, ModelMap mmMap ) {
    	mmMap.put("dept", deptService.selectDeptById(id));
    	return prefix + "/editSort";
    }
    /**
     * 保存排序值
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dept:editSort")
    @PostMapping("/sortSave")
    @ResponseBody
    public AjaxResult editSortSave(SysDept dept)
    {
        dept.setUpdateBy(ShiroUtils.getLoginName());
        oaMessageLogService.sendMsg("dept", dept.getId(), 1, 0);//向子系统发送消息
        return toAjax(deptService.updateDeptSort(dept));
    }
    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:dept:remove")
    @PostMapping("/remove/{deptId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("deptId") String deptId)
    {
        if (deptService.selectDeptCount(deptId) > 0)
        {
            return error(1, "存在下级部门,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId))
        {
            return error(1, "部门存在用户,不允许删除");
        }
        int result = deptService.deleteDeptById(deptId);
        if(result>0) {
        	oaMessageLogService.sendMsg("dept", deptId, 2, 0);//向子系统发送消息
        }
        return toAjax(result);
    }

    /**
     * 校验部门名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept)
    {
        return deptService.checkDeptNameUnique(dept);
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") String deptId, ModelMap mmap)
    {
    	SysDept mSysDept = new SysDept();//.selectDeptById(deptId);
    	if(!deptId.equals("0")) {
    		mSysDept = deptService.selectDeptById(deptId);
    	}
        mmap.put("dept", mSysDept);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = deptService.selectDeptTree(new SysDept());
        return ztrees;
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/roleDeptTreeData")
    @ResponseBody
    public List<Ztree> deptTreeData(SysRole role)
    {
        List<Ztree> ztrees = deptService.roleDeptTreeData(role);
        return ztrees;
    }
}
