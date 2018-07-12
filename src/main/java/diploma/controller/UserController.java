package diploma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import diploma.entity.Product;
import diploma.entity.UserProduct;
import diploma.repository.ProductRepository;
import diploma.repository.UserProductRepository;
import diploma.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userDao;

	@Autowired
	ProductRepository productDao;
	
	@Autowired
	UserProductRepository userProductDao;
	
	@GetMapping("/cart")
	public List<UserProduct> findUserProducts(){
		return userProductDao.findAll();
	}
	
	@GetMapping("/cart/{id}")
	public List<UserProduct> findProductsOfUser(@PathVariable long id){
		return userProductDao.findByUserId(id);
	}
	
	@GetMapping("/api/auth/products")
	public List<Product> findProducts(){
		return productDao.findAll();
	}
	
}













