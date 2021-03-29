package projectClientRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import classProjet.Enseignant;
import classProjet.Etudiant;
import javafx.collections.ObservableList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class EnseignantRequests {
	
	private  Gson gson;
	private  OkHttpClient client;
	
	public EnseignantRequests() {
		
		gson = new Gson();
		client = new OkHttpClient();
	}

	public void addEnseignant(Enseignant ens) {
		
		String json = gson.toJson(ens);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/enseignant/save")
				.post(body)
				.build();
		

		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Enseignant> getEnseignants() {
		
		List<Enseignant> enseignants = null;
		Request request = new Request.Builder()
                .url("http://localhost:8080/enseignant/all")
                .get()
                .build();
		
		ResponseBody resBody;
		try {
			resBody = client.newCall(request).execute().body();
			enseignants = gson.fromJson(resBody.string(), new TypeToken<ArrayList<Enseignant>>(){}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return enseignants;
	}

	public void deleteEnseignant(Long id) {
		
		Request request = new Request.Builder()
		                     .url("http://localhost:8080/enseignant/"+id)
		                     .delete()
		                     .build();
		
		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void putEnseignant(Enseignant enseignant) {
		
		String json = gson.toJson(enseignant);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/enseignant/change")
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
