package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
