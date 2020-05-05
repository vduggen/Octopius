package br.com.octopus.apioctopusdashboard.domains.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.octopus.apioctopusdashboard.domains.question.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class ProductDTO {

	private Long id;
	private String name;
	private String link;
	private List<Question> questions;
	
}
