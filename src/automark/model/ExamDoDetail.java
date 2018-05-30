package automark.model;

import java.util.Date;

public class ExamDoDetail {
	private int edtid;
	private int mpid;
	private int edid;
	private String stuAnswer;
	private int answerType;
	private Date answerTime;
	private int autoGrade;
	private String autoResult;
	private int teacherVerify;
	public int getEdtid() {
		return edtid;
	}
	public void setEdtid(int edtid) {
		this.edtid = edtid;
	}
	public int getMpid() {
		return mpid;
	}
	public void setMpid(int mpid) {
		this.mpid = mpid;
	}
	public int getEdid() {
		return edid;
	}
	public void setEdid(int edid) {
		this.edid = edid;
	}
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}
	public int getAnswerType() {
		return answerType;
	}
	public void setAnswerType(int answerType) {
		this.answerType = answerType;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public String getAutoResult() {
		return autoResult;
	}
	public void setAutoResult(String autoResult) {
		this.autoResult = autoResult;
	}
	public int getAutoGrade() {
		return autoGrade;
	}
	public void setAutoGrade(int autoGrade) {
		this.autoGrade = autoGrade;
	}
	public int getTeacherVerify() {
		return teacherVerify;
	}
	public void setTeacherVerify(int teacherVerify) {
		this.teacherVerify = teacherVerify;
	}
}
