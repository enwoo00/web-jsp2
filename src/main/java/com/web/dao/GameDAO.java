package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.common.DBCon;
import com.web.dto.GameDTO;

public class GameDAO {

	
	public List<GameDTO> selectGames(GameDTO game){
		List<GameDTO> games = new ArrayList();
		String sql = "select GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC from GAME_INFO";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				GameDTO game1 = new GameDTO();
				game1.setGiNum(rs.getInt("GI_NUM"));
				game1.setGiName(rs.getString("GI_NAME"));
				game1.setGiPrice(rs.getInt("GI_PRICE"));
				game1.setGiGenre(rs.getString("GI_GENRE"));
				game1.setGiDesc(rs.getString("GI_DESC"));
				games.add(game1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return games;
	}
	
	public GameDTO selectGame(int giNum) {
		String sql = "select GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC from GAME_INFO where GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, giNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				GameDTO game1 = new GameDTO();
				game1.setGiNum(rs.getInt("GI_NUM"));
				game1.setGiName(rs.getString("GI_NAME"));
				game1.setGiPrice(rs.getInt("GI_PRICE"));
				game1.setGiGenre(rs.getString("GI_GENRE"));
				game1.setGiDesc(rs.getString("GI_DESC"));
				return game1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertGame(GameDTO game) {
		String sql = "insert into GAME_INFO(GI_NAME, GI_PRICE, GI_GENRE, GI_DESC)\r\n"
				+ "VALUES(?,?,?,?)";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, game.getGiName());
			ps.setInt(2, game.getGiPrice());
			ps.setString(3, game.getGiGenre());
			ps.setString(4, game.getGiDesc());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateGame(GameDTO game) {
		String sql = "update GAME_INFO\r\n"
				+ "set GI_NAME=?,\r\n"
				+ "GI_PRICE=?,\r\n"
				+ "GI_GENRE=?, \r\n"
				+ "GI_DESC=?\r\n"
				+ "where GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, game.getGiName());
			ps.setInt(2, game.getGiPrice());
			ps.setString(3, game.getGiGenre());
			ps.setString(4, game.getGiDesc());
			ps.setInt(5, game.getGiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int deleteGame(int giNum) {
		String sql = "delete from GAME_INFO where GI_NUM=?";
		try(Connection con = DBCon.getCon();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, giNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main (String [] args) {
		GameDAO gameDAO = new GameDAO();
		//GameDTO game1 = gameDAO.selectGame(4);
		//System.out.print(game1);
		GameDTO game = new GameDTO();
		int result = 0;
		game.setGiName("피크민");
		game.setGiPrice(3000);
		game.setGiGenre("육성");
		game.setGiDesc("웅씌");
		game.setGiNum(4);
		result = gameDAO.insertGame(game);
		System.out.println("추가 갯수 : "+result);
		result = gameDAO.updateGame(game);
		System.out.println("수정 갯수 : "+result);
		game.setGiNum(8);
		result = gameDAO.deleteGame(game.getGiNum());
		System.out.println("삭제 갯수 : "+result);
		List<GameDTO> list = gameDAO.selectGames(null);
		System.out.println(list);
	}
}
