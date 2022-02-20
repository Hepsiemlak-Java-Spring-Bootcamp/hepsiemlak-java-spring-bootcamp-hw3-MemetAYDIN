package emlakburada.feigntclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;

@FeignClient(name="banner", url="http://localhost:8081")
public interface BannerFeignClient {
	
	@PostMapping(value="/banner")
	public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request);

}
