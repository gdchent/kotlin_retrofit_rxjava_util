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

    // java里面调用
    /**
     *
     *   jsonObject.put("tt", tt)
    jsonObject.put("data", data)
    jsonObject.put("jm",jm)
    var body: RequestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString())
    apiService.postHomeJobData(body)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(object : Observer<HomeJobBean> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: HomeJobBean) {
    var gson = Gson()
    //Log.i("gdchent","string:"+gson.toJson(t))

    //把数据放到箱子
    jobList.addAll(t.data.jobs)
    //刷新数据
    mJobAdapter.notifyDataSetChanged()
    }

    override fun onError(e: Throwable) {
    Log.i("gdchent", e.message)
    }
    })

    }
     */
}