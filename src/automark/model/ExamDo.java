package automark.model;

public class ExamDo {
	private int edid;
	private int uid;
	private int eid;
	private Exam exam;
	private int nowstatus;
	private int totalgrade;
	public int getEdid() {
		return edid;
	}
	public void setEdid(int edid) {
		this.edid = edid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNowstatus() {
		return nowstatus;
	}
	public void setNowstatus(int nowstatus) {
		this.nowstatus = nowstatus;
	}
	public int getTotalgrade() {
		return totalgrade;
	}
	public void setTotalgrade(int totalgrade) {
		this.totalgrade = totalgrade;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
}
