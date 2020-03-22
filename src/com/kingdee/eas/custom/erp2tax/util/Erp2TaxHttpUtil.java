package com.kingdee.eas.custom.erp2tax.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * ����http���ʵĻ�����
 */
public class Erp2TaxHttpUtil {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static final String METHOD_POST = "POST";

    private static final String METHOD_GET = "GET";

    private static final int CONNECTTIMEOUT = 5000;

    private static final int READTIMEOUT = 5000;

    private static class DefaultTrustManager implements X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] cert, String oauthType)
                throws java.security.cert.CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] cert, String oauthType)
                throws java.security.cert.CertificateException {
        }
    }

    private static HttpURLConnection getConnection(URL url, String method)
            throws IOException {

        HttpURLConnection conn;
        if ("https".equals(url.getProtocol())) {
            SSLContext ctx;
            try {
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() },
                        new SecureRandom());
            } catch (Exception e) {
                throw new IOException(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;// Ĭ�϶���֤ͨ��
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("User-Agent", "einv-restclient-java-3.0");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        return conn;

    }

    /**
     * ͨ��get��������
     * 
     * @param url ���ʵ�url��ַ
     * @param urlParams ������Ҫ�Ĳ���
     * @return ����������Ӧ������
     * @throws IOException
     */
    public static String doGet(String url, Map<String, String> urlParams)
            throws IOException {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("The parameter 'url' can not be null or blank.");
        }
        url += buildQuery(urlParams, DEFAULT_CHARSET);
        HttpURLConnection conn = getConnection(new URL(url), METHOD_GET);
        return getResponseAsString(conn);
    }

    /**
     * 
     * @param url api�����Ȩ·��url��ַ
     * @param urlParams ����Ĳ���
     * @param requestJson ������
     * @return ������Ӧ
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> urlParams, String requestJson) throws IOException {
        return doPost(url, urlParams, requestJson, CONNECTTIMEOUT, READTIMEOUT);
    }

    /**
     *
     * ͨ��post������������
     *
     * @param url �����url��ַ
     * @param urlParams ����Ĳ���
     * @param requestJson ������
     * @param connectTimeOut �������ӹ���ʱ��
     * @param readTimeOut �����ȡ����ʱ��
     * @return ������Ӧ
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> urlParams, String requestJson,
            int connectTimeOut, int readTimeOut) throws IOException {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("The parameter 'url' can not be null or blank.");
        }
        url += buildQuery(urlParams, DEFAULT_CHARSET);
        HttpURLConnection conn = getConnection(new URL(url), METHOD_POST);
        conn.setConnectTimeout(connectTimeOut);
        conn.setReadTimeout(readTimeOut);
        conn.getOutputStream().write(requestJson.getBytes(DEFAULT_CHARSET));
        return getResponseAsString(conn);
    }

    /**
     * 
     * @param params �������
     * @return ����query
     */
    public static String buildQuery(Map<String, String> params, String charset) throws UnsupportedEncodingException {
        if (params == null || params.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Entry<String, String> entry : params.entrySet()) {
            if (first) {
                sb.append("?");
                first = false;
            } else {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            if (areNotEmpty(key, value)) {
                sb.append(key).append("=").append(URLEncoder.encode(value, charset));
            }
        }
        return sb.toString();

    }

    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), DEFAULT_CHARSET);
        } else {
            String msg = getStreamAsString(es, DEFAULT_CHARSET);
            if (isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + " : " + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }

    }

    private static String getStreamAsString(InputStream input, String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(input, charset));
            String str;
            while ((str = bf.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } finally {
            if (bf != null) {
                bf.close();
            }
        }

    }

    /**
     * �ж��ַ���Ϊ��
     *
     * @param str �ַ�����Ϣ
     * @return true or false
     */
    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * �ж��ַ����飬��Ϊ��
     *
     * @param values �ַ�����
     * @return true or false
     */
    public static boolean areNotEmpty(String... values) {
        if (values == null || values.length == 0) {
            return false;
        }

        for (String value : values) {
            if (isEmpty(value)) {
                return false;
            }
        }
        return true;
    }
    
	
	 // ����������ʾ��Ӧ����
   public static String httpsPost(String keyStorePath,String keyStoreAbner,String keyStorePassWord,String appCode,String url,String cmdName,String jsonStr) throws Exception {
       String encode="UTF-8";
//       jsonStr="{\"invoice\":{\"customerName\":\"�������ۣ���������\",\"drawer\":\"�Ŷ���\",\"items\":[{\"amount\":\"2499.00\",\"code\":\"1TE42R6TCNEV\",\"imei\":\"1TE42R6TCNEV\",\"itemRemark\":\"\",\"name\":\"Z�ʵ�()\",\"price\":\"2499.00\",\"quantity\":\"1\",\"taxRate\":\"0.17\",\"type\":\"0\",\"uom\":\"PC\"}],\"remark\":\"\",\"taxpayerCode\":\"12345678909876543\",\"totalAmount\":\"2499.00\"},\"order\":{\"account\":\"1\",\"address\":\".\",\"email\":\"amhong@163.com\",\"orderNo\":\"0101149020\",\"totalAmount\":\"2499.00\"},\"postTime\":\"2017-09-15 15:54:10\",\"serialNo\":\"CWFPCK137021573510100055490\"}";
   	   System.out.println("�����ģ�" + jsonStr);
   	// ��������ǩ��������ǩ���ַ���
       String sign = CertificateUtils.signToBase64(jsonStr.getBytes(encode), keyStorePath, keyStoreAbner, keyStorePassWord);
       System.out.println("ǩ���ַ�����" + sign);
       // ����������ʾ��Ӧ����
       Map<String, String> vars = new HashMap<String, String>();
       vars.put("appCode", URLEncoder.encode(appCode, encode));
       vars.put("cmdName", URLEncoder.encode(cmdName, encode));
       vars.put("sign", URLEncoder.encode(sign, encode));
       String responseJson = Erp2TaxHttpUtil.doPost(url, vars, jsonStr, 10000, 10000);
       System.out.println("��Ӧ���ģ�" + responseJson);
       return responseJson;
   }
}
