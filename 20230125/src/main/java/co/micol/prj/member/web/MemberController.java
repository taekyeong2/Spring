package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/memberListSelect.do")
	public String memberListSelect(Model model) {
		
		model.addAttribute("list", memberService.memberListSelect());
		return "member/memberListSelect";
	}
	
	@PostMapping("/memberLogin.do") //memberLogin.do => 이미 처리된 값
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {
		//db저장된 한글값 불러올때 깨진다. => filter를 넣어줘야한다.
		System.out.println(vo.getMemberId());
		vo=memberService.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());
			model.addAttribute("message", vo.getMemberName()+"님 환영합니다.");
		}else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		
		return "member/memberMessage"; //로그인 결과 보여주면 된다.
	}
	
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		model.addAttribute("message", session.getAttribute("name")+"님 정상로그아웃 되었습니다.");
		session.invalidate();
		return "member/memberMessage";
	}
	
	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		
		return "member/memberJoinForm";
	}
	
	@PostMapping("/memberJoin.do")
	public String memberJoin(MemberVO vo, Model model) {
		memberService.memberInsert(vo);
		model.addAttribute("message", vo.getMemberName()+"님 회원가입 성공");
		//바로 뷰리졸버로 안가고 다시 컨트롤러로 간다.
		return "member/memberMessage";
	}
}
