package com.example.springbootfeignclient.service.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springbootfeignclient.model.BaseRs;
import com.example.springbootfeignclient.model.BrokerRequest;
import com.example.springbootfeignclient.model.BrokerResponse;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.service.SpringBootFeignClientService;
import com.example.springbootfeignclient.vo.StockVo;

/**
 * feign client 調用失敗時處理
 * 
 * @author apota
 *
 */
@Component
public class SchedualServiceHiHystric implements SpringBootFeignClientService {

	@Override
	public String sayHiFromClientOne(String name) {
		return "hystri: sayHiFromClientOne() " + name;
	}

	@Override
	public List<?> getMenu() {
		return new ArrayList<>();
	}

	@Override
	public OrderResponse doOrder(OrderRequest request) {
		return null;
	}

	@Override
	public void setMenu() {
		// TODO Auto-generated method stub
	}

	@Override
	public OrderResponse setProduct(OrderRequest request) {
		System.out.println("setProduct!!!!!!!!!!!!!!!!!!");
		return null;
	}

	@Override
	public OrderResponse getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BrokerResponse setBroker(BrokerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BrokerResponse getBroker() {
		// TODO Auto-generated method stub
		return new BrokerResponse();
	}

	@Override
	public BaseRs setStockDetail(StockVo stock) {
		// TODO Auto-generated method stub
		return new BaseRs();
	}

}
