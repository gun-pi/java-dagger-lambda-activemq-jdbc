import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
/*import org.example.untitled.db.DocumentDao;
import org.example.untitled.db.DocumentEntity;*/
import org.example.untitled.Handler;
import org.example.untitled.db.DocumentDao;
import org.example.untitled.db.DocumentEntity;
import org.example.untitled.mq.Mq;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.jms.JMSException;
import java.sql.SQLException;

public class HandlerTest {



    @Test
    void test() {

        Handler handler = new Handler();
        handler.handleRequest("test", null);


        /*String input = "test";
        String message = input;
        *//*try {
            mq.sendMessage(input);
            message = mq.receiveMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }*//*

        System.out.println(message);

        Long id = null;
        try {
            id = documentDao.save(new DocumentEntity(message));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(id + ": here I am");*/
    }
}
