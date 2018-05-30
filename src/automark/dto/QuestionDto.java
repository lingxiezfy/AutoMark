package automark.dto;

import java.util.List;

import automark.model.Answer;
import automark.model.JudgeType;
import automark.model.QuestionType;
import automark.model.User;

public class QuestionDto {
	private int qid;
	private User user;
	private QuestionType qType;
	private JudgeType jType;
	private List<Answer> answers;
	private int readGrant;
	private String title;
	private String description;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public QuestionType getqType() {
		return qType;
	}
	public void setqType(QuestionType qType) {
		this.qType = qType;
	}
	public JudgeType getjType() {
		return jType;
	}
	public void setjType(JudgeType jType) {
		this.jType = jType;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
