package byili.cherryapps.minimaokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Callback {
    private final String TAG = getClass().getSimpleName();

    private static final String URL = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

    private OkHttpClient okHttpClient;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView        = (TextView) findViewById(R.id.tv_text);

        okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(URL).build();

        okHttpClient.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        Log.e(TAG, "onFailure: ", e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        Log.d(TAG, "onResponse: " + response.body().string());
       /* try {
            JSONObject responseObj = new JSONObject(response.body().string());
            Log.i(TAG, "responseObj: " + responseObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}
