package dabin;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import kr.smhrd.model.GramyUserVO;
//import kr.smhrd.service.GramyUserService;
//
//@RestController
//public class GramyController {
//
//	@Autowired
//	GramyUserService service;
//	
//	@RequestMapping(value="/Join", method=RequestMethod.POST)
//	public String Join(GramyUserVO vo) {
//		System.out.println("입력받은 회원정보");
//		System.out.println(vo);
//		System.out.println("입력받은 회원정보");
//		
//		service.GramyUserJoin(vo);
//		
//		return "success";
//	}
//	
//	@RequestMapping(value="/Login", method=RequestMethod.POST)
//	public GramyUserVO GramyUserLogin(GramyUserVO vo) {
//		
//		GramyUserVO mvo = service.GramyUserLogin(vo);
//		
//		System.out.println(vo.getUser_id());
//		
//		return mvo;
//	}
//}
