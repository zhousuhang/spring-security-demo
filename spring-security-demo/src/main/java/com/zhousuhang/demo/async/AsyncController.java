package com.zhousuhang.demo.async;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
public class AsyncController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	@RequestMapping("/order")
	public Callable<String> order() throws InterruptedException {
		logger.info("main thread start");
		Callable<String> result = new Callable<String>() {

			@Override
			public String call() throws Exception {
				logger.info("callable thread start");
				Thread.sleep(1000);
				logger.info("callable thread return");
				return "success";
			}
			
		};
		logger.info("main thread return");
		return result;
	}
	
	@RequestMapping("/order2")
	public DeferredResult<String> order2() throws Exception {
		logger.info("main thread start");
		
		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);
		
		logger.info("main thread return");
		return result;
	}
}
