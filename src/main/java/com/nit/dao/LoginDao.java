package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nit.bean.UserBean;

public class LoginDao {
	public UserBean ub = null;

	public UserBean login(String uName, String password) {
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from userReg65 where uname = ? and pword = ?");
			ps.setString(1, uName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ub = new UserBean();
				ub.setUserName(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhoneNum(rs.getLong(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ub;
	}
}
