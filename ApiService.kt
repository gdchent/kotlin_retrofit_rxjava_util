package com.ssf.tc.publish.manager

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

/**
 * Created by chentao
 * Date:2018/12/18
 */
interface ApiService {


    ///tk/atbCategorysGet?commissiontype=11&app=3 HTTP/1.1

    /**
     *
     */
    @POST("jz/hot.json?tt") //534daa6c8066b8f5d0d027cafb22274a
    fun postHomeJobData(@Body body:RequestBody ):Observable<HomeJobBean>

    @POST("jz/detail.json")
    fun postHomeJobDetailData(@Body body:RequestBody):Observable<HomeJodDetailBean>

   
}