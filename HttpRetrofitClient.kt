package com.ssf.tc.publish.manager

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by chentao
 * Date:2018/12/20
 */
class HttpRetrofitClient {

    var BASE_URL="https://renault.91go.vip/"
    fun createRetrofit():Retrofit{
        //拦截器
        var httpLoggingInterceptor:HttpLoggingInterceptor=HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.i("gdchent","retrofit网络请求拦截信息:"+message)
            }
        })
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        //初始化OkhttpClient
        var okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        var okHttpClient=okHttpBuilder.build()
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);
        var retrofit=Retrofit
                .Builder()
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL) //这里要以"/"结尾
                .build()
        return retrofit
    }

    //单例模式
    companion object {
        var INSTANCE: Retrofit?=null
        //拿到Retrofit实例
        fun getInstance(): Retrofit? {
            if(INSTANCE==null){
                //throw UnknownError("Not initialized ")
                INSTANCE= HttpRetrofitClient().createRetrofit()
            }
            return INSTANCE
        }


    }
}