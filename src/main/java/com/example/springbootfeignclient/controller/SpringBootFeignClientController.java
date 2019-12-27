package com.example.springbootfeignclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfeignclient.model.MenuRequest;
import com.example.springbootfeignclient.model.MenuResponse;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.service.SpringBootFeignClientService;

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
}
