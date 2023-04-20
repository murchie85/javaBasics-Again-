# SQS LISTENER SDK

In this code snippet, `Spring Boot` is being used along with the **AWS Java SDK for Simple Queue Service (SQS)**. Here's a brief explanation of the code and a usage example with comments.

Explanation:

**@Autowired**: This is an annotation provided by Spring Framework, which is used for dependency injection. It automatically injects the required dependency (in this case, an implementation of SQSMessageListener<Message>) when the application starts up.

**SQSMessageListener<Message>**: This is an interface representing a message listener for Amazon SQS. It allows you to process messages received from an SQS queue. In this case, the listener is configured to handle messages of type Message. You would need to create an implementation of this interface to define how messages should be processed.

Usage example with comments

```java
import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.cloud.aws.messaging.listener.SQSMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

    @Autowired
    private AmazonSQSAsync amazonSQSAsync;

    // Define a bean for the SQSMessageListener implementation
    @Bean
    public SQSMessageListener<Message> messageListener() {
        return new MyMessageListener();
    }

    // Configure the SimpleMessageListenerContainer with the listener implementation
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setAmazonSqs(amazonSQSAsync);
        container.setMessageListener(messageListener());
        container.setQueueUrls("https://sqs.us-west-2.amazonaws.com/123456789012/my-queue");
        return container;
    }

    // Your custom implementation of SQSMessageListener
    private static class MyMessageListener implements SQSMessageListener<Message> {
        @Override
        public void onMessage(Message message) {
            // Process the received message
            System.out.println("Received message: " + message.getBody());
        }
    }
}

```

In this example, we've created a Spring configuration class (`SQSConfig`) that configures an `SQSMessageListener` and the `SimpleMessageListenerContainer`. The MyMessageListener class implements the `SQSMessageListener<Message>` interface, and its onMessage() method is responsible for processing the messages received from the SQS queue. The `simpleMessageListenerContainer()` method sets up the container with the AmazonSQS client, the listener implementation, and the URL of the SQS queue.  


The SimpleMessageListenerContainer is initialized when the Spring Boot application starts up. It starts polling for messages automatically and keeps doing so until the application is shut down. The container continuously polls for messages, and once a message is received, it triggers the **onMessage()** method of the **SQSMessageListener<Message>** implementation.

The polling frequency and behavior can be configured by setting various properties of the **SimpleMessageListenerContainer**. Here are some of the properties that control the polling behavior:

1. **waitTimeOut**: The duration (in seconds) the AmazonSQS.receiveMessage() call waits for a message to arrive in the queue before returning. The default value is 20 seconds. You can set it to a lower value if you want to poll more frequently or a higher value if you want to poll less frequently.

2. **maxNumberOfMessages**: The maximum number of messages to be retrieved in a single poll. The default value is 10. You can increase this value if you want to process more messages in a single poll or decrease it if you want to process fewer messages.

To set these properties, you can modify the SimpleMessageListenerContainer configuration in the SQSConfig class like this:

```java
@Bean
public SimpleMessageListenerContainer simpleMessageListenerContainer() {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setAmazonSqs(amazonSQSAsync);
    container.setMessageListener(messageListener());
    container.setQueueUrls("https://sqs.us-west-2.amazonaws.com/123456789012/my-queue");

    // Set polling properties
    container.setWaitTimeOut(10); // Set wait time out to 10 seconds
    container.setMaxNumberOfMessages(5); // Set max number of messages to 5

    return container;
}

```
In this example, the **waitTimeOut** property is set to 10 seconds, so the **AmazonSQS.receiveMessage()** call will wait for 10 seconds before returning if there are no messages in the queue. The **maxNumberOfMessages** property is set to 5, so up to 5 messages will be retrieved in a single poll.