package com.grammy.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.grammy.myapp.domain.TB_UserVO;
import com.grammy.myapp.mapper.TB_UserMapper;

@Service
public class TB_UserServiceImpl implements TB_UserService{

	@Autowired
	TB_UserMapper mapper;
	
	@Override
	public List<TB_UserVO> selectList() {
		
		return mapper.selectAllList();
	}

	//회원가입
	@Override
	public void userJoin(TB_UserVO user) throws Exception {
		mapper.userJoin(user);
		
	}

	@Override
	public int idCheck(String userId) throws Exception {
		
		return mapper.idCheck(userId);
	}

}