package dabin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.mapper.GramyUserVO_Mapper;
import kr.smhrd.model.GramyUserVO;


@Service
public class GramyUserService {

	@Autowired
	GramyUserVO_Mapper mapper;
	
    //회원가입
    public void GramyUserJoin(GramyUserVO vo){
        mapper.GramyUserJoin(vo);
    }

    //로그인
    public GramyUserVO GramyUserLogin(GramyUserVO vo){
         
    	GramyUserVO mvo = mapper.GramyUserLogin(vo);
    	
    	return mvo;
    }

}
