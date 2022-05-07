package com.grammy.myapp.mapper;


import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_UserVO;




@MapperScan
public interface TB_UserMapper {
	//회원가입
	public void userJoin(TB_UserVO user);

	// 회원리스트 불러오기
	public List<TB_UserVO> selectAllList();

	//아이디 중복검사
	public int idCheck(String userId);
}
