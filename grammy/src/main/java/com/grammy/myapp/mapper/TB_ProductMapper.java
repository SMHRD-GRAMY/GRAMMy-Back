package com.grammy.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_ShelfStockVO;
import com.grammy.myapp.domain.TB_ShelfVO;
import com.grammy.myapp.domain.TB_StockVO;
import com.grammy.myapp.domain.TB_Stock_WeightVO;

@MapperScan
public interface TB_ProductMapper {
	
	//초기 선반에 물품 이름 가져오기 리스트
	public List<TB_ShelfStockVO> stockList(TB_ShelfStockVO vo);
	
	//선반 클릭시 리턴으로 가져오기
	public List<TB_ShelfStockVO> returnStockList(TB_ShelfStockVO vo);
	
	//선반(창고) 등록하기
	public int insertShelf(TB_ShelfVO vo);
	//선반(창고) 리스트 가져오기
	public List<TB_ShelfVO> shelfList(TB_ShelfVO vo);

	//물품(stock) 등록하기
	public int insertStock(TB_StockVO vo);
	//물품 무게 insert문으로 넣기
	public int insertWeight(TB_Stock_WeightVO vo);


}
