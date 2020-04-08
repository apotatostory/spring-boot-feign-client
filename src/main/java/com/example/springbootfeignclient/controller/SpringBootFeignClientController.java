package com.example.springbootfeignclient.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfeignclient.model.BaseRs;
import com.example.springbootfeignclient.model.BrokerRequest;
import com.example.springbootfeignclient.model.BrokerResponse;
import com.example.springbootfeignclient.model.MenuRequest;
import com.example.springbootfeignclient.model.MenuResponse;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.service.SpringBootFeignClientService;
import com.example.springbootfeignclient.vo.BrokerVo;
import com.example.springbootfeignclient.vo.StockVo;

@RestController
public class SpringBootFeignClientController {

	@Autowired
	SpringBootFeignClientService springBootFeignClientService;

	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam(value = "name") String name) {
		return springBootFeignClientService.sayHiFromClientOne(name);
	}

	@RequestMapping(value = "/menu/get", method = RequestMethod.GET)
	public List<?> getMenu() {
		return springBootFeignClientService.getMenu();
	}

	@RequestMapping(path = "/menu/set", method = RequestMethod.POST, consumes = "application/json")
	public MenuResponse setMenu(@RequestBody MenuRequest request) {
		MenuResponse response = new MenuResponse();

		springBootFeignClientService.setMenu();

		return response;
	}

	/**
	 * 點餐
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product/order", method = RequestMethod.POST, consumes = "application/json")
	public OrderResponse doOrder(@RequestBody OrderRequest request) {
		OrderResponse response = new OrderResponse();

		response.setProducts(request.getProducts());

		return springBootFeignClientService.doOrder(request);
	}

	/**
	 * 取得餐點
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product/get", method = RequestMethod.GET)
	public OrderResponse getProduct() {
		OrderResponse response = new OrderResponse();

		response = springBootFeignClientService.getProduct();

		return response;
	}

	@RequestMapping(value = "/product/set", method = RequestMethod.POST, consumes = "application/json")
	public OrderResponse setProduct(@RequestBody OrderRequest request) {
		OrderResponse response = new OrderResponse();

		response = springBootFeignClientService.setProduct(request);

		return response;
	}

	/**
	 * 取得券商
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/broker/get", method = RequestMethod.GET)
	public BrokerResponse getBroker() {
		BrokerResponse response = new BrokerResponse();

		response.setBrokerMap(springBootFeignClientService.getBroker().getBrokers().stream()
				.collect(Collectors.groupingBy(BrokerVo::getBrokerId)));

		return response;
	}

	@RequestMapping(value = "/broker/set", method = RequestMethod.POST, consumes = "application/json")
	public BrokerResponse setBroker(@RequestBody BrokerRequest request) {
		BrokerResponse response = new BrokerResponse();
		List<BrokerVo> brokers = new ArrayList<>();
		try {
			String source = URLDecoder.decode(request.getSource(), "UTF-8");
			String s[] = source.split(";");
			BrokerVo vo;
			String brokerId;
			String brokerName;
			String branchId;
			String branchName;
			String temp;
			for (String ss : s) {

				brokerId = "";
				brokerName = "";

				for (int i = 1; i < ss.split("!").length; i++) {

					temp = ss.split("!")[i];

					if (i == 1) {
						brokerId = temp.split(",")[0];
						brokerName = temp.split(",")[1];
					}

					branchId = temp.split(",")[0];
					branchName = temp.split(",")[1];

					vo = new BrokerVo();

					vo.setBrokerId(brokerId);
					vo.setBrokerName(brokerName);
					vo.setBranchId(branchId);
					vo.setBranchName(branchName);

					brokers.add(vo);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setBrokers(brokers);

		response = springBootFeignClientService.setBroker(request);

		return response;
	}

	@RequestMapping(value = "/crawler/exe", method = RequestMethod.POST)
	public BaseRs exeCrawler(@RequestBody StockVo stock) {

		return springBootFeignClientService.setStockDetail(stock);
	}

}
