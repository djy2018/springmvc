package com.wisely.highlight_springmvc4.web.sso_cross_domain.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by dujiayong on 2017/2/16.
 */
public class Demo2Tool {

    public static String doGet(String url,Map<String,String> map){
        StringBuffer stringBuffer = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        try{
            StringBuffer s_b = new StringBuffer(url).append("?");
            for(Map.Entry<String,String> entry:map.entrySet()){
                s_b.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = s_b.substring(0,s_b.length()-1);
            URL urls = new URL(url);
            httpURLConnection = (HttpURLConnection)urls.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null){
                stringBuffer.append(temp);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return stringBuffer.toString();
    }
}
