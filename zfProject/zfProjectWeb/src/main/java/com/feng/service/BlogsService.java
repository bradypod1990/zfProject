package com.feng.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.feng.interfaces.BlogsInterface;

@FeignClient("zf-v1")
public interface BlogsService extends BlogsInterface {

}
