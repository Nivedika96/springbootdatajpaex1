package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;



@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*repo.save(new Product(10,"AA",3.3));
		repo.save(new Product(11,"BA",4.6));
		repo.save(new Product(12,"CC",5.5));
		
		//update 
		repo.save(new Product(11,"nivi",7.9));*/
		
		
		//bulk insert
		List<Product> prds=Arrays.asList(
				new Product(101,"RR",6.9),
				new Product(102,"RRv",7.9),
				new Product(103,"Rgh",9.9)

				
				
				);

		repo.saveAll(prds);
		//fetch one row
	Optional<Product> p=repo.findById(101);
	if(p.isPresent()) {
		Product prd=p.get();
		System.out.println(prd.getProdCode());
	}else {
		System.out.println("row not found");
	}
	//fetch all rows
	List<Product> list=repo.findAll();
	list.forEach(System.out::println);
	
	
	//delete operations
	repo.deleteById(101);
	//delete all rows
	
	repo.deleteAll();
	repo.deleteAllInBatch();
	}

}
