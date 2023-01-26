package co.micol.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeHitUpdate(int id);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeIdUpdate(int id);
	
	List<NoticeVO> noticeSearch(@Param("key") String Key, @Param("val") String val);
}
