package com.example.springbootfeignclient.model;

import java.util.List;
import java.util.Map;

import com.example.springbootfeignclient.vo.BrokerVo;

public class BrokerResponse {
	private BrokerVo broker;

	private Map<String, List<BrokerVo>> brokerMap;

	private List<BrokerVo> brokers;

	public BrokerVo getBroker() {
		return broker;
	}

	public void setBroker(BrokerVo broker) {
		this.broker = broker;
	}

	public List<BrokerVo> getBrokers() {
		return brokers;
	}

	public void setBrokers(List<BrokerVo> brokers) {
		this.brokers = brokers;
	}

	public Map<String, List<BrokerVo>> getBrokerMap() {
		return brokerMap;
	}

	public void setBrokerMap(Map<String, List<BrokerVo>> brokerMap) {
		this.brokerMap = brokerMap;
	}

}
