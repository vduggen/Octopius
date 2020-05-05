package br.com.octopus.apioctopusdashboard.domains.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.octopus.apioctopusdashboard.exceptions.BlacklistException;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET })
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping(path = "/v1/questions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public QuestionDTO create(@RequestBody QuestionDTO dto) throws BlacklistException {
		return questionService.create(dto);
	}
	
	@GetMapping(path = "/v1/questions", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<QuestionDTO> read() {
		return questionService.read();
	}
	
	@GetMapping(path = "/v1/questions/notifieds", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<QuestionDTO> findAllNotified() {
		return questionService.findByIsNotified(true);
	}
	
}
