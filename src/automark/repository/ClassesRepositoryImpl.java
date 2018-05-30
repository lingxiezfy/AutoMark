package automark.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.model.Classes;
import automark.model.Teach;
import automark.repository.mapper.ClassesMapper;
import automark.repository.mapper.TeachMapper;

@Repository
public class ClassesRepositoryImpl implements ClassesRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	@Override
	public Classes findClassesByStudentId(int uid) {
		String sql = "select c.cid,c.name from study s , classes c where "+
					"c.cid = s.cid and s.uid = ? ";
		Classes classes = null;
		try {
			classes = jdbcTemplate.queryForObject(sql, new ClassesMapper(), uid);
			System.out.println(classes.getName());
		}catch (Exception e) {
			System.out.println("未找到uid ："+uid);
			classes = null;
		}
		return classes;
	}

	@Override
	public List<Teach> findTeachesByTeacherId(int uid) {
		String sql = "select t.*,c.name from teach t,classes c where "+
					"t.cid = c.cid and t.uid = ?";
		List<Teach> list = null;
		try {
			list = jdbcTemplate.query(sql, new TeachMapper(), uid);
		}catch (Exception e) {
			list = null;
		}
		return list;
	}

	@Override
	public Teach findTeachInfoByTeacherIdAndClassId(int uid, int cid) {
		String sql = "select t.*,c.name from teach t,classes c where "+
				"t.cid = c.cid and t.uid = ? and t.cid = ?";
		Teach teach = null;
		try {
			teach = jdbcTemplate.queryForObject(sql, new TeachMapper(), uid,cid);
		//	System.out.println(teach.getCourse());
		}catch (Exception e) {
		//	System.out.println("未找到用户 ："+uid +"班级："+cid);
			teach = null;
		}
		return teach;
	}



}
