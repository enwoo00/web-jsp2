package com.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class GameDTO {
	private int giNum;
	private String giName;
	private int giPrice;
	private String giGenre;
	private String giDesc;
}


