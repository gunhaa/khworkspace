package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.dto.Air;

@Controller
public class OpenAPIController {

	private static final String SERVICEKEY = "tqZII1GM3c%2B9CZUbuTOfaHeO5atCOmkztBy%2BGUNLN5Lm0czg4erwB9wYhL975hTg948uErzh5rGwWGXe%2BEP3LA%3D%3D";
	
	// json 형식으로 대기오염 OpenAPI 활용
	
	//@RequestMapping(value="air" , produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<Air> airPollution(@RequestParam String location) throws IOException {
		
		// OpenAPI 서버로 요청하고자하는 url 작성
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		
		url+="?serviceKey="+SERVICEKEY; 
		url+="&sidoName=" + URLEncoder.encode(location, "UTF-8");
		url+="&returnType=json";
		
		
		URL requestUrl = new URL(url);
		
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		
		while((line=br.readLine())!=null) {
			responseText += line;
		}
		
		JsonObject totalObj = JsonParser.parseString(responseText).getAsJsonObject();
		
		JsonObject responseObj=totalObj.getAsJsonObject("response");
		
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		
		JsonArray itemArr = bodyObj.getAsJsonArray("items");
		
		List<Air> list = new ArrayList<>();
		
		for(int i=0; i<itemArr.size(); i++) {
			JsonObject item = itemArr.get(i).getAsJsonObject();

			Air air = new Air();
	        air.setStationName(item.get("stationName").getAsString());
	        air.setDataTime(item.get("dataTime").getAsString());
	        air.setKhaiValue(item.get("khaiValue").getAsString());
	        air.setPm10Value(item.get("pm10Value").getAsString());
	        air.setSo2Value(item.get("so2Value").getAsString());
	        air.setCoValue(item.get("coValue").getAsString());
	        air.setNo2Value(item.get("no2Value").getAsString());
	        air.setO3Value(item.get("o3Value").getAsString());
	         
	        list.add(air);
		}
		
		
		br.close();
		urlConn.disconnect();
		
		return list;
	}
	
	  // xml 형식으로 대기오염 OpenAPI 활용
	   @RequestMapping(value="air", produces="text/xml; charset=UTF-8")      
	   @ResponseBody
	   public String airPollutionXML(String location) throws IOException {
	                  // 서울, 부산, 대구 중 하나가 담길 것
	      
	      
	      // OpenAPI 서버로 요청하고자 하는 url 작성
	      // 시도별 실시간 측정정보 조회(서비스키, 시도명 필수)
	      String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
	      url += "?serviceKey=" + SERVICEKEY; // 서비스키가 제대로 부여되지 않았을 경우 -> SERVICE_KEY_IS_NOT_REGISTERED_ERROR
	      url += "&sidoName=" + URLEncoder.encode(location , "UTF-8"); // 지역명 추가(한글이 들어가면 encoding 처리 해줘야한다)
	      
	      // 여기서부턴 필수가 아닌, 옵션
	      url += "&returnType=xml";
	      url += "&numOfRows=100";
	      
	      
	      // 1.요청할주소를전달해서java.net.URL 객체생성하기
	      URL requestUrl = new URL(url);
	      
	      // 2.생성된URL 객체를가지고HttpUrlConnection객체얻어내기
	      HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection(); 
	      

	      // 3.요청시필요한Header 설정하기
	      urlConn.setRequestMethod("GET");
	      
	      // 4.해당OpenAPI서버로요청보낸후입력스트림을통해응답데이터받기
	      // 하나하나가 아니라 한줄로 읽기 위해서
	      BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	      
	      // 나는 한줄한줄이 아니라 한문자열로 하고 싶으면
	      String line;
	      String responseText = "";
	      
	      while( (line = br.readLine()) != null) {
	         responseText += line;
	      }
	      // 5.다사용한스트림객체반납하기
	      br.close();
	      urlConn.disconnect();
	      
	      return responseText;
	   }

	   @RequestMapping(value="hail", produces="text/xml; charset=UTF-8")
	   @ResponseBody
	   public String hailXML() throws Exception {
		   
		      String url = "http://apis.data.go.kr/1741000/TsunamiShelter4/getTsunamiShelter4List";
		      url += "?serviceKey=" + SERVICEKEY; // 서비스키가 제대로 부여되지 않았을 경우 -> SERVICE_KEY_IS_NOT_REGISTERED_ERROR
		      url += "&pageNo=1"; 
		      
		      // 여기서부턴 필수가 아닌, 옵션
		      url += "&type=xml";
		      url += "&numOfRows=50";
		   
		      
		      // 1.요청할주소를전달해서java.net.URL 객체생성하기
		      URL requestUrl = new URL(url);
		      
		      // 2.생성된URL 객체를가지고HttpUrlConnection객체얻어내기
		      HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection(); 
		      

		      // 3.요청시필요한Header 설정하기
		      urlConn.setRequestMethod("GET");
		      
		      
		      // 4.해당OpenAPI서버로요청보낸후입력스트림을통해응답데이터받기
		      // 하나하나가 아니라 한줄로 읽기 위해서
		      															//urlConn.getInputStream() 메소드로 api통신이 이루어진다.
		      BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		      
		      // 나는 한줄한줄이 아니라 한문자열로 하고 싶으면
		      String line;
		      String responseText = "";
		      
		      while( (line = br.readLine()) != null) {
		         responseText += line;
		      }
		      // 5.다사용한스트림객체반납하기
		      br.close();
		      urlConn.disconnect();
		      
		      return responseText;

	   }
	   
	   @RequestMapping(value="electric" ,produces="application/json; charset=UTF-8")
	   @ResponseBody
	   public String electric() throws IOException {
		   
		   String url = "http://apis.data.go.kr/B552115/SmpWithForecastDemand/getSmpWithForecastDemand";
		   url+= "?serviceKey=" + SERVICEKEY;
		   url+= "&pageNo=1";
		   url+= "&numOfRows=10";
		   url+= "&dataType=json";
		   url+= "&date=20240812";

		   
		   URL requrl = new URL(url);
		   
		   HttpURLConnection urlConn = (HttpURLConnection)requrl.openConnection();
		   
		   urlConn.setRequestMethod("GET");
		   
		   BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		   String line;
		   String response="";
		   while((line=br.readLine())!=null) {
			   response+=line;
		   }
		   
		   return response;
	   }
	   
	   
	   
	   
	   
	   //-----------------------------------------------------
	   
	   @RequestMapping(value="test" , produces="text/xml; charset=UTF-8")
	   @ResponseBody
	   public String test() throws IOException {
		   
		      String url = "http://apis.data.go.kr/1741000/TsunamiShelter4/getTsunamiShelter4List";
		      url += "?serviceKey=" + SERVICEKEY;
		      url += "&pageNo=1"; 
		      url += "&type=xml";
		      url += "&numOfRows=2";
		      
		      URL requrl = new URL(url);
		      
		      HttpURLConnection urlConnection = (HttpURLConnection)requrl.openConnection();
		      
			   BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			   String line;
			   String body="";
			   
			   while((line=br.readLine())!=null) {
				   body+=line;
			   }
		   
		   return body;
	   }
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   //-----------------------------------
		@RequestMapping(value="test2" , produces="application/json; charset=UTF-8")
		@ResponseBody
		public String test2(@RequestParam String location) throws IOException {
			
			// OpenAPI 서버로 요청하고자하는 url 작성
			
			String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
			
			url+="?serviceKey="+SERVICEKEY; 
			url+="&sidoName=" + URLEncoder.encode(location, "UTF-8");
			url+="&returnType=json";
			
			// http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=tqZII1GM3c%2B9CZUbuTOfaHeO5atCOmkztBy%2BGUNLN5Lm0czg4erwB9wYhL975hTg948uErzh5rGwWGXe%2BEP3LA%3D%3D&sidoName=서울&returnType=json
			URL requestUrl = new URL(url);
			
			HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
			
			urlConn.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			
			String responseText = "";
			String line;
			
			while((line=br.readLine())!=null) {
				responseText += line;
			}
			

			br.close();
			urlConn.disconnect();
			
			return responseText;
		}
	
}
