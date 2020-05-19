package app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.app.commons.models.entity.Product;

import app.item.clients.ProductClientRest;
import app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductClientRest feignClient;

	@Override
	public List<Item> findAll() {
		return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(feignClient.detail(id), quantity);
	}

	@Override
	public Product save(Product product) {
		return feignClient.create(product);
	}

	@Override
	public Product update(Product product, Long id) {
		return feignClient.update(product, id);
	}

	@Override
	public void delete(Long id) {
		feignClient.delete(id);
		
	}

}
