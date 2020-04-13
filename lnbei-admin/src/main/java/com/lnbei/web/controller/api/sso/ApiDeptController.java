package com.lnbei.web.controller.api.sso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.system.domain.SysDept;
import com.lnbei.system.service.impl.SysDeptServiceImpl;

@Controller
@RequestMapping("/api/dept")
public class ApiDeptController extends BaseController {

	@Autowired
	private SysDeptServiceImpl deptService;

	@GetMapping("/getDeptAllList")
	@ResponseBody
	public List<SysDept> getDeptAllList() {
		List<SysDept> mSysDepts = deptService.getDeptsChildrenList(null);
		return mSysDepts;
	}

	@PostMapping("/getDeptChildenListByDeptPid/{pid}")
	@ResponseBody
	public List<SysDept> getDeptChildenListByDeptPid(@PathVariable("pid")SysDept pid) {
		List<SysDept> mSysDepts = deptService.getDeptsChildrenList(pid);
		return mSysDepts;
	}

	@GetMapping("/getDeptByDeptId/{deptId}")
	@ResponseBody
	public SysDept getDeptByDeptId(@PathVariable("deptId") String deptId) {
		SysDept sysDept = deptService.selectDeptById(deptId);
		return sysDept;
	}

	@GetMapping("/getDeptZtree")
	@ResponseBody
	public List<Ztree> getDeptZtree() {
		List<Ztree> mZtrees = deptService.getDeptAllZtree();
		return mZtrees;
	}

	@PostMapping("/getDeptchildrenZtree")
	@ResponseBody
	public List<Ztree> getDeptchildrenZtree(SysDept dept) {
		List<Ztree> mZtrees = deptService.getDeptChildrenZtrees(dept);
		return mZtrees;
	}

	@PostMapping("/getDeptListByWhere")
	@ResponseBody
	public TableDataInfo getDeptListByWhere(SysDept dept) {
		startPage();
		List<SysDept> mSysDepts = deptService.selectDeptList(dept);
		return getDataTable(mSysDepts);
	}
}
