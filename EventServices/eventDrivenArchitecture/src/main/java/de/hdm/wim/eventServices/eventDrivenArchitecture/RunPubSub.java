package de.hdm.wim.eventServices.eventDrivenArchitecture;

import static de.hdm.wim.sharedLib.Constants.PubSub.Topic.TOPIC_1;

import com.google.cloud.ServiceOptions;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import de.hdm.wim.eventServices.eventDrivenArchitecture.helper.PublishHelperOld;
import de.hdm.wim.eventServices.eventDrivenArchitecture.helper.SubscriptionHelper;
import de.hdm.wim.sharedLib.Constants.PubSub;
import de.hdm.wim.sharedLib.pubsub.helper.TopicHelper;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by ben on 24/05/2017.
 */
public class RunPubSub {

	private static final Logger LOGGER 		= Logger.getLogger(RunPubSub.class);
	private static final String PROJECT_ID	= ServiceOptions.getDefaultProjectId();
	private static String TEST_TOPIC 		= PubSub.Topic.TOPIC_1;
	private static String SUBSCRIPTION_ID 	= "test-subscription-asdasdd";


	public static void main(String[] args) throws Exception {

		LOGGER.info("projectId: " + PROJECT_ID);

		// create a new topic
		TopicHelper th = new TopicHelper();
		Topic topic    = th.createTopicIfNotExists(TOPIC_1);

		// create subscription.
		// IMPORTANT: do this before you publish messages, otherwise messages might get lost
		SubscriptionHelper sh 		= new SubscriptionHelper(PROJECT_ID);
		Subscription subscription 	= sh.createSubscriptionIfNotExists(topic.getNameAsTopicName(),
			SUBSCRIPTION_ID);

		// publish messages to a specific topic
		PublishHelperOld phOLD	= new PublishHelperOld();
		List<String> messages 	= Arrays.asList("first message", "second message");
		phOLD.publishMessages(messages, topic.getNameAsTopicName());

		// create a subscriber which uses the subscription to listen to messages of the specified topic
		sh.createSubscriber(subscription.getNameAsSubscriptionName());
	}

}
