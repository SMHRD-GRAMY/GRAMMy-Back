package com.grammy.myapp.service;

import java.util.List;

import com.grammy.myapp.domain.TB_UserVO;




public interface TB_UserService {
	
	public List<TB_UserVO> selectList() throws Exception;
	
	public void userJoin(TB_UserVO user) throws Exception;
	
	public int idCheck(String userId) throws Exception;
	
	public TB_UserVO selectOneList(TB_UserVO vo) throws Exception;
	
	public TB_UserVO updateUser(TB_UserVO vo) throws Exception;

}
