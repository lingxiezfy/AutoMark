package automark.dto;

import automark.model.Exam;
import automark.model.JudgeGrant;

public class AccessExamDto {
	private JudgeGrant judgeGrant;
	private Exam accessExam;
	public JudgeGrant getJudgeGrant() {
		return judgeGrant;
	}
	public void setJudgeGrant(JudgeGrant judgeGrant) {
		this.judgeGrant = judgeGrant;
	}
	public Exam getAccessExam() {
		return accessExam;
	}
	public void setAccessExam(Exam accessExam) {
		this.accessExam = accessExam;
	}
}
