package automark.repository;

import java.util.List;

import automark.model.User;

public interface UserRepository {
	public User findUserByAccount(String account);

	public List<User> findStudentsByClassId(int cid);
}
