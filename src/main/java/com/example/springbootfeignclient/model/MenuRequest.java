package com.example.springbootfeignclient.model;

public class MenuRequest {
	// 子類
	private String menuId;

	// 大類
	private String group;

	// 1:父節點 2:子節點
	private int node;

	// 名稱
	private String name;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
