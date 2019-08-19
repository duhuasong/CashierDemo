package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.dom4j.*;

import com.google.gson.Gson;

import paydll.CallDll;

public class SimpleData extends RetrunData {
	private SortedMap<String, String> map;

	public SimpleData() {
		// TODO Auto-generated constructor stub
		setMap(new TreeMap<String, String>());
	}

	@Override
	public int save(String data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String data) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public String select(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 public  Map<String, String> parse (String xml){ 
    	Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Map<String, String> map = new HashMap<String ,String>();
        if(doc == null) 
            return map; 
        Element root = doc.getRootElement(); 
        for (Iterator  iterator = root.elementIterator(); iterator.hasNext();) { 
            Element e = (Element) iterator.next(); 
            List  list = e.elements(); 
            map.put(e.getName(), e.getText()); 
        } 
        return map;
	}
	public SortedMap<String, String> getMap() {
		return map;
	}

	public void setMap(SortedMap<String, String> map) {
		this.map = map;
	}
	
	public static void main(String[] args) {
		SimpleData simpleData  = new SimpleData();
		CallDll callDll = new CallDll();
		String xml = callDll.pay("1", "1", "2");
		Map  map = simpleData.parse(xml);
		System.out.print(new Gson().toJson(map));
	}

}
