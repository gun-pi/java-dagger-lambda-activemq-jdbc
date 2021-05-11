package org.example.untitled;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.example.untitled.components.DaggerComponent;
import org.example.untitled.db.DocumentDao;
import org.example.untitled.db.DocumentEntity;
import org.example.untitled.mq.Mq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class Handler implements RequestHandler<String, String> {

    private static final Logger LOG = LoggerFactory.getLogger(Handler.class);

    @Inject
    DocumentDao documentDao;

    @Inject
    Mq mq;

    public Handler() {
        DaggerComponent.builder().build().injectInto(this);
    }

    @Override
    public String handleRequest(final String input, final Context context) {
        LOG.info("Request handler is starting with input string: " + input);

        String message;
        try {
            mq.sendMessage(input);
            message = mq.receiveMessage();
        } catch (Exception e) {
            LOG.error("Exception in handleRequest method occurred during JMS interaction: " + e);
            throw new RuntimeException(e);
        }

        Long id;
        try {
            id = documentDao.save(new DocumentEntity(message));
        } catch (Exception e) {
            LOG.error("Exception in handleRequest method occurred during Database interaction: " + e);
            throw new RuntimeException(e);
        }

        LOG.info("Request handler with id " + id + " is finishing with message: " + message);
        return id.toString();
    }
}
