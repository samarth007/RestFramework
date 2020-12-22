package RESTApi.RestFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	RequestSpecification reqspec;
	
	public RequestSpecification request(String value) throws IOException {
		
		PrintStream ps = new PrintStream(new FileOutputStream("log.txt"));
		  reqspec= new RequestSpecBuilder().setBaseUri(geturl("baseurl"))
				  .addFilter(RequestLoggingFilter.logRequestTo(ps))
				  .addFilter(ResponseLoggingFilter.logResponseTo(ps))
				   .addQueryParam("key", "qaclick123").addQueryParam("place_id", value)
				   .setContentType(ContentType.JSON).build();
		
        return reqspec;		
	}
	
	public  String geturl(String key) throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\RestFramework\\src\\test\\java\\RESTApi\\RestFramework\\file.properties");
		p.load(fis);
	    return p.getProperty(key);	
	}
	
}
