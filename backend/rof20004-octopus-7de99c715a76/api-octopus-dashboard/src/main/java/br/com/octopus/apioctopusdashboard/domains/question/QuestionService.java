package br.com.octopus.apioctopusdashboard.domains.question;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octopus.apioctopusdashboard.domains.product.Product;
import br.com.octopus.apioctopusdashboard.domains.product.ProductRepository;
import br.com.octopus.apioctopusdashboard.exceptions.QuestionException;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public QuestionDTO create(QuestionDTO dto) throws QuestionException {
		validateQuestion(dto);

		Product product = productRepository.findById(dto.getProductId()).orElse(null);
		if (product == null) {
			throw new QuestionException("Produto não encontrado");
		}
		
		Question question = Question.builder().text(dto.getText()).product(product).isNotified(dto.isNotified()).isRelevant(dto.isRelevant()).build();
		questionRepository.save(question);

		dto.setId(question.getId());

		return dto;
	}
	
	public List<QuestionDTO> read() {
		List<Question> questions = questionRepository.findAll();
		List<QuestionDTO> dto = questions.stream().map(question -> QuestionDTO.builder().id(question.getId()).text(question.getText()).isNotified(question.isNotified()).isRelevant(question.isRelevant()).productId(question.getProduct().getId()).build()).collect(Collectors.toList());
		return dto;
	}
	
	public List<QuestionDTO> findByIsNotified(boolean isNotified) {
		List<Question> questions = questionRepository.findByIsNotified(isNotified);
		List<QuestionDTO> dto = questions.stream().map(question -> QuestionDTO.builder().id(question.getId()).text(question.getText()).isNotified(question.isNotified()).isRelevant(question.isRelevant()).productId(question.getProduct().getId()).build()).collect(Collectors.toList());
		return dto;
	}
	
	private void validateQuestion(QuestionDTO dto) throws QuestionException {
		if (dto == null) {
			throw new QuestionException("É obrigatório informar a pergunta");
		}

		validateQuestionProduct(dto.getProductId());
		validateQuestionText(dto.getText());
	}
	
	private void validateQuestionProduct(Long productId) throws QuestionException {
		if (productId == null) {
			throw new QuestionException("É obrigatório informar um produto para a pergunta");
		}
	}
	
	private void validateQuestionText(String text) throws QuestionException {
		if (text == null || text.isEmpty()) {
			throw new QuestionException("É obrigatório informar o texto da pergunta");
		}
	}

}
