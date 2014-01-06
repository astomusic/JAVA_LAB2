import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap {
	
	private HashMap<String , ArrayList<String>> map = new HashMap<String , ArrayList<String>>();
	private ArrayList<String> contents;
	
	private static DataMap instance = new DataMap();
	public static DataMap getMap() {
		if(instance == null) {
			instance = new DataMap();
		} //싱글톤 객체 
		return instance;
	}

	public void insertData(String id, String content) {
		if(!map.containsKey(id)) {
			contents = new ArrayList<String>();
			map.put(id, contents);
		}
	
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key =  iterator.next();
			contents = map.get(key);
			contents.add(content);
			map.put(key, contents);
		}
	}

	public void clearDate(String id) {
		contents = new ArrayList<String>();
		map.put(id, contents);
	}

	public String genJsonData(String id) {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"content\":[");
		contents = map.get(id);
		for(String str : contents) {
			sb.append("\"" + str + "\",");
		}
		sb.delete(sb.length()-1, sb.length());
		sb.append("],\"id\":\"" + id + "\"}");
		
		return sb.toString();
	}
	
	
}
