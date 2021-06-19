package com.nt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("aob")
public class Address {
	
	
	@Value("39-A/Jk")
	private String hno;
	@Value("HYD")
	private String loc;
	
	public Address() {
		super();
	}
	
	
	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Address [hno=" + hno + ", loc=" + loc + "]";
	}
	
	

}
