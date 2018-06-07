package automark.service;

import java.util.List;

import automark.model.MakePaper;
import automark.model.Paper;

public interface PaperService {
	/**
	 * 获取教师可见的分页试卷信息
	 * @param uid 教师id
	 * @param currPage 当前页
	 * @return
	 */
	List<Paper> findPagedPapersByTeacherId(int uid, int currPage);
	/**
	 * 计算可见试卷总数
	 * @param uid
	 * @return
	 */
	int countPapersByTeacherId(int uid);
	/**
	 * 检索教师可见的试卷信息（分页）
	 * @param uid
	 * @param key
	 * @param currPage
	 * @return
	 */
	List<Paper> findPagedPapersByKeys(int uid, String key, int currPage);
	/**
	 * 计算当前条件下的试卷信息
	 * @param uid
	 * @param key
	 * @return
	 */
	int countPapersByKeys(int uid, String key);
	/**
	 * 通过id删除
	 * @param pid
	 * @return
	 */
	int deleteById(int pid);
	/**
	 * 修改试卷的浏览权限
	 * @param pid
	 * @param readGrant
	 * @return
	 */
	int updatePaperReadGrant(int pid, int readGrant);
	/**
	 * 增加一张试卷
	 * @param paper
	 * @return
	 */
	int addPaper(Paper paper);
	/**
	 * 更新一张试卷
	 * @param paper
	 * @return
	 */
	int updatePaper(Paper paper);
	/**
	 * 通过id获取试卷
	 * @param pid
	 * @return
	 */
	Paper findPaperById(int pid);
	/**
	 * 选择试卷
	 * @param pid
	 * @return
	 */
	List<MakePaper> findSeletedQuestions(int pid);
	/**
	 * 查找所有可见试卷
	 * @param uid
	 * @return
	 */
	List<Paper> findAllPapers(int uid);

}
