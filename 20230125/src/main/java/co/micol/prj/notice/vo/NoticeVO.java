package co.micol.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	//json객체시 날짜 포멧설정
	@JsonFormat(pattern="yyyy/MM/dd", timezone = "Asia/Seoul")
	private Date noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
	private String noticeFile;
	private String noticeFileDir;
}
