package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.DBCon;
import com.web.dto.UserDTO;

public class UserDAO {//Data Access Object
	//서블릿-서비스-DAO(레포지토리)
	
	public List<UserDTO> getUsers() {
		List<UserDTO> users = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,"
				+" UI_AGE, UI_PHONE, UI_ADDRESS, UI_TRANS "
				+" FROM USER_INFO";
		try(Connection con = DBCon.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setUiNum(rs.getInt("UI_NUM"));
				user.setUiName(rs.getString("UI_NAME"));
				user.setUiAge(rs.getInt("UI_AGE"));
				user.setUiId(rs.getString("UI_ID"));
				user.setUiPwd(rs.getString("UI_PWD"));
				user.setUiPhone(rs.getString("UI_PHONE"));
				user.setUiAddress(rs.getString("UI_ADDRESS"));
				user.setUiTrans(rs.getString("UI_TRANS"));
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public UserDTO getUser(int uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,"
				+" UI_AGE, UI_PHONE, UI_ADDRESS, UI_TRANS "
				+" FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, uiNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserDTO user = new UserDTO();
				user.setUiNum(rs.getInt("UI_NUM"));
				user.setUiName(rs.getString("UI_NAME"));
				user.setUiAge(rs.getInt("UI_AGE"));
				user.setUiId(rs.getString("UI_ID"));
				user.setUiPwd(rs.getString("UI_PWD"));
				user.setUiPhone(rs.getString("UI_PHONE"));
				user.setUiAddress(rs.getString("UI_ADDRESS"));
				user.setUiTrans(rs.getString("UI_TRANS"));
				return user;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertUser(UserDTO user) {
		String sql = "insert into USER_INFO(UI_NAME, UI_AGE, UI_ID,\r\n"
				+ "UI_PWD, UI_PHONE, UI_ADDRESS, UI_TRANS)\r\n"
				+ "VALUES(?,?,?,?\r\n"
				+ ",?,?,?)";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, user.getUiName());
			ps.setInt(2, user.getUiAge());
			ps.setString(3, user.getUiId());
			ps.setString(4, user.getUiPwd());
			ps.setString(5, user.getUiPhone());
			ps.setString(6, user.getUiAddress());
			ps.setString(7, user.getUiTrans());
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteUser(int uiNum) {
		String sql = "delete from USER_INFO\r\n"
				+ "where UI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, uiNum);

			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUser(UserDTO user) {
		String sql="update USER_INFO\r\n"
				+ "set UI_NAME=?,UI_AGE=?,UI_PWD=?,\r\n"
				+ "UI_PHONE=?,UI_ADDRESS=?,UI_TRANS=? where UI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, user.getUiName());
			ps.setInt(2, user.getUiAge());
			ps.setString(3, user.getUiPwd());
			ps.setString(4, user.getUiPhone());
			ps.setString(5, user.getUiAddress());
			ps.setString(6, user.getUiTrans());
			ps.setInt(7,user.getUiNum());
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		UserDTO user = new UserDTO();
		user.setUiName("김문수");
		user.setUiAge(28);
		user.setUiPwd("0000");
		user.setUiPhone("0105555555");
		user.setUiAddress("울릉도");
		user.setUiTrans("1");
		user.setUiNum(5);
		int result = userDAO.updateUser(user);
		System.out.print("업데이트 갯수"+result);
		result = userDAO.deleteUser(9);
		System.out.print("지운 갯수"+result);
	}
}
