package implement;

import java.util.HashMap;
import java.util.Map;

public interface HandPhone {

	String getModelName();


	default Map<String, String> getSpec(){
		Map<String, String> map = new HashMap<>();
		map.put("model", getModelName());
		return map;
	}


	default void printSpec() {
		System.out.println("model name : " + getUpperName(getModelName()));
	}
	
	static String getUpperName(String name) {
		return name.toUpperCase();
	}
	
}
