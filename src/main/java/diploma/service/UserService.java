package diploma.service;


import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import diploma.entity.User;
import diploma.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userDao;
	
	public User findById(long id){
		return userDao.findOne(id);
	}

	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findByEmail(String email){
		return userDao.findByEmail(email);
	}
	
	public Page<User> findAll(int page, int count){
		Pageable pages = new PageRequest(page, count);
		return userDao.findAll(pages); 
	}
	
}
