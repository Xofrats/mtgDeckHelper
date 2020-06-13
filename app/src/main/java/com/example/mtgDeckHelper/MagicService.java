package com.example.mtgDeckHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MagicService {
    @GET()
    Call<api_response_succes> getCards(@Url String url);
}
