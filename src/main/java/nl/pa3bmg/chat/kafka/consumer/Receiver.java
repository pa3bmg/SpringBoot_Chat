package nl.pa3bmg.chat.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {
	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
	
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${kafka.topic.helloworld}")
	public void receive(String payload) {
	    LOG.info("received payload='{}'", payload);
	    latch.countDown();
	}
}
