package dao;


import java.util.List;
import java.util.Map;

import model.User;

public interface UserMapper {

	public Map<String, Object> selectUser(User user);
	public List<Map<String, Object>> selectUsers();
//	public void insertUser(User user);
//	public void updateUser(User user);
//	public void deleteUser(User user);
}
