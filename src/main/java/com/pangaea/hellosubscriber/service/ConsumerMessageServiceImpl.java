package com.pangaea.hellosubscriber.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ConsumerMessageServiceImpl implements ConsumerMessageService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerMessageServiceImpl.class);

    @Override
    public void processMessage(Object data) {
        logger.info("Messaged retrieved from server: "+data.toString());
    }
}
