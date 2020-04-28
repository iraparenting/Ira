package com.example.ira;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Youtube_Video extends AppCompatActivity
{
    ArrayList<Youtube_cat_model> arrayList;
    ListView listview;
    String next_page_token;
    ProgressDialog progressDialog;

    @Override
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView((int)R.layout.activity_youtube_video);
        this.listview = (ListView)findViewById(R.id.listview);
        this.arrayList = new ArrayList<>();
        get_data();
    }

    private void get_data() {
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage("Please Wait....!!");
        this.progressDialog.show();
        new HttpGetRequest(this, "https://www.googleapis.com/youtube/v3/search?part=snippet&q=&type=video&videoCategoryId=25&key=AIzaSyDfqzz7ISOeiPfrwoMb3yMf7C5M5w91u30&maxResults=50")
        {
            public void receiveData(String str)
            {
                Youtube_Video.this.progressDialog.dismiss();
                Youtube_Video.this.parse_json1(str);
            }
        };
    }

    /* access modifiers changed from: private */
    public void parse_json1(String str)
    {
        String str2 = BuildConfig.FLAVOR;
        try
        {
            JSONObject jSONObject = new JSONObject(str);
            this.next_page_token = jSONObject.getString("nextPageToken");
            JSONArray jSONArray = jSONObject.getJSONArray("items");

            for (int i = 0; i < jSONArray.length(); i++)
            {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("snippet");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("thumbnails").getJSONObject("high");
                JSONObject jSONObject5 = jSONObject2.getJSONObject("id");

                String string = jSONObject4.getString("url");
                String string2 = jSONObject3.getString("title");
                String string3 = jSONObject3.getString("channelTitle");

                Youtube_cat_model youtube_cat_model = new Youtube_cat_model(str2, jSONObject5.getString("videoId"));

                youtube_cat_model.setUrl(string);
                youtube_cat_model.setTitle(string2);
                youtube_cat_model.setChannelTitle(string3);

                this.arrayList.add(youtube_cat_model);
            }
            this.listview.setAdapter(new Youtube_adapter(this, this.arrayList));

            this.listview.setOnItemClickListener(new OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j)
                {
                    Youtube_Video youtube_Video = Youtube_Video.this;
                    youtube_Video.playYoutubeVideo(youtube_Video, ((Youtube_cat_model) youtube_Video.arrayList.get(i)).getId());
                }
            });
        }
        catch (JSONException e)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(e);
            Toast.makeText(this, sb.toString(), 0).show();
            e.printStackTrace();
        }
    }

    public void playYoutubeVideo(Activity activity, String str)
    {
        try
        {
            activity.startActivityForResult(YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyDfqzz7ISOeiPfrwoMb3yMf7C5M5w91u30", str, 0, true, false), 1);
        }
        catch (Throwable unused)
        {
        }
    }
}
