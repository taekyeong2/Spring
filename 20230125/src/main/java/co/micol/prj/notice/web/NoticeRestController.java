package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

//@Controller + @ResponseBody => 호출한 페이지로 결과를 리턴(api만들거나 ajax로 결과를 받아오려 할때 사용)
@RestController
public class NoticeRestController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value="/ajaxSearchList.do", produces = "application/json; charset=UTF-8")
	public String ajaxSearchList(
			@RequestParam("key") String key, 
			@RequestParam("val") String val) {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {			
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		}catch(Exception e) {
			e.printStackTrace();
		
	}
		return str; 
	}
	
}
