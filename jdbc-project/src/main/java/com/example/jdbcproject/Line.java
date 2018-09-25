package com.example.jdbcproject;

public class Line {
	
	private Integer id;
	private String value;

	public Line () {
	}

	public Line (int id, String value) {
		this.id = id;
		this.value = value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}