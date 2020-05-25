package com.wisely.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by dujiayong on 2016/7/7.
 * 定时任务
 */
@Service
public class PushService {

    private DeferredResult<String> deferredResult;

    /**
     * 在PushService里产生DeferredResult给控制器使用
     * @return
     */
    public DeferredResult<String> getAsyncResult(){
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    /**
     * 通过@Scheduled注解的方法定时更新DeferredResult
     */
    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
