package com.kgc.pojo;

/**
 * javabean类
 * @author: LKF
 * @date: 2019/3/27 11:10
 */

import java.util.Date;

/**
 * CREATE TABLE `news_detail` (
 *   `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
 *   `categoryId` bigint(10) DEFAULT NULL COMMENT '新闻类别id',
 *   `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻标题',
 *   `summary` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻摘要',
 *   `content` text COLLATE utf8_unicode_ci COMMENT '新闻内容',
 *   `picPath` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻图片路径',
 *   `author` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发表者',
 *   `createDate` datetime DEFAULT NULL COMMENT '创建时间',
 *   `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='新闻明细表';
 */
public class News {

    /**
     * //    私有属性
     */
    private int id;
    private int categoryId;
    private String title;
    private String summary;
    private String content;
    private String picPath;
    private String author;
    private Date createDate;
    private Date modifyDate;


    /**
     * //getter和setter
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
