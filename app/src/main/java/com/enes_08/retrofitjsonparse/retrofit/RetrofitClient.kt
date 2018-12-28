package com.limonist.mykotlin.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lenovo on 05.11.2018.
 */

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(BaseUrl: String): Retrofit? {

        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BaseUrl)
                    .client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }

        return this!!.retrofit
    }

    fun getApi(BaseUrl: String): IJsonAPI {
        return RetrofitClient.getClient(BaseUrl)!!.create(IJsonAPI::class.java)
    }
}
