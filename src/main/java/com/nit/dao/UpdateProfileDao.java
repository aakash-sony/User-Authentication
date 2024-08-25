package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bean.UserBean;

public class UpdateProfileDao 
{
	public int k = 0;
	public int update(UserBean ub)
	{
		try {
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement
					("update userReg65 set addr =?,mId =?,phone=? where uname =? and pWord=?");
			ps.setString(1, ub.getAddress());
			ps.setString(2, ub.getmId());
			ps.setLong(3, ub.getPhoneNum());
			ps.setString(4, ub.getUserName());
			ps.setString(5, ub.getPassword());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return k;
	}
}
