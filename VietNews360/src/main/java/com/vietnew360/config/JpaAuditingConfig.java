package com.vietnew360.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration // Đánh dấu class này là một file cấu hình Spring
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
//"auditorAwareRef":là một annotation được sử dụng để bật tính năng JPA Auditing trong ứng dụng Spring. Hãy xem các thông số trong annotation này:
//sử dụng để chỉ định tên của bean kiểu AuditorAware. Trong trường hợp này, giá trị của auditorAwareRef là "auditorProvider",
// nghĩa là sử dụng bean có tên "auditorProvider" để cung cấp thông tin người kiểm tra hiện tại.
public class JpaAuditingConfig {
	@Bean
	public AuditorAware<String> auditorProvider(){
		return new AuditorAwareImpl();
	}
	public static class AuditorAwareImpl implements AuditorAware<String>{

		@Override
		public String getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication == null) {
				return null;
			}
			return authentication.getName();
		}
		
	}


	
}
