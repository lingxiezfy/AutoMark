package automark.dto;

import automark.model.Exam;

public class ExamDoDto {
	private int edid;
	private TeachDto teachDto;
	private Exam exam;
	private int nowstatus;
	public int getEdid() {
		return edid;
	}
	public void setEdid(int edid) {
		this.edid = edid;
	}
	
	public int getNowstatus() {
		return nowstatus;
	}
	public void setNowstatus(int nowstatus) {
		this.nowstatus = nowstatus;
	}
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public TeachDto getTeachDto() {
		return teachDto;
	}
	public void setTeachDto(TeachDto teachDto) {
		this.teachDto = teachDto;
	}
}
