package elk.batch;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import elk.context.ApplicationContext;
import elk.context.Constants;
import elk.context.Utils;

public class DeleteIndex {

	public static void main(String[] args) {
		
		ApplicationContext context = ApplicationContext.getInstance();
		
		Node node = context.getNode(Constants.CLUSTER_NAME, true);

		Client client = node.client();

		Utils.deleteDocument(client, "articles", "article", "1");

	}

}
