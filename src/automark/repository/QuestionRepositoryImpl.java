package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import automark.dto.QuestionDto;
import automark.model.Answer;
import automark.model.Question;
import automark.repository.mapper.AnswerMapper;
import automark.repository.mapper.QuestionDtoMapper;
import automark.repository.mapper.QuestionMapper;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<QuestionDto> findPagedQuestionsByTeacherId(int uid, int currPage) {
		String sql = "select q.*,u.name,qt.qtname,jt.jtname from question q left join user u on q.uid=u.uid left join questiontype qt on q.qtid=qt.qtid left join judgetype jt on q.jtid=jt.jtid " + 
				"where q.uid= ? or q.readgrant=2 order by qid limit ? ,10";
		return jdbcTemplate.query(sql, new QuestionDtoMapper(),uid ,(currPage-1)*10);
	}
	@Override
	public int countQuestionsByTeacherId(int uid) {
		String sql = "select count(*) from question q left join user u on q.uid=u.uid left join questiontype qt on q.qtid=qt.qtid left join judgetype jt on q.jtid=jt.jtid " + 
				"where q.uid= ? or q.readgrant=2";
		return jdbcTemplate.queryForObject(sql, Integer.class,uid);
	}
	@Override
	public List<QuestionDto> findPagedQuestionsByKeys(int uid, int qtid, int readgrant, String key, int currPage) {
		String sql = "select q.*,u.name,qt.qtname,jt.jtname from question q left join user u on q.uid=u.uid left join questiontype qt on q.qtid=qt.qtid left join judgetype jt on q.jtid=jt.jtid " + 
				"where (q.uid= ? or q.readgrant=2) ";
		String andStr = "";
		if(qtid > 0) {
			andStr += "and qtid = "+qtid+" ";
		}
		if(readgrant > 0) {
			andStr += "and readgrant = "+readgrant+" ";
		}
		andStr += "and title like '%"+key+"%' ";
		sql += andStr;
		sql += "order by qid limit ? ,10";
		System.out.println("sql="+sql);
		return jdbcTemplate.query(sql, new QuestionDtoMapper(),uid,(currPage-1)*10);
	}
	@Override
	public int countQuestionsByKeys(int uid, int qtid, int readgrant, String key) {
		String sql = "select count(*) from question q left join user u on q.uid=u.uid left join questiontype qt on q.qtid=qt.qtid left join judgetype jt on q.jtid=jt.jtid " + 
				"where (q.uid= ? or q.readgrant=2) ";
		String andStr = "";
		if(qtid > 0) {
			andStr += "and qtid = "+qtid+" ";
		}
		if(readgrant > 0) {
			andStr += "and readgrant = "+readgrant+" ";
		}
		andStr += "and title like '%"+key+"%' ";
		sql += andStr;
		return jdbcTemplate.queryForObject(sql, Integer.class,uid);
	}
	@Override
	public int deleteById(int qid) {
		String sql = "delete from question where qid = ?";
		return jdbcTemplate.update(sql, qid);
	}
	@Override
	public int updateQuestionReadGrant(int qid, int readGrant) {
		String sql = "update question set readgrant=? where qid= ?";
		return jdbcTemplate.update(sql, readGrant,qid);
	}
	@Override
	public Question findQuestionById(int qid) {
		String sql = "select * from question where qid= ?";
		Question question ;
		try {
			question = jdbcTemplate.queryForObject(sql, new QuestionMapper(),qid);
		}catch (DataAccessException e) {
			question = null;
		}
		return question;
	}
	@Override
	public List<Answer> findAnswersByQuestionId(int qid) {
		String sql = "select * from answer where qid = ? order by aid";
		List<Answer> list = jdbcTemplate.query(sql, new AnswerMapper() ,qid);
		return list;
	}
	@Override
	public int addQuestion(Question question) {
		String sql = "insert into question values(null,?,?,?,?,?,?);";
		return jdbcTemplate.update(sql,question.getUid(),question.getQtid(),question.getJtid(),question.getReadGrant(),question.getTitle(),question.getDescription());
	}
	@Override
	public int updateQuestion(Question question) {
		String sql = "update question set uid = ?,qtid = ?,jtid = ?,readgrant = ?,title = ?,description = ? where qid = ?";
		return jdbcTemplate.update(sql,question.getUid(),question.getQtid(),question.getJtid(),question.getReadGrant(),question.getTitle(),question.getDescription(),question.getQid());
	}
	@Override
	public List<Question> findQuestionsAll(int uid) {
		String sql="select * from question q where q.uid= ? or q.readgrant=2 ";
		return jdbcTemplate.query(sql, new QuestionMapper(),uid);
	}
	@Override
	public List<Question> findQuestionByTitle(String title) {
		String sql="select * from question where title=? ";
		return jdbcTemplate.query(sql, new QuestionMapper(),title);
	}

}
