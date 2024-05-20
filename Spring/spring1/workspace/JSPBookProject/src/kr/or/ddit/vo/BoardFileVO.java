package kr.or.ddit.vo;

public class BoardFileVO {
	private int no = 0;				// 파일 번호
	private String contentType;		// 파일 미디어타입
	private long fileSize;			// 파일 크기
	private String fileName;		// 파일 명
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
