package com.lnbei.web.controller.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.lnbei.common.config.Global;
import com.lnbei.common.config.ServerConfig;
import com.lnbei.common.core.controller.BaseController;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.file.FileUploadUtils;
import com.lnbei.common.utils.file.FileUtils;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.framework.web.exception.CommonExecption;
import com.lnbei.oa.domain.OaFile;
import com.lnbei.oa.service.IOaFileService;

public class CommonUnitBaseController extends BaseController {
	@Autowired
	private IOaFileService oaFileServiceImpl;
	@Autowired
	private ServerConfig serverConfig;

	protected int saveOaFile(MultipartFile file, String filePath) throws CommonExecption {
		OaFile mFile = new OaFile();
		mFile.setAccessType("2");
		mFile.setFileName(file.getOriginalFilename());
		mFile.setFileSize(file.getSize());
		mFile.setFilePath(filePath);
		mFile.setFileNum("F" + StringUtils.createNUM());
		mFile.setFileSuffix(file.getContentType());
		mFile.setFileType("0");
		int r = oaFileServiceImpl.insertOaFile(mFile, ShiroUtils.getUser());
		if (r == 0) {
			throw new CommonExecption("文件上传错误");
		}
		return r;
	}

	/**
	 * 吹上传文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uplodFile(MultipartFile file, Boolean isSaveFile) throws IOException {

		String filePath = Global.getUploadPath();
//		// 上传并返回新文件名称
		String fileName = FileUploadUtils.upload(filePath, file);
		if(isSaveFile) {
			saveOaFile(file, fileName);
		}
		String filepathString = Global.getUploadPathFloder() + fileName;
		return filepathString;
	}

	/**
	 * 吹上传文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uplodFileURL(MultipartFile file, Boolean isSaveFile) throws IOException {

		String filePath = Global.getUploadPath();
//		// 上传并返回新文件名称
		String fileName = FileUploadUtils.upload(filePath, file);
		if(isSaveFile) {
			saveOaFile(file, fileName);
		}
		String filepathString = serverConfig.getUrl() + Global.getUploadPathFloder() + fileName;
		return filepathString;
	}

	public String setFileDownloadHeader(HttpServletRequest request, String fileName)
			throws UnsupportedEncodingException {
		final String agent = request.getHeader("USER-AGENT");
		String filename = fileName;
		if (agent.contains("MSIE")) {
			// IE浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			filename = new String(fileName.getBytes(), "ISO8859-1");
		} else if (agent.contains("Chrome")) {
			// google浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			// 其它浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}

	public void fileCommonDownload(String fileName, Boolean delete, HttpServletResponse response,
			HttpServletRequest request, String filePathBase) {
		try {
			if (!FileUtils.isValidFilename(fileName)) {
				throw new Exception(StringUtils.format(" 文件名称({})非法，不允许下载。 ", fileName));
			}
			String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
			String filePath = filePathBase + fileName;

			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + setFileDownloadHeader(request, realFileName));
			FileUtils.writeBytes(filePath, response.getOutputStream());
			if (delete) {
				FileUtils.deleteFile(filePath);
			}
		} catch (Exception e) {
			logger.error("下载文件失败", e);
		}
	}

}
