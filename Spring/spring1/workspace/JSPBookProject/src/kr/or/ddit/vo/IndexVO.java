package kr.or.ddit.vo;

import java.util.List;

public class IndexVO {
	
	private String chapter;
	private String title;
	private String chapterMoveUrl;
	private List<String> sourceList;
	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChapterMoveUrl() {
		return chapterMoveUrl;
	}
	public void setChapterMoveUrl(String chapterMoveUrl) {
		this.chapterMoveUrl = chapterMoveUrl;
	}
	public List<String> getSourceList() {
		return sourceList;
	}
	public void setSourceList(List<String> sourceList) {
		this.sourceList = sourceList;
	}
	
}
