package projectClientRequest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import javax.annotation.PostConstruct;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import classProjet.Admin;
import classProjet.Classe;
import classProjet.Etudiant;
import classProjet.Parent;
import classProjet.User;
import javafx.collections.ObservableList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class EtudiantRequests {
	
	private  Gson gson;
	private  OkHttpClient client;
	
	public EtudiantRequests() {
		
		gson = new Gson();
		client = new OkHttpClient();
	}

	public void postEtudiant(Etudiant etudiant) {
		
		String json = gson.toJson(etudiant);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/etudiant/save")
				.post(body)
				.build();
		

		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEtudiant(Long id) {
		
		Request request = new Request.Builder()
		                     .url("http://localhost:8080/etudiant/"+id)
		                     .delete()
		                     .build();
		
		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Etudiant> getEtudiants() {
		
		List<Etudiant> etudiants = null;
		Request request = new Request.Builder()
                .url("http://localhost:8080/etudiant/all")
                .get()
                .build();
		
		ResponseBody resBody;
		try {
			resBody = client.newCall(request).execute().body();
			etudiants = gson.fromJson(resBody.string(), new TypeToken<ArrayList<Etudiant>>(){}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return etudiants;
	}

	public void putEtudiant(Etudiant etudiant) {
		
		String json = gson.toJson(etudiant);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/etudiant/change")
				.put(body)
				.build();
		

		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		EtudiantRequests etudiantRequests = new EtudiantRequests();
		/*Parent parent = new Parent(new Long(1),"fatima","mohammed",123,null);
		Classe classe = new Classe(new Long(1),"ghjj","2",null,null);
		Etudiant etudiant = new Etudiant(new Long(3),"achraf","mohammed", 0, 0.0, 0.0, 0.0, "1998-05-13", "dfj", parent,classe, null);
		
		etudiantRequests.postEtudiant(etudiant);
		etudiantRequests.deleteEtudiant(new Long(2));
		etudiantRequests.getEtudiants();
		etudiantRequests.putEtudiant(etudiant);*/
		
	}

}
