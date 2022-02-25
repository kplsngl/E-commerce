package com.example.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.product.Product;
import com.example.service.ProductService;


@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService productService;


	@PostMapping("/upload")
	public Product createProduct(@RequestBody Product product) {
		return productService.uploadProduct(product);
	}

	@GetMapping("/getById")
	public Product getProductById(@RequestParam String id) {
		return productService.getProductById(id);
	}


	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable String id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("/addReview")
	public String addReview(@RequestParam String pId, @RequestParam String cId, @RequestParam String text) {
		return productService.addReview(pId, cId, text);
	}
	@GetMapping("/addPagination")
	public List<Product> addPagination(@RequestParam int pageNo , @RequestParam int pageSize) {
		return productService.addPagination(pageNo,pageSize);
	}
	@GetMapping("/getByCategory")
	public List<Object> getByCategory(@RequestParam String catg){
		return productService.getByCategory(catg);
	}



//	@GetMapping("/photos")
//	public byte[] getPhoto(@RequestParam String id) {
//		Photo photo = photoService.getPhoto(id);
////		model.addAttribute("title", photo.getTitle());
////		model.addAttribute("image",
////				Base64.getEncoder().encodeToString(photo.getImage().getData()));
//		byte[] image = Base64.getDecoder().decode(photo.getImage().getData());
//		return image;
//	}

}

