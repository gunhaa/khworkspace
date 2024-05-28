package implement;

import java.util.HashMap;
import java.util.Map;

public interface IPhone extends HandPhone {
	String SIZE = "71.5 x 146.7 x 7.65 mm";
	
	void printSpec();
	
	@Override
	default Map<String, String> getSpec(){
		Map<String , String> map = new HashMap<>();
		map.put("size", SIZE);
		map.put("model", HandPhone.getUpperName(getModelName()));
		return map;
	}
}
