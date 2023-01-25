package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

//@Controller + @ResponseBody 
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
