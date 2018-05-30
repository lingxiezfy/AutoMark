package automark.dto;


import automark.model.ExamDoDetail;
import automark.model.Question;

public class ExamDetailDto {
	private ExamDoDetail examDoDetail;
	private Question question;
	private int score;
	public ExamDoDetail getExamDoDetail() {
		return examDoDetail;
	}
	public void setExamDoDetail(ExamDoDetail examDoDetail) {
		this.examDoDetail = examDoDetail;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
