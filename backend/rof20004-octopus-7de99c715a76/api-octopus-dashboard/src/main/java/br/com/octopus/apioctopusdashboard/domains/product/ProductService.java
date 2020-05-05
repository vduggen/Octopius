package br.com.octopus.apioctopusdashboard.domains.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octopus.apioctopusdashboard.exceptions.ProductException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductDTO create(ProductDTO dto) throws ProductException {
		validateProduct(dto);

		Product product = Product.builder().name(dto.getName()).link(dto.getLink()).build();
		productRepository.save(product);

		dto.setId(product.getId());

		return dto;
	}
	
	public List<ProductDTO> read() throws ProductException {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> dto = products.stream().map(product -> ProductDTO.builder().id(product.getId()).name(product.getName()).link(product.getLink()).build()).collect(Collectors.toList());
		return dto;
	}
	
	public ProductDTO readOne(Long id) throws ProductException {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			throw new ProductException("Produto não encontrado");
		}
		
		ProductDTO dto = ProductDTO.builder().id(product.getId()).name(product.getName()).link(product.getLink()).questions(product.getQuestions()).build();
		return dto;
	}
	
	public ProductDTO update(ProductDTO dto) throws ProductException {
		try {
			validateProduct(dto);
			validateProductId(dto.getId());
			
			Product product = productRepository.findById(dto.getId()).orElse(null);
			if (product == null) {
				throw new ProductException("Produto não encontrado");
			}
			
			product.setName(dto.getName());
			product.setLink(dto.getLink());
			
			productRepository.save(product);
			
			return dto;
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
	}
	
	public void delete(Long id) throws ProductException {
		boolean exists = productRepository.existsById(id);
		if (!exists) {
			throw new ProductException("Produto não encontrado");
		}
		
		productRepository.deleteById(id);
	}

	private void validateProduct(ProductDTO dto) throws ProductException {
		if (dto == null) {
			throw new ProductException("É obrigatório informar o nome e link do produto");
		}

		validateProductName(dto.getName());
		validateProductLink(dto.getLink());
	}
	
	private void validateProductId(Long id) throws ProductException {
		if (id == null) {
			throw new ProductException("É obrigatório informar o id do produto");
		}
	}

	private void validateProductName(String name) throws ProductException {
		if (name == null || name.isEmpty()) {
			throw new ProductException("É obrigatório informar o nome do produto");
		}
	}

	private void validateProductLink(String link) throws ProductException {
		if (link == null || link.isEmpty()) {
			throw new ProductException("É obrigatório informar o link do produto");
		}
	}

}
