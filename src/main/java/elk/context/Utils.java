package elk.context;

import java.util.HashMap;
import java.util.Map.Entry;

import org.elasticsearch.client.Client;


public class Utils {

	public static HashMap<String, Object> putJsonDocument(HashMap<String, Object> document){
		
		HashMap<String, Object> jsonDocument = new HashMap<String, Object>();
		
		for(Entry<String, Object> doc : document.entrySet())
			jsonDocument.put(doc.getKey(), doc.getValue());

		return jsonDocument;
	}
	
	public static void createIndex(Client client, String index, String type, String id, HashMap<String, Object> jsonDocument){
		client.prepareIndex(index, type, id)
		.setSource(Utils.putJsonDocument(jsonDocument)).execute().actionGet();
	}
	
	
	public static void deleteDocument(Client client, String index, String type, String id){
        client.prepareDelete(index, type, id).execute().actionGet();
    }

}
