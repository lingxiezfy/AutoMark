package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
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
		String sql = "select edtid from examdodetail where edid = ?";
		List<Integer> list = null;
		list = jdbcTemplate.queryForList(sql, Integer.class,edid);
		return list;
	}

	@Override
	public ExamDetailDto findExamDoDetailByIndex(int edid, int index) {
		String sql="select edt.*,q.*,score from examdodetail edt left join makepaper mp on edt.mpid = mp.mpid"
				+" left join question q on mp.qid=q.qid where edt.edid = ? limit ?,1";
		
		ExamDetailDto examDetailDto =null;
		try {
			examDetailDto = jdbcTemplate.queryForObject(sql, new ExamDetailMapper(),edid,index-1); 
			System.out.println(examDetailDto.getQuestion().getTitle());
		}catch (DataAccessException e) {
			examDetailDto = null;
		}
		
		return examDetailDto;
	}
	
}
