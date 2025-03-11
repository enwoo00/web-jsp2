package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.DBCon;
import com.web.dto.TestDTO;

public class TestDAO {


	public List<TestDTO> selectTests (TestDTO test){
		List<TestDTO> tests = new ArrayList<>();
		String sql = "select TI_NUM, TI_NAME from TEST_INFO";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				TestDTO test1 = new TestDTO();
				test1.setTiNum(rs.getInt("TI_NUM"));
				test1.setTiName(rs.getString("TI_NAME"));
				tests.add(test1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tests;
	}
	
	public TestDTO selectTest (int tiNum) {
		String sql = "select TI_NUM, TI_NAME from TEST_INFO WHERE TI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, tiNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				TestDTO test1 = new TestDTO();
				test1.setTiNum(rs.getInt("TI_NUM"));
				test1.setTiName(rs.getString("TI_NAME"));
				return test1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	
	public int insertTest (TestDTO test) {
		String sql = "insert into TEST_INFO(TI_NAME)\r\n"
				+ "VALUES(?)";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps =con.prepareStatement(sql)){
			ps.setString(1, test.getTiName());
			return ps.executeUpdate(); 
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}
	
	public int updateTest(TestDTO test) {
		String sql = "update TEST_INFO set TI_NAME=? where TI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, test.getTiName());
			ps.setInt(2, test.getTiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}
	
	public int deleteTest(int tiNum) {
		String sql = "delete from TEST_INFO where TI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, tiNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
