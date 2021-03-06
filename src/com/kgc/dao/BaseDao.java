package com.kgc.dao;

import com.kgc.util.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author: LKF
 * @date: 2019/3/26 18:12
 */
public class BaseDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected Statement stmt;
    protected ResultSet rs;

/**
 *普通方式访问数据库
 */
//    public boolean getConnection(){
////        读出配置信息
//        String driver="com.mysql.jdbc.Driver";
//        String url="jdbc:mysql://127.0.0.1:3306/kgcnews";
//        String username="root";
//        String password="root";
////        加载JDBC驱动
//        try {
//            Class.forName(driver);
////            与数据库建立连接
//            conn= DriverManager.getConnection(url,username,password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return  false;
//        }
//        return true;
//    }
    /**
     * 通过配置文件访问数据库
     */

    public boolean getConnection(){
        //        读出配置信息
        String driver= ConfigManager.getInstance().getString("jdbc.driver_class");
        String url=ConfigManager.getInstance().getString("jdbc.connection.url");
        String username=ConfigManager.getInstance().getString("jdbc.connection.username");
        String password=ConfigManager.getInstance().getString("jdbc.connection.password");
//        加载JDBC驱动
        try {
            Class.forName(driver);
//            与数据库建立连接
            conn= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }
    /**
     * 增删改
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql,Object[] params){
        int updateRows=0;
        if (getConnection()){
            try {
                ps=conn.prepareStatement(sql);
//                填充占位符
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
                updateRows=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRows;
    }

//    查询
    public ResultSet executeSQL(String sql,Object[] params){
        if (getConnection()){
            try {
                ps=conn.prepareStatement(sql);
//                填充占位符
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
                rs=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    /**
     * 配置jdbc数据源
     * @return
     */
//    public Connection getConnection2(){
//        try {
//            Context cxt=new InitialContext();
//            DataSource ds= (DataSource) cxt.lookup("java:comp/env/jdbc/kgcnews");
//            conn=ds.getConnection();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

//    关闭资源
    public boolean closeResource(){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
