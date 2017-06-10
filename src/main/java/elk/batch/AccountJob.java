package elk.batch;

import java.util.StringTokenizer;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;

import elk.context.ApplicationContext;
import elk.context.Constants;

public class AccountJob {

	public static void main(String[] args) {
		ApplicationContext context = ApplicationContext.getInstance();
		
		Client client = context.getNode(Constants.CLUSTER_NAME, true).client();
		
		//client.
		GetResponse json = context.getJsonResponse(client, "bank", "account", "1");
		String jsonSource = json.getSourceAsString();
		
		StringTokenizer str = new StringTokenizer(jsonSource.substring(1, jsonSource.length()-2), ",");
		while(str.hasMoreElements())
			System.out.println(str.nextToken());
		
		

	}

}
