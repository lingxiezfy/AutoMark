package automark.dto;

import automark.model.ExamDo;
import automark.model.Teach;

public class ExamInfoDto {
	private Teach teach;
	private ExamDo examDo;
	public Teach getTeach() {
		return teach;
	}
	public void setTeach(Teach teach) {
		this.teach = teach;
	}
	public ExamDo getExamDo() {
		return examDo;
	}
	public void setExamDo(ExamDo examDo) {
		this.examDo = examDo;
	}
}
