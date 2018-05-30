package automark.model;

import java.util.Date;

public class Exam {
	private int eid;
	private int pid;
	private User examTeacher;
	private int type;
	private String title;
	private Date startTime;
	private Date endTime;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public User getExamTeacher() {
		return examTeacher;
	}
	public void setExamTeacher(User examTeacher) {
		this.examTeacher = examTeacher;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}
