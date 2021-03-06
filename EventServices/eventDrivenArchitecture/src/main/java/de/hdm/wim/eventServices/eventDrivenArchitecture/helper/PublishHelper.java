package de.hdm.wim.eventServices.eventDrivenArchitecture.helper;

/**
 * Created by ben on 5/06/2017.
 */
public class PublishHelper {

/*	private static String ENDPOINT		= LOCAL_PUBLISH_ENDPOINT;
	private static final Logger LOGGER 	= Logger.getLogger(PublishHelper.class);

	*//**
	 * Instantiates a new Publish helper.
	 *//*
	public PublishHelper(){	}

	*//**
	 * Instantiates a new PublishHelper.
	 *
	 * @param request the request
	 *//*
	public PublishHelper(String request){
		this.ENDPOINT = request;
	}

	*//**
	 * Publish a message
	 *
	 * @param message the message
	 * @throws Exception the exception
	 *//*
	public void Publish(Message message) throws Exception{

		Map<String,Object> params = new LinkedHashMap<>();
		String jsonAttributes 	  = new GsonBuilder().create()
												.toJson(message.getAttributes(), Map.class);

		params.put(RequestParameters.TOPIC, 		message.getTopic());
		params.put(RequestParameters.PAYLOAD, 		message.getData());
		params.put(RequestParameters.ATTRIBUTES,	jsonAttributes);

		sendPost(params);
	}

	private static void sendPost(Map<String,Object> params) throws Exception{
		URL url;
		HttpURLConnection conn;

		//build request url
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append("&");

			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append("=");
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}

		LOGGER.info("postData: " + postData);

		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		// set up connection
		url  = new URL(ENDPOINT);
		conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",   "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);

		// send request
		conn.getOutputStream().write(postDataBytes);

		// get response
		LOGGER.info("ResponseCode: " 	+ conn.getResponseCode());
		LOGGER.info("ResponseMessage: " + conn.getResponseMessage());
	}*/
}
