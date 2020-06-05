package com.example.myrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_parent;
    mParentAdapter parentAdapter;
    ArrayList<mCategory> cat_list;

    private static final String api_path="http://d51md7wh0hu8b.cloudfront.net/android/v1/prod/Radio/hi/show.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat_list=new ArrayList<>();
        rv_parent=findViewById(R.id.rv_parent);
        parentAdapter=new mParentAdapter(this, cat_list);
        rv_parent.setLayoutManager(new LinearLayoutManager(this));
        rv_parent.setAdapter(parentAdapter);

        try {
            makeCall();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Some Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    }

    private void makeCall() throws Exception{
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder().url(api_path).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result=response.body().string();

                Gson gson=new Gson();
                cat_list.addAll(Arrays.asList(gson.fromJson(result, mCategory[].class)));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parentAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
