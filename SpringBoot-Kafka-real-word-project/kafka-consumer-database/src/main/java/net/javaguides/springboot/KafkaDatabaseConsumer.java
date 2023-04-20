package net.javaguides.springboot;

import net.javaguides.springboot.entity.WikimediaData;
import net.javaguides.springboot.repository.WikiMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    WikimediaData wiki = new WikimediaData();


    private WikiMediaRepository dataRepository;

    public KafkaDatabaseConsumer(WikiMediaRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
        public void consume(String eventMessage){
        LOGGER.info(String.format("Message message Reecived -> %s", eventMessage));
        wiki.setWikiEventData(eventMessage);
        dataRepository.save(wiki);
     }
}
