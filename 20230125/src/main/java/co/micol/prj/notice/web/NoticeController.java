package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	//새터에 위한 주입방법
	@Autowired
	NoticeService noticeService;
	
	//메소드에 의한 의존주입
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//model 객체에 db결과 실어서 보냄
		model.addAttribute("notices", noticeService.noticeList());
		
		return "notice/noticeList";
	}
	
//	//@ResponseBody => 호출한 페이지에 결과를 돌려줌
//	//produces = "application/text; charset=UTF-8" => 한글깨짐
//	@RequestMapping(value="/ajaxSearchList.do", produces = "application/json; charset=UTF-8")
//	//@ResponseBody
//	public @ResponseBody String ajaxSearchList(
//			@RequestParam("key") String key, 
//			@RequestParam("val") String val) {
//		String str = null;
//		ObjectMapper json = new ObjectMapper();
//		try {			
//			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
//		}catch(Exception e) {
//			e.printStackTrace();
//		
//	}
//		return str; 
//	}
}
