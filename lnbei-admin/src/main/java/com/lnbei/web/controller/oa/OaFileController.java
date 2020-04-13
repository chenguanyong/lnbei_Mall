package com.lnbei.web.controller.oa;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lnbei.common.annotation.Log;
import com.lnbei.common.config.Global;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.oa.domain.OaFile;
import com.lnbei.oa.service.IOaFileService;
import com.lnbei.web.controller.common.CommonUnitBaseController;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.file.FileUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 文件管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-01
 */
@Controller
@RequestMapping("/oa/oaFile")
public class OaFileController extends CommonUnitBaseController {
	private String prefix = "oa/oaFile";

	@Autowired
	private IOaFileService oaFileService;

	@RequiresPermissions("oa:oaFile:view")
	@GetMapping()
	public String oaFile() {
		return prefix + "/oaFile";
	}

	/**
	 * 查询文件管理列表
	 */
	@RequiresPermissions("oa:oaFile:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OaFile oaFile) {
		startPage();
		List<OaFile> list = oaFileService.selectOaFileList(oaFile);
		return getDataTable(list);
	}

	/**
	 * 导出文件管理列表
	 */
	@RequiresPermissions("oa:oaFile:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(OaFile oaFile) {
		List<OaFile> list = oaFileService.selectOaFileList(oaFile);
		ExcelUtil<OaFile> util = new ExcelUtil<OaFile>(OaFile.class);
		return util.exportExcel(list, "oaFile");
	}

	/**
	 * 新增文件管理
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存文件管理
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("oa:oaFile:add")
	@Log(title = "文件管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OaFile oaFile, MultipartFile file) throws IOException {
		if (file != null) {
			String filePath = uplodFile(file, false);
			oaFile.setFilePath(filePath);
		}
		oaFile.setFileNum(StringUtils.createNUM());
		return toAjax(oaFileService.insertOaFile(oaFile, ShiroUtils.getUser()));
	}

	/**
	 * 修改文件管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		OaFile oaFile = oaFileService.selectOaFileById(mid);
		mmap.put("oaFile", oaFile);
		return prefix + "/edit";
	}

	/**
	 * 修改保存文件管理
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("oa:oaFile:edit")
	@Log(title = "文件管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OaFile oaFile, MultipartFile file) throws IOException {
		if (file != null) {
			String filePath = uplodFile(file, false);
			oaFile.setFilePath(filePath);
		}
		return toAjax(oaFileService.updateOaFile(oaFile, ShiroUtils.getUser()));
	}

	/**
	 * 删除文件管理
	 */
	@RequiresPermissions("oa:oaFile:remove")
	@Log(title = "文件管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(oaFileService.deleteOaFileByIds(ids));
	}

	/**
	 * 通用下载请求
	 * 
	 * @param fileName 文件名称
	 * @param delete   是否删除
	 */
	@GetMapping("/download")
	public void fileDownload(OaFile mFile, HttpServletResponse response, HttpServletRequest request) {

		OaFile file = oaFileService.selectOaFileById(mFile.getMid());
		mFile.setDownSize(1);
		oaFileService.updateOaFileDEC(mFile);
		fileCommonDownload(file.getFilePath(), false, response, request, Global.getUploadPath());
	}

}
