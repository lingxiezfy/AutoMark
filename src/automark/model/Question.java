package automark.model;

public class Question {
	private int qid;
	private int uid;
	private int qtid;
	private int jtid;
	private int readGrant;
	private String title;
	private String description;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQtid() {
		return qtid;
	}
	public void setQtid(int qtid) {
		this.qtid = qtid;
	}
	public int getJtid() {
		return jtid;
	}
	public void setJtid(int jtid) {
		this.jtid = jtid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
