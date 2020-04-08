package com.example.springbootfeignclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootfeignclient.model.BaseRs;
import com.example.springbootfeignclient.model.BrokerRequest;
import com.example.springbootfeignclient.model.BrokerResponse;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.service.hystrix.SchedualServiceHiHystric;
import com.example.springbootfeignclient.vo.StockVo;

/**
 * feignClient調用介面
 * 
 * @author a010174
 *
 */
@FeignClient(value = "service-mongoDB", fallback = SchedualServiceHiHystric.class)
public interface SpringBootFeignClientService {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHiFromClientOne(@RequestParam(value = "name") String name);

	@RequestMapping(value = "/getMenu", method = RequestMethod.GET)
	public List<?> getMenu();

	@RequestMapping(value = "/setMenu", method = RequestMethod.POST)
	public void setMenu();

	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public OrderResponse doOrder(@RequestBody OrderRequest request);

	@RequestMapping(value = "/setProduct", method = RequestMethod.POST)
	public OrderResponse setProduct(@RequestBody OrderRequest request);

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public OrderResponse getProduct();

	@RequestMapping(value = "/setBroker", method = RequestMethod.POST)
	public BrokerResponse setBroker(@RequestBody BrokerRequest request);

	@RequestMapping(value = "/getBroker", method = RequestMethod.GET)
	public BrokerResponse getBroker();

	@RequestMapping(value = "/setStockDetail2", method = RequestMethod.POST)
	public BaseRs setStockDetail(@RequestBody StockVo stock);

}
