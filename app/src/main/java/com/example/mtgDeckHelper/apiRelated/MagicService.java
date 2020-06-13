package com.example.mtgDeckHelper.apiRelated;

import com.example.mtgDeckHelper.apiRelated.api_response_succes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MagicService {
    @GET()
    Call<api_response_succes> getCards(@Url String url);
}
