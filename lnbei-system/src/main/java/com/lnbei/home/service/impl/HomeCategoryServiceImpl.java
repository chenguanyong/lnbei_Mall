package com.lnbei.home.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeCategoryMapper;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.service.IHomeCategoryService;

import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 分类 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class HomeCategoryServiceImpl implements IHomeCategoryService {
	@Autowired
	private HomeCategoryMapper homeCategoryMapper;

	/**
	 * 查询分类信息
	 * 
	 * @param mid 分类ID
	 * @return 分类信息
	 */
	@Override
	public HomeCategory selectHomeCategoryById(String mid) {
		return homeCategoryMapper.selectHomeCategoryById(mid);
	}

	/**
	 * 查询分类列表
	 * 
	 * @param homeCategory 分类信息
	 * @return 分类集合
	 */
	@Override
	public List<HomeCategory> selectHomeCategoryList(HomeCategory homeCategory) {
		return homeCategoryMapper.selectHomeCategoryList(homeCategory);
	}

	/**
	 * 新增分类
	 * 
	 * @param homeCategory 分类信息
	 * @return 结果
	 */
	@Override
	public int insertHomeCategory(HomeCategory homeCategory, Object user) {
		HomeCategory pHomeCategory = homeCategoryMapper.selectHomeCategoryById(homeCategory.getParentId());
		if (pHomeCategory == null) {
			homeCategory.setPath("0");
		} else {

			String path = pHomeCategory.getPath();

			if (StringUtils.isNotEmpty(path)) {

				homeCategory.setPath(path + "-" + homeCategory.getParentId());
			} else {
				homeCategory.setPath("0");
			}

		}
		homeCategory.initInsert(user);
		return homeCategoryMapper.insertHomeCategory(homeCategory);
	}

	/**
	 * 修改分类
	 * 
	 * @param homeCategory 分类信息
	 * @return 结果
	 */
	@Override
	public int updateHomeCategory(HomeCategory homeCategory, Object user) {
		HomeCategory hCategory = homeCategoryMapper.selectHomeCategoryById(homeCategory.getMid());
		homeCategory.setPath(updatePath(hCategory));
		homeCategory.initUpdate(user);
		return homeCategoryMapper.updateHomeCategory(homeCategory);
	}

	/**
	 * 删除分类对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHomeCategoryByIds(String ids) {
		return homeCategoryMapper.deleteHomeCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Ztree> selectCategory(HomeCategory mCategory) {
		// TODO Auto-generated method stub
		List<HomeCategory> deptList = homeCategoryMapper.selectHomeCategoryListByParent(mCategory);
		List<Ztree> ztrees = initZtree(deptList);
		return ztrees;
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HomeCategory> mCategories) {
		return initZtree(mCategories, null);
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HomeCategory> mConfigTrees, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		
		for (HomeCategory homeCategory : mConfigTrees) {
			// if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
			Ztree ztree = new Ztree();
			ztree.setId(homeCategory.getMid());
			ztree.setpId(homeCategory.getParentId());
			ztree.setName(homeCategory.getCategory());
			ztree.setTitle(homeCategory.getCategory());
			// if (isCheck) {
			// ztree.setChecked(roleDeptList.contains(homeCategory.getId() +
			// homeCategory.getName()));
			// }
			ztrees.add(ztree);
			// }
		}
		return ztrees;
	}

	/***
	 * 改变状态
	 */
	public int changeStatus(HomeCategory mCategory) {

		return homeCategoryMapper.changeStatus(mCategory);
	}

	/**
	 * 获取分类通过分类标识
	 */
	@Override
	public HomeCategory selectHomeCategoryByFlag(String flag) {
		// TODO Auto-generated method stub
		return homeCategoryMapper.selectHomeCategoryByFlag(flag);
	}

	/**
	 * 更新路径
	 * 
	 * @return
	 */
	private String updatePath(HomeCategory mPHomeCategory) {

		String pidString = mPHomeCategory.getParentId();

		String[] mPathStrings = Convert.toStrArray(mPHomeCategory.getPath());

		String lastMidString = mPathStrings[mPathStrings.length - 1];

		if (pidString.equals(lastMidString)) {
			return mPHomeCategory.getPath();
		} else {

			mPathStrings[mPathStrings.length - 1] = pidString;
			return Convert.arrayTostr(mPathStrings, '-');
		}
	}
	
	/**
	 * 根据父ID查询数据
	 * @param parentId
	 * @return
	 */
	public List<HomeCategory> selectHomeCategoryListByParent(HomeCategory homeCategory) {
		return homeCategoryMapper.selectHomeCategoryListByParent(homeCategory);
	}

	@Override
	public List<HomeCategory> selectHomeCategoryByPathParentId(HomeCategory homeCategory) {
		// TODO Auto-generated method stub
		return homeCategoryMapper.selectHomeCategoryByPathParentId(homeCategory);
	}
}
