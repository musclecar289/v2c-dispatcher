package edu.uco.cs.v2c.dispatcher.net.restful;

import org.json.JSONObject;

import edu.uco.cs.v2c.dispatcher.net.APIVersion;
import edu.uco.cs.v2c.dispatcher.net.websocket.RegisteredSession;
import edu.uco.cs.v2c.dispatcher.net.websocket.WebSocketHandler;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.jetty.websocket.api.Session;


public class RegisteredSessionsEndpoint extends Endpoint {
	private static List<String> moduleNames = null;
	//Instantiates the endpoint
	public RegisteredSessionsEndpoint() {
		super("/registeredsessions",APIVersion.VERSION_1, HTTPMethod.GET);
	}
	
	@Override public JSONObject doEndpointTask(Request req, Response res) throws EndpointException{
		return new JSONObject()
		    .put("Connected Applications", WebSocketHandler.getSessionMap().getSessionsByName().keySet());
	}
	
}
