package platform.cloud.fileservice.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import platform.cloud.fileservice.client.feign.FileServiceClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = { FileServiceClient.class })
public class FileServiceClientApplication {

	/**
	 * main
	 * 
	 * @param args main app args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FileServiceClientApplication.class, args);
	}
}
