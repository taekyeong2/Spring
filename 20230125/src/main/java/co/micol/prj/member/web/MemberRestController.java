package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;
import co.micol.prj.notice.vo.NoticeVO;

@RestController
public class MemberRestController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/ajaxIdCheck.do", produces = "application/json; charset=UTF-8")
	public String ajaxIdCheck(MemberVO vo) {
		String id = vo.getMemberId();
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {			
			str = json.writeValueAsString(memberService.isIdCheck(id));
		}catch(Exception e) {
			e.printStackTrace();
		
	}
		return str; 
	}
}
