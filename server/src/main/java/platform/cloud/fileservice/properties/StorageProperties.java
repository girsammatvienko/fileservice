package platform.cloud.fileservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;


@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location;

}
