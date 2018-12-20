## kotlin- retrofit rxjava 
 jsonObject.put("tt", tt)
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
