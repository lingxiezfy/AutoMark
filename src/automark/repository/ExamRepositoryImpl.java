package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.dto.AccessExamDto;
import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.Exam;
import automark.model.ExamDo;
import automark.model.ExamDoDetail;
import automark.model.JudgeGrant;
import automark.repository.mapper.AccessExamMapper;
import automark.repository.mapper.ExamDetailMapper;
import automark.repository.mapper.ExamInfoMapper;

@Repository
public class ExamRepositoryImpl implements ExamRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ExamInfoDto> findExamInfoByStudentId(int uid) {
		String sql = "select ed.*,e.pid,e.uid teacherid,e.type,e.starttime,e.endtime,e.title examtitle ,teacher.name teachername from  (select * from examdo where uid = ?)  ed  left join exam e on ed.eid = e.eid left join user teacher on e.uid = teacher.uid";
		List<ExamInfoDto> list = null;
		list = jdbcTemplate.query(sql, new ExamInfoMapper(),uid);
		//System.out.println(list.size());
		return list;
	}

	@Override
	public List<Integer> findExamDetailIdList(int edid) {
		String sql = "select edtid from examdodetail where edid = ? order by edtid";
		List<Integer> list = null;
		list = jdbcTemplate.queryForList(sql, Integer.class,edid);
		return list;
	}

	@Override
	public ExamDetailDto findExamDoDetailByIndex(int edid, int index) {
		String sql="select edt.*,q.*,score from examdodetail edt left join makepaper mp on edt.mpid = mp.mpid"
				+" left join question q on mp.qid=q.qid where edt.edid = ? order by edtid limit ?,1";
		
		ExamDetailDto examDetailDto =null;
		try {
			examDetailDto = jdbcTemplate.queryForObject(sql, new ExamDetailMapper(),edid,index-1); 
			System.out.println(examDetailDto.getQuestion().getTitle());
		}catch (DataAccessException e) {
			examDetailDto = null;
		}
		
		return examDetailDto;
	}

	@Override
	public int saveAnswer(int edtid, String stuanswer, int answertype, int autograde, String autoresult) {
		/*
		update examdodetail set stuanswer = '哈哈哈' ,answertype = 1 ,autograde = 30 ,autoresult = '哈哈哈' where edtid = 1; 
		 */
		String sql = "update examdodetail set stuanswer = ? ,answertype = ? ,autograde = ? ,autoresult = ? "+
					"where edtid = ?";
		//Object args = new Object[] {stuanswer,answertype,autograde,autoresult,edtid};
		return jdbcTemplate.update(sql,stuanswer,answertype,autograde,autoresult,edtid);
	}

	@Override
	public void setNowStatus(int edid, int index) {
		String sql = "update examdo set nowstatus = ? where edid = ?";
		jdbcTemplate.update(sql, index,edid);
	}

	@Override
	public List<AccessExamDto> findAccessExamsByTeacherId(int uid) {
		String sql="select jg.jgid,jg.uid jguid,e.* from ( select * from judgegrant where uid = ? ) jg left join exam e on jg.eid = e.eid";
		return jdbcTemplate.query(sql, new AccessExamMapper(),uid);
	}

	@Override
	public int deleteExamById(int eid) {
		String sql ="delete from exam where eid = ? ";
		return jdbcTemplate.update(sql, eid);
	}

	@Override
	public int findMaxEid() {
		String sql = "select max(eid) from exam";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int addExam(Exam exam) {
		String sql="insert into exam values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,exam.getEid(),exam.getPid(),exam.getUid(),exam.getType(),exam.getStartTime(),exam.getEndTime(),exam.getTitle());
	}

	@Override
	public int findMaxEdid() {
		String sql = "select max(edid) from examdo";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int addExamDo(ExamDo examDo) {
		String sql="insert into examDo values (?,?,?,?,?)";
		return jdbcTemplate.update(sql,examDo.getEdid(),examDo.getUid(),examDo.getEid(),examDo.getNowstatus(),examDo.getTotalgrade());
	}

	@Override
	public int addExamDoDetail(ExamDoDetail examDoDetail) {
		String sql=  "insert into examdodetail values(null,?,?,?,?,?,?,?,?)";
		
		return jdbcTemplate.update(sql,examDoDetail.getMpid(),examDoDetail.getEdid(),examDoDetail.getStuAnswer(),examDoDetail.getAnswerType(),examDoDetail.getAnswerTime(),examDoDetail.getAutoGrade(),examDoDetail.getAutoResult(),examDoDetail.getTeacherVerify());
	}

	@Override
	public int addJudgeGrant(JudgeGrant judgeGrant) {
		String sql = "insert into judgegrant values(null,?,?)";
		return jdbcTemplate.update(sql,judgeGrant.getUid(),judgeGrant.getEid());
	}
	
}
