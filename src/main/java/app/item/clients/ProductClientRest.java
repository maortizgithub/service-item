package app.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.commons.models.entity.Product;

@FeignClient(name = "service-products")
public interface ProductClientRest {

	@GetMapping("/list")
	public List<Product> list();

	@GetMapping("/view/{id}")
	public Product detail(@PathVariable Long id);

	@PostMapping("/create")
	public Product create(@RequestBody Product product);

	@PutMapping("/edit/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id);

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id);
}
