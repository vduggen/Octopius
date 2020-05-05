package br.com.octopus.apioctopusdashboard.domains.blacklist;

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

import br.com.octopus.apioctopusdashboard.exceptions.BlacklistException;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
public class BlacklistController {

	@Autowired
	private BlacklistService blacklistService;

	@PostMapping(path = "/v1/blacklist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public BlacklistDTO create(@RequestBody BlacklistDTO dto) throws BlacklistException {
		return blacklistService.create(dto);
	}
	
	@GetMapping(path = "/v1/blacklist", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<BlacklistDTO> read() {
		return blacklistService.read();
	}
	
	@PutMapping(path = "/v1/blacklist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public BlacklistDTO update(@RequestBody BlacklistDTO dto) throws BlacklistException {
		return blacklistService.update(dto);
	}
	
	@DeleteMapping(path = "/v1/blacklist/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(name = "id") Long id) throws BlacklistException {
		blacklistService.delete(id);
	}

}
