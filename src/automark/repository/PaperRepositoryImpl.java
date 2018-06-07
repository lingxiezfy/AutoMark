package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.model.MakePaper;
import automark.model.Paper;
import automark.model.Question;
import automark.repository.mapper.MakePaperMapper;
import automark.repository.mapper.PaperMapper;
@Repository
public class PaperRepositoryImpl implements PaperRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Paper> findPagedPapersByTeacherId(int uid, int currPage) {
		String sql = "select p.*,u.name from paper p left join user u on p.uid=u.uid " + 
				"where p.uid= ? or p.readgrant=2 order by pid limit ? ,10";
		return jdbcTemplate.query(sql, new PaperMapper(),uid ,(currPage-1)*10);
	}
	@Override
	public int countPapersByTeacherId(int uid) {
		String sql = "select count(*) from paper p left join user u on p.uid=u.uid "+ 
				"where p.uid= ? or p.readgrant=2";
		return jdbcTemplate.queryForObject(sql, Integer.class,uid);
	}
	@Override
	public List<Paper> findPagedPapersByKeys(int uid, String key, int currPage) {
		String sql = "select p.*,u.name from paper p left join user u on p.uid=u.uid " + 
				"where (p.uid= ? or p.readgrant=2) ";
		String andStr = "";
		andStr += "and title like '%"+key+"%' ";
		sql += andStr;
		sql += "order by pid limit ? ,10";
		System.out.println("sql="+sql);
		return jdbcTemplate.query(sql, new PaperMapper(),uid,(currPage-1)*10);
	}
	@Override
	public int countPapersByKeys(int uid, String key) {
		String sql = "select count(*) from paper p left join user u on p.uid=u.uid " + 
				"where (p.uid= ? or p.readgrant=2) ";
		String andStr = "";
		andStr += "and title like '%"+key+"%' ";
		sql += andStr;
		System.out.println("sql="+sql);
		return jdbcTemplate.queryForObject(sql, Integer.class,uid);
	}
	@Override
	public int deleteById(int pid) {
		String sql = "delete from paper where pid = ?";
		return jdbcTemplate.update(sql, pid);
	}
	@Override
	public int updatePaperReadGrant(int pid, int readGrant) {
		String sql = "update paper set readgrant=? where pid= ?";
		return jdbcTemplate.update(sql, readGrant,pid);
	}
	@Override
	public int addPaper(Paper paper) {
		String sql="insert into paper values(null,?,?,?,?)";
		return jdbcTemplate.update(sql,paper.getUid(),paper.getReadGrant(),paper.getTitle(),paper.getTotalscore());
	}
	@Override
	public int updatePaper(Paper paper) {
		String sql = "update paper set uid = ?,readgrant = ?,title = ?,totalscore = ? where pid = ?";
		return jdbcTemplate.update(sql,paper.getUid(),paper.getReadGrant(),paper.getTitle(),paper.getTotalscore(),paper.getPid());
	}
	@Override
	public Paper findPaperById(int pid) {
		String sql = "select p.*,u.name from paper p left join user u on p.uid=u.uid where pid = ?";
		return jdbcTemplate.queryForObject(sql, new PaperMapper(),pid);
	}
	@Override
	public List<MakePaper> findSelectedQuestionsByPaperId(int pid) {
		String sql="select mp.*,q.title from ( select * from makepaper where pid = ? ) mp left join question q on mp.qid = q.qid";
		return jdbcTemplate.query(sql, new MakePaperMapper(),pid);
	}
	@Override
	public List<Paper> findAllPapers(int uid) {
		String sql="select p.*,u.name from paper p left join user u on p.uid=u.uid where p.uid= ? or p.readgrant=2 order by pid";
		return jdbcTemplate.query(sql, new PaperMapper(),uid);
	}

}
