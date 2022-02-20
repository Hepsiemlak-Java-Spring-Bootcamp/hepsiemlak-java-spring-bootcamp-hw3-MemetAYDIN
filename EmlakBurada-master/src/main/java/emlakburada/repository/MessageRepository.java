package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.model.User;
import lombok.Data;

@Data
@Repository
public class MessageRepository {

	@Autowired
	Message message;
	
	
	List<MessageResponse> messageList;
	List<Message> allMessageList;
	
	
	public List<MessageResponse> getAllMessage(){
		
		return messageList;
		
	}
	
	public List<MessageResponse> createMessage(MessageResponse message) {
		messageList.add(message);
		return messageList;
	}
	
	public MessageResponse findByIdMessage(int id) {
		
		MessageResponse messageResponseId=new MessageResponse();
		
		for(MessageResponse msg:messageList) {
			if(msg.getMessageId()==id)
			{
				System.out.println(msg.getMessageId()+" id'li"
						+msg.getBaslik()+" "+msg.getIcerigi());
				messageResponseId=msg;
			}
			
		}
		return messageResponseId;
	}
	
	public void listAllMassege(User sender, User client, Message message) {
		sender.setMesajKutusu(new ArrayList<>());
		
		message.setGonderici(sender);
		sender.getMesajKutusu().add(message);
		

		
		System.out.println(sender.getIsim()+" tarafından "+client.getIsim()+" gönderildi\n");
		for(Message msSender:sender.getMesajKutusu()) {
				if(msSender.getOkunduguTarihi()!=null) {
					System.out.println(
							"Mesaj basligi        :\t"+msSender.getBaslik()+"\n"
							+"Mesaj içeriği       :\t"+msSender.getIcerigi()+" \n"
							+"Mesaj tarihi        :\t"+msSender.getGonderilenTarih()+"\n"
							+"Okunma tarihi       :\t"+msSender.getOkunduguTarihi()+" tarihinde okundu \n"
							);
				}else {
					System.out.println(
							"Mesaj basligi        :\t"+msSender.getBaslik()+"\n"
							+"Mesaj içeriği       :\t"+msSender.getIcerigi()+" \n"
							+"Mesaj tarihi        :\t"+msSender.getGonderilenTarih()+"\n"
							+"Okunma tarihi       :\t"+msSender.getOkunduguTarihi()+" daha okunmadı \n"
							);
				}

		}
		
	}
	
	
	
}
