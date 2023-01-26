package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeHitUpdate(int id);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	//번호 업데이트(삭제시 같이)
	int noticeIdUpdate(int id);
	
	List<NoticeVO> noticeSearch(String Key, String val);
}
