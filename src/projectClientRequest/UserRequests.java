package projectClientRequest;

import java.io.IOException;

import com.google.gson.Gson;

import classProjet.Admin;
import classProjet.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class UserRequests {
	
	private  Gson gson;
	private  OkHttpClient client;
	
	public UserRequests() {
		
		gson = new Gson();
		client = new OkHttpClient();
	}

	public Admin getUser(User user) {
		
		Admin admin = new Admin();
		String json = gson.toJson(user);
		MediaType media = MediaType.parse("application/json; charset=UTF-8");
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(media, json);
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/user/get")
				.post(body)
				.build();
		
		ResponseBody resBody;
		try {
			resBody = client.newCall(request).execute().body();
			admin = gson.fromJson(resBody.string(), Admin.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return admin;
	}
}
