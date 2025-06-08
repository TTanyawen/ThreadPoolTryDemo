package com.example.threadpooltrydemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@Slf4j
public class TestService {
    @Autowired
    ThreadPoolExecutor threadPoolExecutor;
    public void testThreadPool() {
        List<Future<String>> futureResults = new ArrayList<>(5);
        int[] nums={10,20,30,40,50};
        for(int i=0;i<5;i++){
            final int currentNum = nums[i];
            Future<String> completableFuture = threadPoolExecutor
                    .submit(() -> getStr(currentNum));
            futureResults.add(completableFuture);
        }

        for (Future<String> future : futureResults) {
            try {
                log.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public String getStr(int i) {
        return  i+"---------"+LocalDateTime.now().toString();
    }
}
