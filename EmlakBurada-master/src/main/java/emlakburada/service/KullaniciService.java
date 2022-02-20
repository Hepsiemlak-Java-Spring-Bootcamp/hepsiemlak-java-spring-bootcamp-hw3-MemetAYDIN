package emlakburada.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;

@Service
public class KullaniciService {


	@Autowired
	User user;
	
	
	List<UserResponse> userList;
	List<User> allUserList;
	
	
	public List<UserResponse> getAllUser(){
		
		return userList;
		
	}
	
	public List<UserResponse> createUser(UserResponse user) {
		userList.add(user);
		return userList;
	}
	
	public UserResponse findByIdUser(int id) {
		
		UserResponse userResponseId=new UserResponse();
		
		for(UserResponse usr:userList) {
			if(usr.getUserId()==id)
			{
				System.out.println(usr.getIsim()+" id'li"
						+usr.getBiyografi()+" "+usr.getFotograf()+" "+usr.getEmail());
				userResponseId=usr;
			}
			
		}
		return userResponseId;
	}
	

}
