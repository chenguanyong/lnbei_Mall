package com.lnbei.oa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.oa.mapper.OaFileMapper;
import com.lnbei.oa.domain.OaFile;
import com.lnbei.oa.service.IOaFileService;
import com.lnbei.system.domain.SysUser;
import com.lnbei.common.core.text.Convert;

/**
 * 文件管理 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-01
 */
@Service
public class OaFileServiceImpl implements IOaFileService {
	@Autowired
	private OaFileMapper oaFileMapper;

	/**
	 * 查询文件管理信息
	 * 
	 * @param mid 文件管理ID
	 * @return 文件管理信息
	 */
	@Override
	public OaFile selectOaFileById(String mid) {
		return oaFileMapper.selectOaFileById(mid);
	}

	/**
	 * 查询文件管理列表
	 * 
	 * @param oaFile 文件管理信息
	 * @return 文件管理集合
	 */
	@Override
	public List<OaFile> selectOaFileList(OaFile oaFile) {
		return oaFileMapper.selectOaFileList(oaFile);
	}

	/**
	 * 新增文件管理
	 * 
	 * @param oaFile 文件管理信息
	 * @return 结果
	 */
	@Override
	public int insertOaFile(OaFile oaFile, Object user) {
		oaFile.insertData((SysUser) user);
		return oaFileMapper.insertOaFile(oaFile);
	}

	/**
	 * 修改文件管理
	 * 
	 * @param oaFile 文件管理信息
	 * @return 结果
	 */
	@Override
	public int updateOaFile(OaFile oaFile, Object user) {
		oaFile.updateData((SysUser) user);
		return oaFileMapper.updateOaFile(oaFile);
	}

	/**
	 * 删除文件管理对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteOaFileByIds(String ids) {
		return oaFileMapper.deleteOaFileByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updateOaFileINC(OaFile oaFile) {
		// TODO Auto-generated method stub
		return oaFileMapper.updateOaFileINC(oaFile);
	}

	@Override
	public int updateOaFileDEC(OaFile oaFile) {
		// TODO Auto-generated method stub
		return oaFileMapper.updateOaFileDEC(oaFile);
	}

}
