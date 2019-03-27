package com.kgc.dao.impl;

import com.kgc.dao.BaseDao;
import com.kgc.dao.NewsDao;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author: LKF
 * @date: 2019/3/26 18:13
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {
    /**
     * 查询新闻信息
     */
    @Override
    public void getNewsList() {
        String sql="select * from news_detail";
        Object[] params={};
        rs=this.executeSQL(sql,params);
        try {
            while (rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String summary=rs.getString("summary");
                String content=rs.getString("content");
                String author=rs.getString("author");
                Timestamp createDate=rs.getTimestamp("createDate");
                System.out.println(id+"\t"+title+"\t"+summary+"\t"+content+"\t"+author
                        +"\t"+ createDate);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }

    }

    /**
     * 增加新闻信息
     * @param id
     * @param categoryId
     * @param title
     * @param summary
     * @param content
     * @param createDate
     */
    @Override
    public void add(int id, int categoryId, String title, String summary, String content, Data createDate) {
        try {
            String sql="insert into news_detail(id,categoryId,title,summary,content,createDate) values(?,?,?,?,?,?)";
            Object[] params={id,categoryId,title,summary,content,createDate};
            int i=this.executeUpdate(sql,params);
//            处理执行结果
            if (i>0){
                System.out.println("插入新闻成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
    }

    /**
     * 修改新闻标题
     * @param id
     * @param title
     */
    @Override
    public void update(int id, String title) {
        try {
            String sql="update news_detail set title=? where id=?";
            Object[] params={title,id};
            int i=this.executeUpdate(sql,params);
            if (i>0){
                System.out.println("修改新闻标题成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
    }

    /**
     * 删除新闻信息
     * @param id
     */
    @Override
    public void delete(int id) {
        try {
            String sql="delete from news_detail where id=?";
            Object[] params={id};
            int i=this.executeUpdate(sql,params);
            if (i>0){
                System.out.println("删除新闻成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
    }

    /**
     * 查找特定标题的新闻信息
     * @param title
     */
    @Override
    public void getNewsByTitle(String title) {
        try{
            String sql="select id,title from news_detail where title like ?";
            Object[] params={title};
            rs=this.executeSQL(sql,params);
            while (rs.next()){
                int id=rs.getInt("id");
                String newsTitle=rs.getString("title");
                System.out.println(id+"\t"+newsTitle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
    }

    public static void main(String[] args) {
        NewsDao newsDao = new NewsDaoImpl();
        newsDao.getNewsList();
    }
}
