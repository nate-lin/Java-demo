package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.system.model.User;


public class UserDao {

	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	//µÇÂ¼
	public User login(Connection con,User user) throws Exception{
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	//×¢²á
	public int register(Connection con,User user) throws Exception{
		String selcet = "select count(*) as totalCount from t_user";
		ResultSet query = con.prepareStatement(selcet).executeQuery();
		int rowCount = 0; 
		if(query.next()) { 
		  rowCount=query .getInt("totalCount")+1;
		}
		String sql="insert into t_user(id,userName,password) values("+rowCount+","+user.getUserName()+","+user.getPassword()+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		boolean execute = pstmt.execute();
		if (execute) {
			return 1;
		}
		return 0;
	}
}
