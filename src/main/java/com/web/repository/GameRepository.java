package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.CommonFactory;
import com.web.dto.GameDTO;

public class GameRepository {

	public List<GameDTO> selectGames(){
		//SqlSessioFactory ssf = CommonFactory.getSSF();
		try(SqlSession session = CommonFactory.getSSF().openSession()){
			return session.selectList("GameMapper.selectGames");
		}		
	}
	
	public GameDTO selectGame(int giNum) {
		try(SqlSession session = CommonFactory.getSSF().openSession()){
			return session.selectOne("GameMapper.selectGame",giNum);
		}
	}
	
	public int insertGame(GameDTO game) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.insert("GameMapper.insertGame",game);
		}
	}
	
	public int updateGame(GameDTO game) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.update("GameMapper.updateGame",game);
		}
	}
	
	public int deleteGame(int giNum) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.delete("GameMapper.updateGame",giNum);
		}
	}
	
	public static void main(String[] args) {
		GameRepository gameRepo = new GameRepository();
		GameDTO game = new GameDTO();
		GameDTO game1 = gameRepo.selectGame(19);
		System.out.println(game1);
		game.setGiName("마크");
		game.setGiPrice(43000);
		game.setGiGenre("서바이벌");
		game.setGiDesc("네모네모");
		game.setGiNum(9);
		int result = 0;
		result = gameRepo.insertGame(game);
		System.out.println("입력갯수 : "+result);
		result = gameRepo.updateGame(game);
		System.out.println("수정갯수 : "+result);
		game.setGiNum(10);
		result = gameRepo.deleteGame(game.getGiNum());
		System.out.println("삭제갯수 : "+result);
		List<GameDTO> games = gameRepo.selectGames();
		System.out.println(games);
	}
}
