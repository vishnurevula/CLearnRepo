package com.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Product;
import com.practiec.exception.ProductNotFoundException;

@RestController
public class ProductServiceController {
	private static Map<String,Product> productRepo =new HashMap<>();
	
	static List<Product> obj =new ArrayList<>();
	
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(),almond);
		obj.add(honey);
		obj.add(almond);
	}
	
	@GetMapping(path="products")
	public List<Product> getProducts(){
		return obj;
	}
	
	@GetMapping(value="/getProducts/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id){
		
		if(!productRepo.containsKey(id))
			throw new ProductNotFoundException();
			
			Product p = productRepo.get(id);
		
		return new ResponseEntity<>("Product is received successfully" + p.getName(), HttpStatus.OK);
		
	}
	
	@PostMapping("/postProduct")
		public ResponseEntity<Object> postProduct(@RequestBody Product product){
		
		productRepo.put(product.getId(),product);
		return new ResponseEntity<>("Product is received successfully"+ product.getName(), HttpStatus.OK);
	}
}
