package com.shaman.beans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shaman.beans.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired(required=false)
	private TestObject testObject;
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository Save ...");
		System.out.println(testObject);
	}

}
