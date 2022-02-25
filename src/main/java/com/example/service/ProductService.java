package com.example.service;

import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.product.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	MongoClient mongoClient;
	
	public Product uploadProduct(Product product) {
		return productRepository.save(product);
	}

//	public List<Product> getAllProducts() {
//		return productRepository.findAll();
//	}
//
//	public List<Product> getProductsByName(String name) {
//		return productRepository.findByName(name);
//	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public String deleteProduct(String id) {
		productRepository.deleteById(id);
		return "Product deleted!";
	}
	public String addReview(String pId, String cId, String text) {
		Document a = new Document("user" ,cId).append("text",text);;
		Document listItem = new Document("reviews", a);
		Document document = new Document("$push",listItem );
		Bson filter = Filters.eq("_id", new ObjectId(pId));
		mongoClient.getDatabase("eComm").getCollection("product", Product.class).updateMany(filter, document);
		return "Review Added.";
	}

	public List<Product> addPagination(int pageNo, int pageSize) {
		PageRequest pageable= PageRequest.of(pageNo-1,pageSize);
		return productRepository.findAll(pageable).getContent();
	}

    public Product getProductById(String id) {
		return productRepository.findById(id).get();
    }

	public List<Object> getByCategory(String catg) {
		return productRepository.findByCategory(catg);
	}
}
