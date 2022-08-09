package com.acs.gcp.api;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.SubscriptionAdminSettings;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.TopicName;

public class CreateSubscription {

	/**
	 * <p> This method is to create a subscription for a topic.
	 * 
	 */
	public static void main(String[] args) {
		String PROJECT_ID = "PROJECT_ID_SERVICE_ACCOUNT";
		String SUBSCRIPTION_NAME = "SUBSCRIPTION_NAME";
		String TOPIC = "study";
		
		FixedCredentialsProvider credentialsProvider;
		try {
			// Make sure you placed your service-account.json in the /src/main/resources			
			Resource resource = new ClassPathResource("/service-account.json", CreateSubscription.class);
			InputStream inputStream = resource.getInputStream();
			credentialsProvider = FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(inputStream));

			ProjectSubscriptionName projSubscription = ProjectSubscriptionName.of(PROJECT_ID, SUBSCRIPTION_NAME);
			TopicName projTopic = TopicName.ofProjectTopicName(PROJECT_ID, TOPIC);
			SubscriptionAdminSettings subscriptionAdminSettings = SubscriptionAdminSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
			SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings);
			subscriptionAdminClient.createSubscription(projSubscription, projTopic, PushConfig.getDefaultInstance(), 0);
			
			System.out.println("!!! Subscription created !!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
