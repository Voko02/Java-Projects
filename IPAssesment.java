package beans;
import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;

public class IPAssesment extends Object implements Serializable{
	
	public void assessIPAddress (String ipAddress) {
		System.out.println("Assess IP Address: " + ipAddress);
		GetMethod get = new GetMethod ("https://isc.sans.edu/api.ip/" + ipAddress);
		try {
			get.setRequestHeader("Content-type", "text/xml; charset=IOS-8859-1");
			HttpClient client = new HttpClient();
			int code = client.executeMethod(get);
			System.out.println(code);
			String result = get.getResponseBodyAsString();
			System.out.println(result);
		}
		catch (IOException ioe) { ioe.printStackTrace();}
		
	}
	public static void main(String[] args) {
		System.out.println("Hello");
		IPAssesment test = new IPAssesment();
		test.assessIPAddress("105.53.27.28");
	}

}

/* 
1.Four types of methods: public, private, protected, default.
2. Return type: void,
 return (int, double, String, Boolean,etc.)
3. Name of Method For example: authenticateUser(), checkCredentials(), sendPasscode(), assessIPAdress()
4.Parameters (Optional): Formal Parameter (String username, String password) 
Actual Parameter checkCredentials("jdoe", "test1234")
*/