package com.kgc.dao;

import javax.xml.crypto.Data;

/**
 * @author: LKF
 * @date: 2019/3/26 18:13
 */
public interface NewsDao {
    /**
     * 查询新闻信息
     */
   public void getNewsList();

    /**
     * 增加新闻信息
     * @param id
     * @param categoryId
     * @param title
     * @param summary
     * @param content
     * @param createDate
     */
   public void add(int id, int categoryId, String title, String summary,
                   String content, Data createDate);

    /**
     * 修改新闻信息
     * @param id
     * @param title
     */
   public void update(int id,String title);

    /**
     * 删除新闻信息
     * @param id
     */
   public void delete(int id);

    /**
     * 查找特定标题的新闻信息
     * @param title
     */
   public void getNewsByTitle(String title);
}
