package com.example.restapi_roberto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class HelloController implements Callback<Model> {
    static final String BASE_URL = "https://dog.ceo/api/breeds/image/";
    static final String[] perro = new String[2];

    @FXML
    private ImageView image;

    public void initialize(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Interface random = retrofit.create(Interface.class);

        Call<Model> call = random.nuevo();
        call.enqueue(this);
    }

    @FXML
    public void onClick() {
        

        this.initialize();
    }

    @Override
    public void onResponse(Call<Model> call, Response<Model> response) {
        if (response.isSuccessful()) {
            Model changesList = response.body();
            Image imagen = new Image(changesList.message);
            image.setImage(imagen);

        } else {
            System.out.println(response.errorBody());
        }

    }
    @Override
    public void onFailure(Call<Model> call, Throwable throwable) {

    }
}
