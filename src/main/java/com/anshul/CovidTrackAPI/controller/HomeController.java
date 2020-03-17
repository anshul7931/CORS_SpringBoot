package com.anshul.CovidTrackAPI.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static String VIRUS_DATA_URL = "https://www.bing.com/covid/data?IG=BD288EBFB83345808DC89A138173CFF4";

	@CrossOrigin
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		URL url;
		HttpURLConnection con;
		StringBuffer sb = new StringBuffer("");
		try {
			url = new URL(VIRUS_DATA_URL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET"); 
			BufferedReader inp = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			
			String strCurrentLine = "";
			while ((strCurrentLine = inp.readLine()) != null) {
			    sb.append(strCurrentLine);
			}
			
			inp.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return sb.toString();
	}
	
}
