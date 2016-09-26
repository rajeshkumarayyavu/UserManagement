package com.usermanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {
		return getAllUsersList();
	}

	public String getAllUsersList() {
		String userListData = null;
		try {
			ArrayList<UserVO> userList = null;
			SecurityManager securityManager = new SecurityManager();
			userList = securityManager.getAllUsersList();
			for (UserVO userVO : userList) {
				return "Logged in User:" + userVO.getUsername();
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return "You are not a Valid User";
	}
}
