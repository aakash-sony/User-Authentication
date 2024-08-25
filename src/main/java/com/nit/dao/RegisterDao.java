package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bean.UserBean;

public class RegisterDao {
	public int k = 0;

	public int register(UserBean ub) {

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("Insert into userReg65 values (?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassword());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getmId());
			ps.setLong(7, ub.getPhoneNum());
			
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
