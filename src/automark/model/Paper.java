package automark.model;

public class Paper {
	private int pid;
	private int uid;
	private User paperTeacher;
	private int readGrant;
	private String title;
	private int totalscore;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getReadGrant() {
		return readGrant;
	}
	public void setReadGrant(int readGrant) {
		this.readGrant = readGrant;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}
	public User getPaperTeacher() {
		return paperTeacher;
	}
	public void setPaperTeacher(User paperTeacher) {
		this.paperTeacher = paperTeacher;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
}
