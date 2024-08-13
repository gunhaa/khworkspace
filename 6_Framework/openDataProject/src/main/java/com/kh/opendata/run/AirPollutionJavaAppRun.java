package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.dto.Air;

public class AirPollutionJavaAppRun {

	public static final String SERVICEKEY = "tqZII1GM3c%2B9CZUbuTOfaHeO5atCOmkztBy%2BGUNLN5Lm0czg4erwB9wYhL975hTg948uErzh5rGwWGXe%2BEP3LA%3D%3D";
	
	public static void main(String[] args) throws IOException {
		
		// OpenAPI 서버로 요청하고자 하는 URL 작성
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		
		
		// 서비스 키가 제대로 부여되지 않았을 경우 -> SERVICE_KEY_IS_NOT_REGISTERED_ERROR
		url+="?serviceKey="+SERVICEKEY; 
		
		url+="&sidoName=" + URLEncoder.encode("서울", "UTF-8");
		
		url+="&returnType=json";
		//System.out.println(url);
		
		// ** HttpURLConnection 객체를 활용해서 OpenAPI 요청 절차 ** 
		//1.요청할 주소를 전달해서 java.net.URL 객체 생성하기
		URL requestUrl = new URL(url);
		
		//2.생성된 URL 객체를가지고HttpUrlConnection객체 얻어내기
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();

		//3.요청시 필요한 Header 설정 하기
		// 기본설정에 들어가있음
		urlConn.setRequestMethod("GET");
		
		//4.해당 OpenAPI 서버로 요청 보낸후 입력 스트림을 통해 응답데이터 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText="";
		
		String line;
		
		//System.out.println(urlConn.getInputStream());
		
		while((line=br.readLine())!=null) { // 한 줄씩 읽어올 데이터가 존재하는 동안만 반복
		
			responseText+=line;
			
		}
		//System.out.println(responseText);
		
		/*
	      {
	         "response":
	            {
	               "body":
	            {
	               "totalCount":40,
	               "items":
	                  [
	                      {
	                         "so2Grade":"1",
	                         "coFlag":null,
	                         "khaiValue":"52",
	                         "so2Value":"0.003",
	                         "coValue":"0.5",
	                         "pm10Flag":null,
	                         "o3Grade":"1",
	                         "pm10Value":"15",
	                         "khaiGrade":"2",
	                         "sidoName":"서울",
	                         "no2Flag":null,
	                         "no2Grade":"2",
	                         "o3Flag":null,
	                         "so2Flag":null,
	                         "dataTime":"2023-08-23 14:00",
	                         "coGrade":"1",
	                         "no2Value":"0.032",
	                         "stationName":"정릉로",
	                         "pm10Grade":"1",
	                         "o3Value":"0.029"
	                      },
	                      {
	                         "so2Grade":"1",
	                         "coFlag":null,
	                         "khaiValue":"-",
	                         "so2Value":"0.002",
	                         "coValue":"0.5",
	                         "pm10Flag":null,
	                         "o3Grade":"2",
	                         "pm10Value":"3",
	                         "khaiGrade":null,
	                         "sidoName":"서울",
	                         "no2Flag":null,
	                         "no2Grade":"1",
	                         "o3Flag":null,
	                         "so2Flag":null,
	                         "dataTime":"2023-08-23 14:00",
	                         "coGrade":"1",
	                         "no2Value":"0.013",
	                         "stationName":"도봉구",
	                         "pm10Grade":"1",
	                         "o3Value":"0.039"
	                         }, ...
	                      ]
	               }
	            }
	      }
	      */
		
		
		//JsonObject, JsonArray 이용해서 파싱할 수 있음(gson 라이브러리 필요)
		// 응답 데이터 text를 jsonobject화 시키는 작업(파싱)
		JsonObject totalObj = JsonParser.parseString(responseText).getAsJsonObject();
		//System.out.println(totalObj);
		//5.다 사용한 스트림 객체 반납하기
		
		// response 속성 접근
		JsonObject responseObj = totalObj.getAsJsonObject("response");
		//System.out.println(responseObj);
		
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		//System.out.println(bodyObj);
		
		int totalCount = bodyObj.get("totalCount").getAsInt();
		//System.out.println(totalCount);
		
		// items(JsonArray형태) 속성 접근
		
		JsonArray itemArr = bodyObj.getAsJsonArray("items");
		
		//System.out.println(itemArr);
		
		
		List<Air> list = new ArrayList<>();
		
		for(int i=0; i<itemArr.size(); i++) {
			JsonObject item = itemArr.get(i).getAsJsonObject();
//			System.out.println(item);
//			System.out.println(item.getClass());

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
		
		//System.out.println("list : "+ list);
		
		for(Air air : list) {
			System.out.println(air);
		}
		
		
		br.close();
		urlConn.disconnect();
	}
	
}
