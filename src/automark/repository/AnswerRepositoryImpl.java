package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.model.Answer;
import automark.model.Teach;
import automark.repository.mapper.AnswerMapper;
import automark.repository.mapper.TeachMapper;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	@Override
	public List<Answer> findAnswersByQid(int qid) {
		String sql = "select * from answer where qid = ? ";
		List<Answer> list = jdbcTemplate.query(sql, new AnswerMapper() ,qid);
		return list;
	}
	@Override
	public int add(Answer answer) {
		String sql = "insert into answer values(null,?,?,?)";
		return jdbcTemplate.update(sql, answer.getQid(),answer.getInput(),answer.getOutput());
	}
	@Override
	public int delete(int aid) {
		String sql = "delete from answer where aid=? ";
		return jdbcTemplate.update(sql,aid);
	}
	@Override
	public int deleteAllByQid(int qid) {
		String sql = "delete from answer where qid=? ";
		return jdbcTemplate.update(sql,qid);
	}
	@Override
	public int update(Answer answer) {
		String sql="update answer set input=? ,output=? where aid=? ";
		return jdbcTemplate.update(sql,answer.getInput(),answer.getOutput(),answer.getAid());
	}
	@Override
	public List<Integer> fingAnswersIdSeqByQid(int qid) {
		String sql = "select aid from answer where qid = ? ";
		List<Integer> list = jdbcTemplate.queryForList(sql, Integer.class, qid);
		
		return list;
	}

}
