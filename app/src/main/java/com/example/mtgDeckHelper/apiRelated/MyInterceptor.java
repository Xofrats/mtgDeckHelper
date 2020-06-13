package com.example.mtgDeckHelper.apiRelated;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String stringurl = request.url().toString();
        stringurl = stringurl.replace("%26", "&");
        stringurl = stringurl.replace("%3D", "=");

        Request newRequest = new Request.Builder()
                .url(stringurl)
                .build();

        return chain.proceed(newRequest);
    }
}
