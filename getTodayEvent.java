import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getTodayEvent{

private static String httpRequest(String requestUrl) {

     StringBuffer buffer = null;
     BufferedReader bufferedReader = null;
     InputStreamReader inputStreamReader = null;
     InputStream inputStream = null;
     HttpURLConnection httpUrlConn = null;

     try {
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");

            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
           }

           } catch (Exception e) {
             e.printStackTrace();
           }  finally {
               if(bufferedReader != null) {
               try {
                     bufferedReader.close();
                   } catch (IOException e) {
                     e.printStackTrace();
                   }
               }
               if(inputStreamReader != null){
               try {
                     inputStreamReader.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if(inputStream != null){
                   try {
                       inputStream.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if(httpUrlConn != null){
                   httpUrlConn.disconnect();
               }
           }
           return buffer.toString();
       }

       /**
        * @param html    String
        * @return         String
        */
       private static String htmlFiter(String html) {

           StringBuffer buffer = new StringBuffer();
           //......fill in ......
           //.......
  
         return buffer.toString();
    }

     /**
      * @return
      */
     public static String getTodayTemperatureInfo() {
         String html = httpRequest("http://events.cuny.edu");
         String result = htmlFiter(html);

         return result;
     }

     /**
      * @param args
      */
     public static void main(String[] args) {
         String info = getTodayEvent();
         System.out.println(info);
     }
 }
