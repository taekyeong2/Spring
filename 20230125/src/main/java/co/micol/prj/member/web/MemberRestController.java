package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.member.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/ajaxList.do", produces = "application/json; charset=UTF-8")
	public String ajaxList() {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {			
			str = json.writeValueAsString(memberService.memberListSelect());
		}catch(Exception e) {
			e.printStackTrace();
		
	}
		return str; 
	}
}
