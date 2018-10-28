3 import java.io.BufferedReader;
4 import java.io.IOException;
5 import java.io.InputStream;
6 import java.io.InputStreamReader;
7 import java.net.HttpURLConnection;
8 import java.net.URL;
9 import java.util.regex.Matcher;
10 import java.util.regex.Pattern;
11
17 public class getTodayEvent{
18
24     private static String httpRequest(String requestUrl) {
25
26         StringBuffer buffer = null;
27         BufferedReader bufferedReader = null;
28         InputStreamReader inputStreamReader = null;
29         InputStream inputStream = null;
30         HttpURLConnection httpUrlConn = null;
31
32         try {
34             URL url = new URL(requestUrl);
35             httpUrlConn = (HttpURLConnection) url.openConnection();
36             httpUrlConn.setDoInput(true);
37             httpUrlConn.setRequestMethod("GET");
38
40             inputStream = httpUrlConn.getInputStream();
41             inputStreamReader = new InputStreamReader(inputStream, "utf-8");
42             bufferedReader = new BufferedReader(inputStreamReader);
43
4
45             buffer = new StringBuffer();
46             String str = null;
47             while ((str = bufferedReader.readLine()) != null) {
48                 buffer.append(str);
49             }
50
51         } catch (Exception e) {
52             e.printStackTrace();
53         }  finally {
55             if(bufferedReader != null) {
56                 try {
57                     bufferedReader.close();
58                 } catch (IOException e) {
59                     e.printStackTrace();
60                 }
61             }
62             if(inputStreamReader != null){
63                 try {
64                     inputStreamReader.close();
65                 } catch (IOException e) {
66                     e.printStackTrace();
67                 }
68             }
69             if(inputStream != null){
70                 try {
71                     inputStream.close();
72                 } catch (IOException e) {
73                     e.printStackTrace();
74                 }
75             }
76             if(httpUrlConn != null){
77                 httpUrlConn.disconnect();
78             }
79         }
80         return buffer.toString();
81     }
82
83     /**
85      * @param html    String
86      * @return         String
87      */
88     private static String htmlFiter(String html) {
89
90         StringBuffer buffer = new StringBuffer();
91         //......fill in ......
           //.......
138
139         return buffer.toString();
140     }
141
142     /**
144      * @return
145      */
146     public static String getTodayTemperatureInfo() {
148         String html = httpRequest("http://events.cuny.edu");
150         String result = htmlFiter(html);
151
152         return result;
153     }
154
155     /**
157      * @param args
158      */
159     public static void main(String[] args) {
160         String info = getTodayEvent();
161         System.out.println(info);
162     }
163 }
