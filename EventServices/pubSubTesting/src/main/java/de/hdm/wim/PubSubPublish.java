package de.hdm.wim;

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import de.hdm.wim.sharedLib.Constants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;

/**
 * Created by ben on 4/06/2017.
 */
@WebServlet(name = "Publish with PubSub", value = "/pubsub/publish")
public class PubSubPublish extends HttpServlet {

	private Publisher publisher;

	public PubSubPublish() { }

	PubSubPublish(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		Publisher publisher = this.publisher;
		try {

			// create a publisher on the topic
			String topicId = req.getParameter("topic");
			if(topicId.isEmpty()) // default topic
				topicId = Constants.Topic.PUSH_TEST;

			if (publisher == null) {
				publisher = Publisher.defaultBuilder(
					TopicName.create(ServiceOptions.getDefaultProjectId(), topicId))
					.build();
			}

			// construct a pubsub message from the payload
			final String payload = req.getParameter("payload");
			PubsubMessage pubsubMessage =
				PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(payload)).build();

			publisher.publish(pubsubMessage);

			// redirect to home page
			resp.sendRedirect("/");
		} catch (Exception e) {
			resp.sendError(HttpStatus.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}