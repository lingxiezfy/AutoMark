package automark.repository;

import java.util.List;

import automark.model.MakePaper;
import automark.model.Paper;

public interface PaperRepository {
	/**
	 * 检索所有的试卷信息
	 * @param uid
	 * @param currPage
	 * @return
	 */
	List<Paper> findPagedPapersByTeacherId(int uid, int currPage);
/**
 * 获取所有的试卷总数
 * @param uid
 * @return
 */
	int countPapersByTeacherId(int uid);
/**
 * 获取分页的试卷信息（条件检索）
 * @param uid
 * @param key
 * @param currPage
 * @return
 */
	List<Paper> findPagedPapersByKeys(int uid, String key, int currPage);
/**
 * 计算当前条件下试卷总数
 * @param uid
 * @param key
 * @return
 */
	int countPapersByKeys(int uid, String key);
/**
 * 通过id删除试卷
 * @param pid
 * @return
 */
	int deleteById(int pid);
/**
 * 更新试卷的浏览权限
 * @param pid
 * @param readGrant
 * @return
 */
	int updatePaperReadGrant(int pid, int readGrant);
/**
 * 增加试卷
 * @param paper
 * @return
 */
	int addPaper(Paper paper);
/**
 * 更新试卷
 * @param paper
 * @return
 */
	int updatePaper(Paper paper);
/**
 * 通过id查找题目
 * @param pid
 * @return
 */
	Paper findPaperById(int pid);
	/**
	 * 获取题目的选题信息
	 * @param pid
	 * @return
	 */
	List<MakePaper> findSelectedQuestionsByPaperId(int pid);
/**
 * 获取所有的试卷信息
 * @param uid
 * @return
 */
	List<Paper> findAllPapers(int uid);
}
