package com.techweaversys.dto;

public class marklaveSpecDto {

	
	
	private String mark;
	private String remark;
	private Integer page;
	private Integer size;
	public marklaveSpecDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public marklaveSpecDto(String mark, String remark, Integer page, Integer size) {
		super();
		this.mark = mark;
		this.remark = remark;
		this.page = page;
		this.size = size;
	}
	@Override
	public String toString() {
		return "marklaveSpecDto [mark=" + mark + ", remark=" + remark + ", page=" + page + ", size=" + size
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getmark() {
		return mark;
	}
	public void setmark(String mark) {
		this.mark = mark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	
	
}
