package com.example.entity.orders;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Orders")
public class Orders {
	
	@Id
	private String id;

	private List<String> product_ids;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getProduct_ids() {
		return product_ids;
	}

	public void setProduct_ids(List<String> product_ids) {
		this.product_ids = product_ids;
	}
}
