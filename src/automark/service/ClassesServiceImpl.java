package automark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.model.Classes;
import automark.model.Teach;
import automark.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService{
	@Autowired
	ClassesRepository classesRepository;
	@Override
	public List<Classes> findAllClasses() {
		return classesRepository.findAllClasses();
	}

	@Override
	public List<Teach> findTeachesByTeacherId(int uid) {
		List<Teach> teaches = classesRepository.findTeachesByTeacherId(uid);
		return teaches;
	}

	@Override
	public Classes findClassesByStudentId(int uid) {
		Classes classes = classesRepository.findClassesByStudentId(uid);
		return classes;
	}

}
