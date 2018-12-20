package com.ssf.tc.publish.manager

/**
 * Created by chentao
 * Date:2018/12/20
 */
class HttpService {

    companion object {
        var apiService:ApiService?=null

        fun  getApiServiceInstance():ApiService?{
            if(apiService==null){
                apiService=HttpRetrofitClient.getInstance()?.create(ApiService::class.java)
            }
            return apiService
        }
    }
}