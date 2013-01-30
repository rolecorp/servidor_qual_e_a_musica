package es.ufc.qualeamusica.webservice;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import es.ufc.qualeamusica.model.RankingGeral;



public class DataSerializer {

	private static DataSerializer instance;
	ObjectMapper objectMapper = null;
	
	private DataSerializer() {
		objectMapper = new ObjectMapper();
	}
	
	public static DataSerializer getInstance() {
		if(instance == null)
			instance = new DataSerializer();
		
		return instance;
	}

//	public String toJson(Object content) throws IOException {		
//		
////		objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);
//		return objectMapper.writeValueAsString(content);
//	}
//		
//	public<T>  T toObject(String json, Class targetClass) throws JsonParseException, JsonMappingException, IOException {
//		return (T) objectMapper.readValue(json, targetClass);	
//	}
	
	public String converterParaJson(List<RankingGeral> r) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); //ObjectMapper é uma classe da biblioteca Jackson
		return mapper.writeValueAsString(r); //Este metodo irá retornar o JSON da variável "p".
	}
	
	public RankingGeral converterParaRankingGeral(String json) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, RankingGeral.class); //Método utilizado para ler o json e retornar a instância da classe.
	}

}
