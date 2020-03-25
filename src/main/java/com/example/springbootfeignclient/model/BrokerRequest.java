package com.example.springbootfeignclient.model;

import java.util.List;

import com.example.springbootfeignclient.vo.BrokerVo;

public class BrokerRequest {

	private String source;

	private BrokerVo borker;

	private List<BrokerVo> brokers;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public BrokerVo getBorker() {
		return borker;
	}

	public void setBorker(BrokerVo borker) {
		this.borker = borker;
	}

	public List<BrokerVo> getBrokers() {
		return brokers;
	}

	public void setBrokers(List<BrokerVo> brokers) {
		this.brokers = brokers;
	}

}
