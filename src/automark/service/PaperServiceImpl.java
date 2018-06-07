package automark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.model.MakePaper;
import automark.model.Paper;
import automark.repository.PaperRepository;
@Service
public class PaperServiceImpl implements PaperService{
	@Autowired
	PaperRepository paperRepository;
	@Override
	public List<Paper> findPagedPapersByTeacherId(int uid, int currPage) {
		return paperRepository.findPagedPapersByTeacherId(uid,currPage);
	}
	@Override
	public int countPapersByTeacherId(int uid) {
		// TODO Auto-generated method stub
		return paperRepository.countPapersByTeacherId(uid);
	}
	@Override
	public List<Paper> findPagedPapersByKeys(int uid, String key, int currPage) {
		return paperRepository.findPagedPapersByKeys(uid,key, currPage);
	}
	@Override
	public int countPapersByKeys(int uid, String key) {
		// TODO Auto-generated method stub
		return paperRepository.countPapersByKeys(uid,key);
	}
	@Override
	public int deleteById(int pid) {
		return paperRepository.deleteById(pid);
	}
	@Override
	public int updatePaperReadGrant(int pid, int readGrant) {
		readGrant = (readGrant == 1 ? 2 :1);
		return paperRepository.updatePaperReadGrant(pid, readGrant);
	}
	@Override
	public int addPaper(Paper paper) {
		return paperRepository.addPaper(paper);
	}
	@Override
	public int updatePaper(Paper paper) {
		return paperRepository.updatePaper(paper);
	}
	@Override
	public Paper findPaperById(int pid) {
		return paperRepository.findPaperById(pid);
	}
	@Override
	public List<MakePaper> findSeletedQuestions(int pid) {
		// TODO Auto-generated method stub
		return paperRepository.findSelectedQuestionsByPaperId(pid);
	}
	@Override
	public List<Paper> findAllPapers(int uid) {
		return paperRepository.findAllPapers(uid);
	}

}
