package com.feng.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.feng.service.IndexService;

@Service("IndexService")
public class IndexServiceImpl implements IndexService {

    Logger logger = Logger.getLogger(IndexServiceImpl.class);
    @Override
    public String hello() {
        logger.info("hello world service");
        return "hello world service";
    }

}
