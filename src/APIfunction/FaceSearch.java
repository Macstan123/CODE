package APIfunction;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class FaceSearch {
	public static String str;
	public static int confidence=0;
	public static String face_token="none";
	public FaceSearch(File file) throws Exception{
		BusinessFunc bf=new BusinessFunc();
		byte[] buff = bf.getBytesFromFile(file);
		String url = "https://api-cn.faceplusplus.com/facepp/v3/search";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", "m8CtzYzmf_Vv9qWlwM2ji7oClmB4P6ZA");
        map.put("api_secret", "Rc8sHqVe9oXzRgC4a_wZNCYIlRHMDRrt");
       	map.put("faceset_token", "16755eadf9420efde73c9a15fcff04da");	
        byteMap.put("image_file", buff);
        try{
            byte[] bacd = bf.post(url, map, byteMap);
            str= new String(bacd);
        }catch (Exception e) {
        	e.printStackTrace();
		}
        try
        {
        	JSONObject jsonObject = new JSONObject(str);
        	String result=null;
        	if(jsonObject.has("results")) {
        		result = jsonObject.getString("results"); 
                JSONArray jsonarray=new JSONArray(result);
                JSONObject j1 = jsonarray.getJSONObject(0);
                face_token= j1.getString("face_token");
                confidence=	j1.getInt("confidence");
                System.out.println("confidence: " + confidence);
        	}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}	
	public int getcon() {
		return confidence;
	}
	public String gettoken() {
		return face_token;
	}
}