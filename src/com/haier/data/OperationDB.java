package com.haier.data;

/*
 * 数据库操作（向数据库添加数据） 类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationDB {
       private Connection con = null;
       public void addRcorder(InfoBean infoBean) throws SQLException{
        if(con ==null){
             con = BeyondbConnection.getConnection();
        }
       
       String sql = "insert into t_data (send,recive) values (?,?)";
     
           PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.setString(1, infoBean.getSend());
           pstmt.setString(2, infoBean.getRecive());
           
           pstmt.executeUpdate();   
    }
}
