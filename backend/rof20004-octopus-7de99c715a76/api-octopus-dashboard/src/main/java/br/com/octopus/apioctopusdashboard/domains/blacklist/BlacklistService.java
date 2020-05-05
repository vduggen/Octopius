package br.com.octopus.apioctopusdashboard.domains.blacklist;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octopus.apioctopusdashboard.exceptions.BlacklistException;

@Service
public class BlacklistService {

	@Autowired
	private BlacklistRepository blacklistRepository;

	public BlacklistDTO create(BlacklistDTO dto) throws BlacklistException {
		validateBlacklist(dto);

		Blacklist blacklist = Blacklist.builder().text(dto.getText()).build();
		blacklistRepository.save(blacklist);

		dto.setId(blacklist.getId());

		return dto;
	}
	
	public List<BlacklistDTO> read() {
		List<Blacklist> blacklist = blacklistRepository.findAll();
		List<BlacklistDTO> dto = blacklist.stream().map(text -> BlacklistDTO.builder().id(text.getId()).text(text.getText()).build()).collect(Collectors.toList());
		return dto;
	}
	
	public BlacklistDTO update(BlacklistDTO dto) throws BlacklistException {
		try {
			validateBlacklist(dto);
			validateBlacklistId(dto.getId());
			
			Blacklist blacklist = blacklistRepository.findById(dto.getId()).orElse(null);
			if (blacklist == null) {
				throw new BlacklistException("Texto não encontrado");
			}
			
			blacklist.setText(dto.getText());
			
			blacklistRepository.save(blacklist);
			
			return dto;
		} catch (Exception e) {
			throw new BlacklistException(e.getMessage());
		}
	}
	
	public void delete(Long id) throws BlacklistException {
		boolean exists = blacklistRepository.existsById(id);
		if (!exists) {
			throw new BlacklistException("Texto não encontrado");
		}
		
		blacklistRepository.deleteById(id);
	}

	private void validateBlacklist(BlacklistDTO dto) throws BlacklistException {
		if (dto == null) {
			throw new BlacklistException("É obrigatório informar o texto");
		}

		validateBlacklistText(dto.getText());
	}
	
	private void validateBlacklistId(Long id) throws BlacklistException {
		if (id == null) {
			throw new BlacklistException("É obrigatório informar o id do texto na blacklist");
		}
	}

	private void validateBlacklistText(String text) throws BlacklistException {
		if (text == null || text.isEmpty()) {
			throw new BlacklistException("É obrigatório informar o texto");
		}
	}

}
