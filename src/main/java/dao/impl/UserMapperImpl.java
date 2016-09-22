package dao.impl;

import java.util.List;
import java.util.Map;

import model.User;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.github.abel533.sql.SqlMapper;

import dao.UserMapper;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
	
	@Override
	public Map<String, Object>selectUser(User user) {
		Map<String, Object> map;
		SqlMapper sqlMapper = new SqlMapper(getSqlSession());
		map = sqlMapper.selectOne("select * from user limit 1");
		return map;
	}
	
	@Override
	public List<Map<String, Object>> selectUsers() {
		List<Map<String, Object>> list = new SqlMapper(getSqlSession()).selectList("select * from user");
		return list;
	}
}
