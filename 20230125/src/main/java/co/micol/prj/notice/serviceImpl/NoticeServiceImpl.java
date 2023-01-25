package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper noitceMapper;

	@Override
	public List<NoticeVO> noticeList() {
		return noitceMapper.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return noitceMapper.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return noitceMapper.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return noitceMapper.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return noitceMapper.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearch(String Key, String val) {
		return noitceMapper.noticeSearch(Key, val);
	}

}
