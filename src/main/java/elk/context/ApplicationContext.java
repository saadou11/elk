package elk.context;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public class ApplicationContext {

	private static ApplicationContext context = null;

	private ApplicationContext() {}

	public static ApplicationContext getInstance(){
		if (context == null)
			context = new ApplicationContext();
		
		return context;
	}
	
	public static Settings getElkSettings(){
		Settings settings = Settings.builder().put(
				"path.home", Constants.ELK_HOME_DIR
				).build();
		return settings;
	}
	
	public Node getNode(String clusterName, boolean clientMode){
		Node node = NodeBuilder
				.nodeBuilder()
				.settings(getElkSettings())
				.clusterName(clusterName)
				.client(clientMode).node();
		return node;
	}
	
	public GetResponse getJsonResponse(Client client, String index, String type, String id){
		GetResponse jsonResponse = client.prepareGet(index, type, id).execute().actionGet();
		return jsonResponse;
	}
}
