package com.usermanagement;

import java.sql.Connection;
import java.util.ArrayList;

public class SecurityManager {

	public ArrayList<UserVO> getAllUsersList() throws Exception {
		ArrayList<UserVO> userList = null;
		try {
			DbConnection database = new DbConnection();
			Connection connection = database.getConnection();
			LoginHandler loginHandler = new LoginHandler();
			userList = loginHandler.getAllUsers(connection);

		} catch (Exception e) {
			throw e;
		}
		return userList;
	}

}