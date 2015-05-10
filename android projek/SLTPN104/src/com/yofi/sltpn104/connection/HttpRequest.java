package com.yofi.sltpn104.connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class HttpRequest {
	static InputStream is = null;
    static String json = "";
	public HttpRequest() {}
	public static String makeHttpRequest(String url, String method,
			List<NameValuePair> params) {
		try {
            switch (method) {
                case "POST": {
                    DataLoader dl = new DataLoader();
                    HttpResponse httpResponse = dl.secureLoadDataPOST(url, params);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    is = httpEntity.getContent();
                    break;
                }
                case "GET": {
                    String paramString = URLEncodedUtils.format(params, "utf-8");
                    url += "?" + paramString;
                    DataLoader dl = new DataLoader();
                    HttpResponse httpResponse = dl.secureLoadData(url);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    is = httpEntity.getContent();
                    break;
                }
                case "NO": {
                    DataLoader dl = new DataLoader();
                    HttpResponse httpResponse = dl.secureLoadData(url);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    is = httpEntity.getContent();
                    break;
                }
            }
			} catch (Exception e) {
				json = ""+e.toString();
			}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			json = ""+e.toString();
		}
		return json;
	}
}
