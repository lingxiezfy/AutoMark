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
		String sql = "select t.*,c.name from teach t,classes c where "+
				"t.cid = c.cid and t.uid = ?";
		List<Answer> list = null;
		try {
			list = jdbcTemplate.query(sql, new AnswerMapper(), qid);
		}catch (Exception e) {
			list = null;
		}
		return list;
	}

}
