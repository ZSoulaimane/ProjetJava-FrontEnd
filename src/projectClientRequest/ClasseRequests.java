package projectClientRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import classProjet.Classe;
import classProjet.Etudiant;
import javafx.collections.ObservableList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class ClasseRequests {
	
	private  Gson gson;
	private  OkHttpClient client;
	
	public ClasseRequests() {
		
		gson = new Gson();
		client = new OkHttpClient();
	}

	public List<Classe> getClasses() {
		
		List<Classe> classes = null;
		Request request = new Request.Builder()
                .url("http://localhost:8080/classe/all")
                .get()
                .build();
		
		ResponseBody resBody;
		try {
			resBody = client.newCall(request).execute().body();
			classes = gson.fromJson(resBody.string(), new TypeToken<ArrayList<Classe>>(){}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return classes;
	}

	public void putClasse(Classe classe) {
		
		String json = gson.toJson(classe);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/classe/change")
				.put(body)
				.build();
		

		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
