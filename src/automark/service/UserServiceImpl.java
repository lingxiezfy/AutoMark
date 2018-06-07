package automark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.model.User;
import automark.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository ;
	@Override
	public User verifyUser(String account, String password, int type) {
		System.out.println("输入："+account +" "+password +" "+ type);
		User user = userRepository.findUserByAccount(account);
		if(user != null) {
			if(user.getPassword().equals(password) && user.getType() == type) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> findAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllTeachers() {
		return userRepository.findAllTeachers();
	}

	@Override
	public List<User> findStudentsByClassId(int cid) {
		System.out.println("班级id："+cid);
		List<User> list = userRepository.findStudentsByClassId(cid);
		return list;
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
