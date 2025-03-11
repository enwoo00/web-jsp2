package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.UserDTO;
import com.web.service.UserService;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		// /user/user-list
		int idx = uri.lastIndexOf("/"); //5
		String cmd = uri.substring(idx+1); // user-list (+1안하면 /user-list)
		if("user-list".equals(cmd)) {
			List<UserDTO> users = userService.getUsers();
			request.setAttribute("users", users);
		}else if("user-view".equals(cmd)) {
			String uiNumStr = request.getParameter("uiNum");
			int uiNum = Integer.parseInt(uiNumStr);
			UserDTO user = userService.getUser(uiNum);
			request.setAttribute("user", user);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views" + uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		String uiNumStr = request.getParameter("uiNum");
		int uiNum=0;
		if(uiNumStr!=null) {
			uiNum=Integer.parseInt(uiNumStr);
		}
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		String uiName = request.getParameter("uiName");
		String uiAge = request.getParameter("uiAge");
		String uiPhone = request.getParameter("uiPhone");
		String uiAddress = request.getParameter("uiAddress");
		String uiTrans = request.getParameter("uiTrans");
		UserDTO user = new UserDTO();
		user.setUiNum(uiNum);
		user.setUiId(uiId);
		user.setUiPwd(uiPwd);
		user.setUiName(uiName);
		if(uiAge!=null) {
			user.setUiAge(Integer.parseInt(uiAge));
		}
		user.setUiPhone(uiPhone);
		user.setUiAddress(uiAddress);
		user.setUiTrans(uiTrans);
		
		if("insert".equals(cmd)) {
			int result = userService.insertUser(user);
			String msg = "입력이 실패하였습니다.";
			if(result==1) {
				msg = "입력이 성공하였습니다.";
			}
			String url =  "/user/user-list";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request,response);
			
		}else if("update".equals(cmd)) {
			int result = userService.updateUser(user);
			String msg = "실패하였습니다.";
			if(result==1) {
				msg = "성공하였습니다.";
			}
			String url = "/user/user-view?uiNum="+uiNum;
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request, response);
			
		}else if("update".equals(cmd)) {
			int result = userService.deleteUser(uiNum);
			String msg = "실패하였습니다.";
			if(result==1) {
				msg="성공하였습니다.";
			}
			String url = "/user/user-list";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request, response);
		}
	}

}
