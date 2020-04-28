package com.example.ira;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpGetRequest extends AsyncTask<String, Void, String> {
    public static final int CONNECTION_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 15000;
    public static final String REQUEST_METHOD = "GET";
    Context context;
    String url;

    public abstract void receiveData(String str);

    public HttpGetRequest(Context context2, String str) {
        this.context = context2;
        this.url = str;
        execute(new String[0]);
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        receiveData(str);
    }
}
