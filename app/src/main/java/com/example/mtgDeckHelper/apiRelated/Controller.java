package com.example.mtgDeckHelper.apiRelated;

import java.util.concurrent.TimeUnit;

import com.example.mtgDeckHelper.apiRelated.Card;
import com.example.mtgDeckHelper.apiRelated.MagicService;
import com.example.mtgDeckHelper.apiRelated.MyInterceptor;
import com.example.mtgDeckHelper.apiRelated.api_response_succes;
import com.example.mtgDeckHelper.liveDataViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<api_response_succes> {

    liveDataViewModel requestedFrom;
    String searchNote;

    public Controller(liveDataViewModel myModel) {
        requestedFrom = myModel;
    }

    public void setSearchNote(String searchNote) {
        this.searchNote = searchNote;
    }

    static final String BASE_URL = "https://api.scryfall.com";

    public void start() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(new MyInterceptor())
                .readTimeout(100,TimeUnit.SECONDS).build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MagicService magicService = retrofit.create(MagicService.class);
        HttpUrl requestUrl = HttpUrl.parse(searchNote);
        Call<api_response_succes>  call = magicService.getCards(requestUrl.toString());
        call.enqueue(this);
        System.out.println("----------SENDING---------- \n");
        System.out.println(call.request().url());

    }

    @Override
    public void onResponse(final Call<api_response_succes> call, Response<api_response_succes> response) {
        if(response.isSuccessful()) {
            System.out.println("----------RESPONSE IS RIGHT---------- \n");
            System.out.println(response.body());
            System.out.println("-------------------------------------------");
            api_response_succes changesList = response.body();
           requestedFrom.update_cards(changesList.getData());

        } else {
            System.out.println("----------RESPONSE IS WRONG---------- \n");
            try {
                JSONObject jObjError = new JSONObject(response.errorBody().string());
                System.out.println(jObjError.toString() + "\n");
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onFailure(Call<api_response_succes> call, Throwable t) {
        System.out.println("-------------- FAILURE -------------- \n");
        t.printStackTrace();
    }
}
