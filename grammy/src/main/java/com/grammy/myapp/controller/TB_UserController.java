package com.grammy.myapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.grammy.myapp.config.auth.Auth;
import com.grammy.myapp.config.auth.CustomUserDetailService;
import com.grammy.myapp.config.jwt.JwtTokenProvider;
import com.grammy.myapp.domain.TB_UserVO;
import com.grammy.myapp.domain.User;
import com.grammy.myapp.repository.UserRepository;
import com.grammy.myapp.service.TB_UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="*")
public class TB_UserController {
	

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    

	Gson gson=new Gson();

	@Autowired
	CustomUserDetailService customuser;

	@Autowired
	TB_UserService service;
	
	
	
	@GetMapping("/user.do")
	public List<TB_UserVO> selectList() throws Exception{
		List<TB_UserVO> allUser=service.selectList();
		return allUser;
	}

	@RequestMapping(value="/join.do",method = RequestMethod.POST)
	public String joinPOST(@RequestBody TB_UserVO user){
		System.out.println(user);
		try {		

//			String jsonStr=gson.toJson(param);
//			TB_UserVO user=gson.fromJson(jsonStr,TB_UserVO.class);
			
			String rawPassword=user.getUser_pw();
			String encPassword=passwordEncoder.encode(rawPassword);
			user.setUser_pw(encPassword);
//			user.setUser_joindate(format1.format(time));
//			user.setAdmin_yn('N');
			System.out.println(user);
//			repository.save(user); //회원가입 
			service.userJoin(user);
			return "success";		
			}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
			
		}

	}

	@RequestMapping(value="/userIdCk", method=RequestMethod.GET)
	public String userIdCk(String userId) throws Exception{
		
		int result = service.idCheck(userId);

		if (result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
    // 로그인
    @PostMapping("/login.do")
    public String login(@RequestBody Map<String, String> param) throws Exception{
    	System.out.println(param);
    	String jsonStr=gson.toJson(param);
    	System.out.println(jsonStr);
    	User user=gson.fromJson(jsonStr,User.class);
    	System.out.println(user);
        User member = userRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        
        String token=jwtTokenProvider.createToken(member.getUsername(), member.getUserRoleList());
        String user_name=member.getUser_Name();
        String user_id=member.getUserId();
        Auth auth=new Auth(token,user_id,user_name);
        String result = gson.toJson(auth);
        
        return result;
    }
    
    //아이디로 회원정보가져오기
    @RequestMapping(value="/selectOne.do",method = RequestMethod.POST)
    public String selectOnelist(@RequestBody String user_id) throws Exception{
    	TB_UserVO vo=service.selectOneList(user_id);
    	if(vo!=null) {
    	return "success";
    	}else {
    		return "fail";
    	}
    			
    	
    }
    
    

}
