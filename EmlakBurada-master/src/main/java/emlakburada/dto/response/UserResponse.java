package emlakburada.dto.response;

import lombok.Data;

@Data
public class UserResponse {

	private int userId;
	private String kullaniciTipi;
	private String isim;
	private String email;
	private String fotograf;
	private String biyografi;
}
