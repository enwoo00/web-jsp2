package com.web.service;

import java.util.ArrayList;
import java.util.List;

import com.web.dao.UserDAO;
import com.web.dto.UserDTO;

public class UserService {
	private UserDAO userDAO = new UserDAO();
	
	public List<UserDTO> getUsers() {
			//List<UserDTO> users = userDAO.getUsers();
			return userDAO.getUsers();
		
		
	}

	public UserDTO getUser(int uiNum) {
		//UserDTO user= userDAO.getUser(uiNum);
		return userDAO.getUser(uiNum);
	}
}
