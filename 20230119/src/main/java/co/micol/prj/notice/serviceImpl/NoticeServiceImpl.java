package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

//@Service =>나는 서비스 그룹이에요 하면서 컨테이너에 올라감 // @repository=> mybatis mapper가 그 역할 하니까 안써도됨
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper NoticeMapper;
	//@Autowired => mybatis및 dataSource가 자동주입해서 mapper를 인식시킨다.

	
	@Override
	public List<NoticeVO> noticeSelectList() {
		// TODO Auto-generated method stub
		return NoticeMapper.noticeSelectList();
	}

}
