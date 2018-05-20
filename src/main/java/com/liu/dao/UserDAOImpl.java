package com.liu.dao;

import com.liu.db.DB;
import com.liu.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26522 on 2018/5/20.
 */
public class UserDAOImpl {
    private Connection conn;
    public UserDAOImpl(){
        conn= DB.getConnection();
    }
    public boolean edit(User user){
        PreparedStatement pstmt=null;
        boolean flag=false;
        try{
            pstmt=conn.prepareStatement("update  user1  set username=? , password=? where id=?");
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());

            pstmt.setInt(3,user.getId());


            flag=pstmt.executeUpdate()>0;


        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flag;

        }


    }
    public User queryId(int id){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        User user=null;
        try{
            pstmt=conn.prepareStatement("select * from user1 where id=?");
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("id"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;

    }

    public boolean del(int id){
        PreparedStatement pstmt=null;

        boolean flag=false;
        try{
            pstmt=conn.prepareStatement("delete from user1 where id=?");
            pstmt.setInt(1,id);


            flag=pstmt.executeUpdate()>0;


        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flag;

        }

    }
    public List<User> queryAll(){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<User> list=new ArrayList<User>();
        try{
            pstmt=conn.prepareStatement("select * from user1 order by id desc");
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("id"));
                list.add(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;

    }
    public boolean register(User user){
        PreparedStatement pstmt=null;
        boolean flag=false;
        try{
            pstmt=conn.prepareStatement("insert into user1(username,password) values(?,?)");
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());

            flag=pstmt.executeUpdate()>0;


        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flag;

        }
    }

}
