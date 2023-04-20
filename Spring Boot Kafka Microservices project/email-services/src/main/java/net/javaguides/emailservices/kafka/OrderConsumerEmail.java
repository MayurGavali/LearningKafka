package net.javaguides.emailservices.kafka;
import net.javaguides.basedomain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerEmail {

    private static final Logger LOGGER =  LoggerFactory.getLogger(OrderConsumerEmail.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
             groupId = "spring.kafka.consumer.group-id")
    public void consume(OrderEvent orderEvent){
    LOGGER.info(String.format("Order Event received in Email services %s", orderEvent.toString()));
    // send email to send to customer


    }
}
