package br.com.octopus.apioctopusdashboard.domains.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.octopus.apioctopusdashboard.exceptions.ProductException;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ProductDTO create(@RequestBody ProductDTO dto) throws ProductException {
		return productService.create(dto);
	}
	
	@GetMapping(path = "/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductDTO> read() throws ProductException {
		return productService.read();
	}
	
	@GetMapping(path = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ProductDTO readOne(@PathVariable(name = "id", required = false) Long id) throws ProductException {
		return productService.readOne(id);
	}
	
	@PutMapping(path = "/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ProductDTO update(@RequestBody ProductDTO dto) throws ProductException {
		return productService.update(dto);
	}
	
	@DeleteMapping(path = "/v1/products/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(name = "id") Long id) throws ProductException {
		productService.delete(id);
	}

}
