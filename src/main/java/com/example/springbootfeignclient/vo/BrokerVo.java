package com.example.springbootfeignclient.vo;

public class BrokerVo {

	private String BrokerId;

	private String BrokerName;

	private String BranchId;

	private String BranchName;

	public String getBrokerId() {
		return BrokerId;
	}

	public void setBrokerId(String brokerId) {
		BrokerId = brokerId;
	}

	public String getBrokerName() {
		return BrokerName;
	}

	public void setBrokerName(String brokerName) {
		BrokerName = brokerName;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setBranchId(String branchId) {
		BranchId = branchId;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
}
