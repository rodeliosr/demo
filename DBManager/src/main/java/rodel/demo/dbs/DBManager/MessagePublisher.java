package rodel.demo.dbs.DBManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class MessagePublisher {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${store.queue}")
    private String queueName;

    public boolean sendMessage(String message){
        try {
            jmsTemplate.send(queueName, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    ObjectMessage object = session.createObjectMessage(message);
                    return object;
                }
            });

        } catch (Exception e){
            return false;
        }
        return true;

    }


}
