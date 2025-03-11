package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.FoodDTO;
import com.web.service.FoodService;


public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodService foodService = new FoodService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select list, select one
		// 요청 주소의 마지막이 food-list면 list, food-view면 one로직을 수행
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if("food-list".equals(cmd)) {
			List<FoodDTO> foods = foodService.selectFoods(null);
			request.setAttribute("foods", foods);
			//out.print(foods);
		}else if("food-view".equals(cmd) || "food-update".equals(cmd)) {
			String fiNumStr = request.getParameter("fiNum");
			int fiNum = Integer.parseInt(fiNumStr);
			FoodDTO food = foodService.selectFood(fiNum);
			request.setAttribute("food", food);
			//out.print(food);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views"+uri);
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// insert, update, delete
		// 요청 주소의 마지막이 insert면 insert, update면 update, delete면 delete 로직을 수행
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		String cmd = uri.substring(idx);
		String fiName = request.getParameter("fiName");
		String fiPriceStr=request.getParameter("fiPrice");
		String fiNumStr = request.getParameter("fiNum");
		FoodDTO food = new FoodDTO();
		food.setFiName(fiName);
		if(fiPriceStr!=null) {
			food.setFiPrice(Integer.parseInt(fiPriceStr));
		}
		if(fiNumStr!=null) {
			food.setFiNum(Integer.parseInt(fiNumStr));
		}
		
		if("insert".equals(cmd)) {
			int result = foodService.insertFood(food);
			String msg = "실패하였습니다.";
			if(result==1) {
				msg = "성공하였습니다.";
			}
			String url = "/food/food-list";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request, response);
			//response.getWriter().append("insert logic").append(food.toString());
		}else if("delete".equals(cmd)) {
			int result = foodService.deleteFood(food.getFiNum());
			String msg = "실패하였습니다.";
			if(result==1) {
				msg = "성공하였습니다.";
			}
			String url = "/food/food-list";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request, response);
		}else if("update".equals(cmd)) {
			int result = foodService.updateFood(food);
			String msg = "실패하였습니다.";
			if(result==1) {
				msg = "성공하였습니다.";
			}
			String url = "/food/food-view?fiNum=" + food.getFiNum();
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
			rd.forward(request, response);
			
		}
		//doGet(request, response);
	}

}
