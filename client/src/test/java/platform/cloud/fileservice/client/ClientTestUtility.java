/**
 * 
 */
package platform.cloud.fileservice.client;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import platform.cloud.fileservice.api.Constants;

public class ClientTestUtility {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final TypeFactory TYPE_FACTORY = MAPPER.getTypeFactory();

	public static final String API = Constants.API_CLIENT_FILECONTROLLER + "/";
	public static final String TEST_FOLDER = "test";
	public static final String TEST_FILE = "sample.txt";
	public static final String FILE_UPLOAD = "upload.txt";
	public static final String FILE_DOWNLOAD = "download.txt";

	/**
	 * @param contentAsString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String[] toStringArray(String contentAsString)
			throws JsonParseException, JsonMappingException, IOException {
		return MAPPER.readValue(contentAsString, String[].class);
	}

	/**
	 * @param contentAsString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<String> toStringList(String contentAsString)
			throws JsonParseException, JsonMappingException, IOException {
		return MAPPER.readValue(contentAsString, TYPE_FACTORY.constructCollectionType(List.class, String.class));
	}

}
