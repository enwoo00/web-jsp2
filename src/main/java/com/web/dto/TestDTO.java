package com.web.dto;

public class TestDTO {
	
	private int tiNum;
	private String tiName;
	public int getTiNum() {
		return tiNum;
	}
	public void setTiNum(int tiNum) {
		this.tiNum = tiNum;
	}
	public String getTiName() {
		return tiName;
	}
	public void setTiName(String tiName) {
		this.tiName = tiName;
	}
	@Override
	public String toString() {
		return "TestDTO [tiNum=" + tiNum + ", tiName=" + tiName + "]";
	}
	
	

}
