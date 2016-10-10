package br.usjt.arqdes16.mapeamento.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import br.usjt.arqdes16.google.geolocation.Endereco;
import br.usjt.arqdes16.google.geolocation.Localizacao;
import br.usjt.arqdes16.google.geolocation.ResultadoGoogle;


@Service
public class GoogleMapsService {
	private final String KEY = "AIzaSyBM94KJ_EYyq-TiaXfjt9oefskMh78jaGQ";

	public Localizacao parseLocalizacao(String resultado) {
		Localizacao local = new Localizacao();
		try {
			JSONObject google = new JSONObject(resultado);
			JSONArray resultados = google.getJSONArray("results");
			JSONObject primeiroResultado = resultados.getJSONObject(0);
			JSONObject geometria = primeiroResultado.getJSONObject("geometry");
			JSONObject localizacao = geometria.getJSONObject("location");
			local.setLat(localizacao.getDouble("lat"));
			local.setLng(localizacao.getDouble("lng"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return local;
	}
	
	public String parseEnderecoFormatado(String resultado) {
		String endereco = "";
		try {
			JSONObject google = new JSONObject(resultado);
			JSONArray resultados = google.getJSONArray("results");
			JSONObject primeiroResultado = resultados.getJSONObject(0);
		    endereco = primeiroResultado.getString("formatted_address");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return endereco;
	}

	public Localizacao getLocalizacao(ResultadoGoogle resultado) {
		return resultado.getLocalizacao();
	}

	public String montaURL(Endereco endereco){
		final String SEPARADOR = ",";
		String url = "https://maps.googleapis.com/maps/api/geocode/json";
		String address = "address="+endereco.getLogradouro()+SEPARADOR+
				endereco.getCidade()+SEPARADOR+endereco.getEstado()+
				SEPARADOR+endereco.getPais();
		
		System.out.println(url+"?"+address+"&"+KEY);
		return url+"?"+address+"&"+KEY;
	}

	public String getEnderecoFormatado(ResultadoGoogle resultado) {
		return resultado.getEnderecoFormatado();
	}

}
