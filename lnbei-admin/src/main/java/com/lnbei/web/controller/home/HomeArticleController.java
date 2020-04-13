package com.lnbei.web.controller.home;

import java.io.IOException;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lnbei.common.annotation.Log;
import com.lnbei.common.config.Global;
import com.lnbei.common.config.ServerConfig;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.home.domain.HomeArticle;
import com.lnbei.home.domain.HomeArticleInfo;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.domain.HomeComment;
import com.lnbei.home.service.IHomeArticleInfoService;
import com.lnbei.home.service.IHomeArticleService;
import com.lnbei.home.service.IHomeCategoryService;
import com.lnbei.home.service.IHomeCommentService;
import com.lnbei.home.service.impl.HomeCommentServiceImpl;
import com.lnbei.system.domain.SysUser;
import com.lnbei.web.controller.common.CommonUnitBaseController;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.file.FileUploadUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.framework.web.exception.CommonExecption;

/**
 * 文章管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/home/homeArticle")
public class HomeArticleController extends CommonUnitBaseController {
	private String prefix = "home/homeArticle";

	@Autowired
	private IHomeArticleService homeArticleService;
	@Autowired
	private IHomeArticleInfoService homeArticleInfoService;
	@Autowired
	private IHomeCommentService homeCommentService;

	@Autowired
	private IHomeCategoryService homeCategoryService;

	@RequiresPermissions("home:homeArticle:view")
	@GetMapping()
	public String homeArticle() {
		return prefix + "/homeArticle";
	}

	/**
	 * 查询文章管理列表
	 */
	@RequiresPermissions("home:homeArticle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeArticle homeArticle) {
		startPage();
		List<HomeArticle> list = homeArticleService.selectHomeArticleList(homeArticle);
		return getDataTable(list);
	}

	/**
	 * 导出文章管理列表
	 */
	@RequiresPermissions("home:homeArticle:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HomeArticle homeArticle) {
		List<HomeArticle> list = homeArticleService.selectHomeArticleList(homeArticle);
		ExcelUtil<HomeArticle> util = new ExcelUtil<HomeArticle>(HomeArticle.class);
		return util.exportExcel(list, "homeArticle");
	}

	/**
	 * 新增文章管理
	 */
	@GetMapping("/add/{catgoryId}")
	public String add(@PathVariable("catgoryId") String catgoryId, ModelMap mmMap) {
		HomeCategory mmCategory = homeCategoryService.selectHomeCategoryById(catgoryId);
		if (mmCategory != null) {
			mmMap.put("categoryId", mmCategory.getMid());
			mmMap.put("category", mmCategory.getCategory());
		} else {
			mmMap.put("categoryId", "");
			mmMap.put("category", "");
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存文章管理
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("home:homeArticle:add")
	@Log(title = "文章管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	@Transactional
	public AjaxResult addSave(HomeArticle homeArticle, MultipartFile file,
			HomeArticleInfo mHomeArticleInfo) throws IOException {

//		fileInfo.setFilePath(fileName);
		if(file != null) {
			homeArticle.setImg(uplodFile(file,true));
		}
		
		int result = homeArticleService.insertHomeArticle(homeArticle, ShiroUtils.getUser());
		if (result > 0) {

			mHomeArticleInfo.setArticleId(homeArticle.getMid());
			result = homeArticleInfoService.insertHomeArticleInfo(mHomeArticleInfo, ShiroUtils.getUser());
		}

		return toAjax(result);
	}

	/**
	 * 修改文章管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		HomeArticle homeArticle = homeArticleService.selectHomeArticleById(mid);
		mmap.put("homeArticle", homeArticle);
		return prefix + "/edit";
	}

	/**
	 * 修改保存文章管理
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("home:homeArticle:edit")
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	@Transactional
	public AjaxResult editSave(HomeArticle homeArticle, MultipartFile file,
			HomeArticleInfo mHomeArticleInfo) throws IOException {
		if (file != null) {
			homeArticle.setImg(uplodFile(file,true));
		}
		HomeArticle mArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());

		int result = homeArticleService.updateHomeArticle(homeArticle, ShiroUtils.getUser());
		if (result > 0) {

			mHomeArticleInfo.setMid(mArticle.getmHomeArticleInfo().getMid());
			result = homeArticleInfoService.updateHomeArticleInfo(mHomeArticleInfo, ShiroUtils.getUser());
		}

		return toAjax(homeArticleService.updateHomeArticle(homeArticle, ShiroUtils.getUser()));
	}

	/**
	 * 删除文章管理
	 */
	@RequiresPermissions("home:homeArticle:remove")
	@Log(title = "文章管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(homeArticleService.deleteHomeArticleByIds(ids));
	}

	/**
	 * 删除文章管理
	 */
	@RequiresPermissions("home:homeArticle:updateAttr")
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@PostMapping("/updateAttr")
	@ResponseBody
	public AjaxResult updateAttr(String attr, String value, String mid) {
		if (StringUtils.isNotEmpty(attr) && StringUtils.isNotEmpty(value)) {
			HomeArticle mm = new HomeArticle();
			switch (attr) {
			case "isHot": {
				mm.setIsHot(value);
				break;
			}
			case "isRecom": {
				mm.setIsRecom(value);
				break;
			}
			case "isSale": {
				mm.setIsSale(value);
				break;
			}
			case "isNew": {
				mm.setIsNew(value);
				break;
			}
			case "isBest": {
				mm.setIsBest(value);
				break;
			}

			}
			return toAjax(homeArticleService.updateHomeArticleAttr(mm));
		}

		return toAjax(0);
	}

	/**
	 * 分类状态修改
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:changeStatus")
	@PostMapping("/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(HomeArticle homeArticle) {
		return toAjax(homeArticleService.changeStatus(homeArticle));
	}

	/**
	 * 分类状态修改
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:report")
	@PostMapping("/report")
	@ResponseBody
	public AjaxResult report(HomeArticle homeArticle) {
		HomeArticle mmArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());
		if(mmArticle.getStatus().equals("1")) {
			AjaxResult.error("请先启用在上报！！！");
		}
		if(!mmArticle.getFlag().equals("0") || !mmArticle.getFlag().equals("20")) {
			AjaxResult.error("已经上报无需在次上报");
		}		
		homeArticle.setFlag("1");
		return toAjax(homeArticleService.updateHomeArticle(homeArticle, ShiroUtils.getUser()));
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:audit")
	@PostMapping("/audit")
	@ResponseBody
	public AjaxResult audit(HomeArticle homeArticle, String auditFlag) {
		HomeArticle mArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());
		if (mArticle.getFlag().equals("2")) {

			return AjaxResult.error("已经审核通过无需在次审核");
		}
		SysUser mSysUser = ShiroUtils.getSysUser();
		homeArticle.setAuditor(mSysUser.getLogName());
		homeArticle.setAuditorId(mSysUser.getId());
		if (StringUtils.isEmpty(auditFlag)) {
			return toAjax(0);
		}
		if (auditFlag.equals("1")) {
			homeArticle.setFlag("2");
		} else if (auditFlag.equals("0")) {
			homeArticle.setFlag("20");
		}

		return toAjax(homeArticleService.updateHomeArticle(homeArticle, ShiroUtils.getUser()));
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:view")
	@GetMapping("/lookView")
	public String lookView(HomeArticle homeArticle, ModelMap mmMap) {
		HomeArticle mArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());
		mmMap.put("mArticle", mArticle);
		return prefix + "/lookView";
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:audit")
	@GetMapping("/auditView")
	public String auditView(HomeArticle homeArticle, ModelMap mmMap) {
		HomeArticle mArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());
		mmMap.put("mArticle", mArticle);
		return prefix + "/auditView";
	}
	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeArticle:audit")
	@GetMapping("/addComment")
	public String addComment(HomeArticle homeArticle, ModelMap mmMap) {
		HomeArticle mArticle = homeArticleService.selectHomeArticleById(homeArticle.getMid());
		mmMap.put("mArticle", mArticle);
		return prefix + "/addComment";
	}
	@RequiresPermissions("home:homeArticle:addComment")
	@Log(title = "评论", businessType = BusinessType.INSERT)
	@PostMapping("/addComment")
	@ResponseBody
	public AjaxResult addSave(HomeComment homeComment, String commentId)
	{		
		HomeComment mComment = homeCommentService.selectHomeCommentById(commentId);
		if(mComment == null) {
			throw new CommonExecption("不存在！！！");
		}
		homeComment.setParentId(commentId);
		return toAjax(homeCommentService.insertHomeComment(homeComment,ShiroUtils.getUser()));
	}
}
