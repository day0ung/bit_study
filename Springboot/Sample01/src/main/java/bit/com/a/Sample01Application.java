package bit.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "bit.com.a") //spring frame의 servletContext에서 세팅했었던것 공유폴더: bit.com.a >> MapperScan
public class Sample01Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample01Application.class, args);
		//main에서 실행을 해놓고 접근할때, 웹을 따로 켜놓고, 주소창에서 localhost:8090 boot는 model과 controller만 사용한다

	}

}
										/*
										  .    ____         _            __ _ _
										
										  /\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
										 /  \\___ | '_ | '_| | '_ \/ _` | \ \ \ \
										 \  / ___)| |_)| | | | | || (_| |  ) ) ) )
										  \/ |____| .__|_| |_|_| |_\__, | / / / /
										  ========|_|==============|___/=/_/_/_/
										*/