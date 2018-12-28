package com.enes_08.retrofitjsonparse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enes_08.retrofitjsonparse.model.response.User
import com.limonist.mykotlin.Retrofit.IJsonAPI
import com.limonist.mykotlin.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //

    var services: IJsonAPI?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        services = RetrofitClient.getApi("https://jsonplaceholder.typicode.com/")

        services!!.getUser().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                Log.d("RESPONSEO-SEND MSG", t!!.message)



            }

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {

                var list =response!!.body()!!;





                for (item in list){
                    Log.d("RESPONSEO-SEND MSG", "***********************")

                    Log.d("RESPONSEO-SEND MSG", item.email)
                    Log.d("RESPONSEO-SEND MSG", item.name)
                    Log.d("RESPONSEO-SEND MSG", item.phone)
                    Log.d("RESPONSEO-SEND MSG", item.username)
                    Log.d("RESPONSEO-SEND MSG", item.website)
                    Log.d("RESPONSEO-SEND MSG", "----------------------------")

                    Log.d("RESPONSEO-SEND MSG", item.address!!.city)
                    Log.d("RESPONSEO-SEND MSG", item.address!!.street)
                    Log.d("RESPONSEO-SEND MSG", item.address!!.suite)
                    Log.d("RESPONSEO-SEND MSG", item.address!!.zipcode)
                    Log.d("RESPONSEO-SEND MSG", "----------------------------")

                    Log.d("RESPONSEO-SEND MSG", item.company!!.name)
                    Log.d("RESPONSEO-SEND MSG", item.company!!.bs)
                    Log.d("RESPONSEO-SEND MSG", item.company!!.catchPhrase)

                    Log.d("RESPONSEO-SEND MSG", "----------------------------")

                    Log.d("RESPONSEO-SEND MSG", item.address!!.geo!!.lat)
                    Log.d("RESPONSEO-SEND MSG", item.address!!.geo!!.lng)





                    Log.d("RESPONSEO-SEND MSG", "***********************")


                }





            }
        })






    }
}
