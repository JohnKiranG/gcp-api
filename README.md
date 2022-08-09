# gcp-api
An API to create a pubsub subscription. It is a simple maven project.

## Prerequisites:
- Service-account.json file (It should be got from GCP account).
- Choose your Subscription name.
- Choose the topic for which the subscription is to be generated.

### How to Use:

- Clone/Download this project.
- Import as maven project.
- Put your service-account.json in src/main/resources.
- Update subscription name, project id, and topic in the CreateSubscription.java file.
- Run as a Java application.
- If no issues, you will get a "!!! Subscription created !!!" message in the console.
- Once a subscription is created, you can verify by rerunning the app, so that, it will give a "Subscription already exists" error.
