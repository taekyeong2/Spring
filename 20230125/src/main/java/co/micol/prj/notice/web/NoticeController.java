package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	//새터에 위한 주입방법
	@Autowired
	NoticeService noticeService;
	
	//실 경로를 가져오기 위해 사용함
	@Autowired
	ServletContext servletContext; 
	
	//메소드에 의한 의존주입
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//model 객체에 db결과 실어서 보냄
		model.addAttribute("notices", noticeService.noticeList());
		
		return "notice/noticeList";
	}
	
	/*
	//@ResponseBody => 호출한 페이지에 결과를 돌려줌
	//produces = "application/text; charset=UTF-8" => 한글깨짐
	@RequestMapping(value="/ajaxSearchList.do", produces = "application/json; charset=UTF-8")
	//@ResponseBody
	public @ResponseBody String ajaxSearchList(
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
	*/
	
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		
		return "notice/noticeSelect";
	}
	
	@GetMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		//파일 하나만 전송받음
		//여러개 받고 싶음 배열처리 함된다. (MultipartFile[] files)
		String saveFolder = servletContext.getRealPath("/resources/upload/"); //파일저장위치
		if(!file.isEmpty()) { //첨부파일 존재하면 
			String fileName = UUID.randomUUID().toString(); //UUID생성 
			fileName = fileName + file.getOriginalFilename(); //유니크한 아이디
			File uploadFile = new File(saveFolder, fileName);
			try {
				file.transferTo(uploadFile); //파일 저장하기			
			}catch(Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); //원본파일명
			vo.setNoticeFileDir(fileName); //디렉토리 포함 원본파일명
			
		}
		
		noticeService.noticeInsert(vo);

		return "redirect:noticeList.do";
	}
	
	@PostMapping("/noticeUpdateForm.do")
	public String noticeUpdateForm(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeUpdateForm";
	}
	
	@PostMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, Model model, MultipartFile file) {
		
		String saveFolder = servletContext.getRealPath("/resources/upload/"); //파일저장위치
		if(!file.isEmpty()) { //첨부파일 존재하면 
			String fileName = UUID.randomUUID().toString(); //UUID생성 
			fileName = fileName + file.getOriginalFilename(); //유니크한 아이디
			File uploadFile = new File(saveFolder, fileName);
			try {
				file.transferTo(uploadFile); //파일 저장하기			
			}catch(Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); //원본파일명
			vo.setNoticeFileDir(fileName); //디렉토리 포함 원본파일명
			
		}
		
		noticeService.noticeUpdate(vo);
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		
		return "notice/noticeSelect";
	}
	
	@PostMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		noticeService.noticeDelete(vo);
		noticeService.noticeIdUpdate(vo.getNoticeId());
		return "redirect:noticeList.do";
	}
}
