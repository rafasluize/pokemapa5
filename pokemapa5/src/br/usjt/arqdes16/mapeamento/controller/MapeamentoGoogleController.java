package br.usjt.arqdes16.mapeamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.usjt.arqdes16.google.geolocation.Endereco;
import br.usjt.arqdes16.google.geolocation.ResultadoGoogle;
import br.usjt.arqdes16.mapeamento.service.GoogleMapsService;

@Controller
public class MapeamentoGoogleController {
	private final String LOCALIZACAO = "localizacao";
	private final String ENDERECO = "endereco";
	GoogleMapsService gms;
	
	@Autowired
	public MapeamentoGoogleController(GoogleMapsService gms) {
		this.gms = gms;
	}
	
	@RequestMapping("/procurarlocalizacao")
	public String procurarlocalizacao(){
		return "local/buscar_localizacao";
	}
	
	@RequestMapping("/google_json_org")
	public String testeJsonOrg(Endereco endereco, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String resultado = restTemplate
				.getForObject(
						gms.montaURL(endereco),
						String.class);
		
		model.addAttribute(LOCALIZACAO, gms.parseLocalizacao(resultado));
		model.addAttribute(ENDERECO, gms.parseEnderecoFormatado(resultado));
		return "local/mostrar_localizacao";
	}

	@RequestMapping("/google_jackson")
	public String testeJackson(Endereco endereco, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResultadoGoogle resultado = restTemplate
				.getForObject(
						gms.montaURL(endereco),
						ResultadoGoogle.class);
		model.addAttribute(LOCALIZACAO, gms.getLocalizacao(resultado));
		model.addAttribute(ENDERECO, gms.getEnderecoFormatado(resultado));
		return "local/mostrar_localizacao";
	}
}
