package co.micol.prj.notice.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

//각 subject별로 controller를 가지고 있다.
//나는 컨트롤러이에요 하면서 컨테이너에 올라감
@Controller
public class NoticeController { //notice와 관련된 메서드들은 여기에다 적어줘야함
	@Autowired
	private NoticeService noticeService; //NoticeService noticeService = new NoticeServiceImpl()

	
	//컨트롤러(요청명) 수행될 ㅑ메서드
	@RequestMapping("/noticeList.do") 
	public String noticeList(Model model) { //Model인터페이스 : 전달할 값을 담는 객체
		
		//noticeService.noticeSelectList()=>실행명령/ 리턴타입대로 들어간다(list => list vo 타입
		model.addAttribute("list", noticeService.noticeSelectList()); 
		model.addAttribute("message", "이것은 리스트 테스트 입니다."); //message => String 타입
		
		return "notice/noticeList"; //model에 담긴값이 "notice/noticeList"에 전달
	}
	
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		//여기에 수행할 명령을 기술한다.
		//내가 보내는 변수 이름이 vo객체 변수 이름과 같으면 자동으로 맞춰서(타입까지) 넣어준다.
		model.addAttribute("vo", noticeService.noticeSelect(vo)); 
		
		return "notice/noticeSelectOne";
	}
}
