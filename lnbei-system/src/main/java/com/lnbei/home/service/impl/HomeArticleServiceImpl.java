package com.lnbei.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeArticleMapper;
import com.lnbei.home.domain.HomeArticle;
import com.lnbei.home.service.IHomeArticleService;
import com.lnbei.common.core.text.Convert;

/**
 * 文章主 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class HomeArticleServiceImpl implements IHomeArticleService 
{
	@Autowired
	private HomeArticleMapper homeArticleMapper;

	/**
     * 查询文章主信息
     * 
     * @param mid 文章主ID
     * @return 文章主信息
     */
    @Override
	public HomeArticle selectHomeArticleById(String mid)
	{
	    return homeArticleMapper.selectHomeArticleById(mid);
	}
	
	/**
     * 查询文章主列表
     * 
     * @param homeArticle 文章主信息
     * @return 文章主集合
     */
	@Override
	public List<HomeArticle> selectHomeArticleList(HomeArticle homeArticle)
	{
	    return homeArticleMapper.selectHomeArticleList(homeArticle);
	}
	
    /**
     * 新增文章主
     * 
     * @param homeArticle 文章主信息
     * @return 结果
     */
	@Override
	public int insertHomeArticle(HomeArticle homeArticle, Object user)
	{
		homeArticle.initInsert(user);
	    return homeArticleMapper.insertHomeArticle(homeArticle);
	}
	
	/**
     * 修改文章主
     * 
     * @param homeArticle 文章主信息
     * @return 结果
     */
	@Override
	public int updateHomeArticle(HomeArticle homeArticle, Object user)
	{
		homeArticle.initUpdate(user);
	    return homeArticleMapper.updateHomeArticle(homeArticle);
	}

	/**
     * 删除文章主对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHomeArticleByIds(String ids)
	{
		return homeArticleMapper.deleteHomeArticleByIds(Convert.toStrArray(ids));
	}

	/**
	 * 更新文章属性
	 * @param homeArticle
	 * @return
	 */
	@Override
	public int updateHomeArticleAttr(HomeArticle homeArticle) {
	
		return homeArticleMapper.updateHomeArticleAttr(homeArticle);
	}
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	@Override
	public int changeStatus(HomeArticle homeArticle) {
		// TODO Auto-generated method stub
		return homeArticleMapper.changeStatus(homeArticle);
	}
	
}
