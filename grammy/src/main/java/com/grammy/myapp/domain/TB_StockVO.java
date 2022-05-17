package com.grammy.myapp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TB_StockVO {
	private int stock_seq;
	private String stock_name;
	private Integer stock_weight;
	private String stock_date;
	private String stock_shelfLife;
	private int shelf_seq;
	private String stock_order;
	

}
