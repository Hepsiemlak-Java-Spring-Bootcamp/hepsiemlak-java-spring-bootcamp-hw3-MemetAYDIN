package emlakburada.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.config.ActiveMqConfig;
import emlakburada.service.EmailMessage;

@Service
public class ActiveMqService implements QueueService{

	@Autowired
	private AmqpTemplate activeTemplate;
	
	@Autowired
	private ActiveMqConfig activeConfig;
	
	
	@Override
	public void sendMessage(EmailMessage email) {
		
		
		activeTemplate.convertAndSend(activeConfig.getBROKER_URL(), 
				activeConfig.getBROKER_USERNAME(),email);
		
	}

}
