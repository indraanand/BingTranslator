package selenium_mvn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import com.memetix.mst.translate.Translate;

import java.net.URL;
 
public class APITesting {
 
    public static void main(String[] args) {
 
    	
    	  Translate.setClientId("BingTranslator_Indra");
  	    Translate.setClientSecret("G1604PD6u3iFEcptcGUoaWodN7hU23oaVfgkLzKVTEY=");
        String appid = "Your appid needs to be set here";
 
        String translateArrayRequest = "<TranslateArrayRequest>"
                + "<AppId>" + appid + "</AppId>"
                + "<From>fr</From>"
                + "<Texts>"
                + "<string xmlns=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">Ma réponse</string>"
                + "</Texts>"
                + "<To>de</To>"
                + "</TranslateArrayRequest>";
 
        String translateArrayUri = "http://api.microsofttranslator.com/V2/http.svc/TranslateArray";
    
 
        //make TranslateArray HTTP POST method call
        try {
 
            sendURL(translateArrayUri, translateArrayRequest, "POST");
        } catch (Exception e) {
            System.out.println("exception");
            System.out.println(e.getMessage());
        }
 
    }
 
 
private static void sendURL(String theURL, String theArgs, String method) throws Exception {
        URL myURL = new URL(theURL);
        HttpURLConnection httpConn = (HttpURLConnection)myURL.openConnection();
 
        // give it 15 seconds to respond
        httpConn.setReadTimeout(15*1000);
 
        httpConn.setRequestMethod(method);
        httpConn.setRequestProperty("Host", "api.microsofttranslator.com");
        httpConn.setRequestProperty("User-Agent", "");
        httpConn.setRequestProperty("Content-Type", "text/xml");
 
        if (method.equalsIgnoreCase("POST")) {
            httpConn.setRequestProperty("Content-Length", Integer.toString(theArgs.getBytes("UTF-8").length));
            httpConn.setRequestProperty("Accept-Language", "en_US,en");
            httpConn.setDoOutput(true);
        }
        httpConn.setDoInput(true);
 
        //Send request
        if (method.equalsIgnoreCase("POST")) {
            httpConn.getOutputStream().write(theArgs.getBytes("UTF-8"));
        }
       
 
        // read the output from the server
        BufferedReader reader;
        String line = null;
         System.out.println("Response code:"+httpConn.getResponseCode());
        if (httpConn.getResponseCode() != 200) {
            reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        }
 
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
       
        reader.close();
 
        if (httpConn != null)
            httpConn.disconnect();
    }
 
}




