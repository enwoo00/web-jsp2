package com.web.dto;

public class FoodDTO {

	private int fiNum;
	private String fiName;
	private int fiPrice;
	public int getFiNum() {
		return fiNum;
	}
	public void setFiNum(int fiNum) {
		this.fiNum = fiNum;
	}
	public String getFiName() {
		return fiName;
	}
	public void setFiName(String fiName) {
		this.fiName = fiName;
	}
	public int getFiPrice() {
		return fiPrice;
	}
	public void setFiPrice(int fiPrice) {
		this.fiPrice = fiPrice;
	}
	@Override
	public String toString() {
		return "FoodDTO [fiNum=" + fiNum + ", fiName=" + fiName + ", fiPrice=" + fiPrice + "]";
	}
}
