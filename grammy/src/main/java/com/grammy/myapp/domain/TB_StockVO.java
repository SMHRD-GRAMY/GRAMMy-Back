package com.grammy.myapp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TB_StockVO {
	private int stock_seq;
	private String hw_uid;
	private String stock_name;
	private String stock_date;
	private double stock_weight;
	private int shelf_seq;
	

}
