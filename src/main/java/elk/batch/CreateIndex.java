package elk.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import elk.context.ApplicationContext;
import elk.context.Constants;
import elk.context.Utils;

public class CreateIndex {

	public static void main(String[] args) {
		
		ApplicationContext context = ApplicationContext.getInstance();
		
		Node node = context.getNode(Constants.CLUSTER_NAME, true);

		Client client = node.client();

		HashMap<String, Object> jsonDocument = new HashMap<String, Object>();
		
		jsonDocument.put("title", (String) "ElasticSearch: Java API");
		jsonDocument.put("content", (String) "ElasticSearch provides the Java API, all operations can be executed asynchronously using a client object.");
		jsonDocument.put("postDate", (Date) new Date());
		jsonDocument.put("tags", new String[] { "elasticsearch" });
		jsonDocument.put("author", "Hüseyin Akdoğan");
		
		
		Utils.createIndex(client, "articles", "article", "1", jsonDocument);

		//node.close();

		GetResponse response = context.getJsonResponse(client, "articles", "article", "1");

		Map<String, Object> source = response.getSource();

		System.out.println("------------------------------");

		System.out.println("Index: " + response.getIndex());

		System.out.println("Type: " + response.getType());

		System.out.println("Id: " + response.getId());

		System.out.println("Version: " + response.getVersion());

		for(Entry<String, Object> entry : source.entrySet())
			System.out.println(entry.getKey()+" => "+entry.getValue());

		System.out.println("------------------------------");
	}

}
