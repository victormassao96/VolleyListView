package tz.co.aim.volleylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tz.co.aim.volleylistview.model.Movie;

public class MainActivity extends AppCompatActivity{



    TextView movie_name,description,categories,ratings,studio;
    ImageView thumbnail;
    private final String url = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Movie> listmovie;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listmovie = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        jsonRequest();
    }

    private void jsonRequest() {

        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject =  null;

                for (int i = 0 ; i<response.length() ; i++) {

                    try {
                        jsonObject=response.getJSONObject(i);
                        Movie movie = new Movie();
                        movie.setName(jsonObject.getString("name"));
                        movie.setDescription(jsonObject.getString("description"));
                        movie.setCategories(jsonObject.getString("categorie"));
                        movie.setRatings(jsonObject.getString("Rating"));
                        movie.setEpisode(jsonObject.getInt("episode"));
                        movie.setStudio(jsonObject.getString("studio"));
                        movie.setImage_url(jsonObject.getString("img"));

                        listmovie.add(movie);


                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
                setuprecyclerview(listmovie);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Movie> listmovie) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,listmovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
}