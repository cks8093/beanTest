package org.gradle.test09;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Properties;

public class Tire {
	String 			maker; // 제조사
	Date				createdDate; //제조일
	
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		StringBuffer specInfo = new StringBuffer();
	  return "[Tire:" + maker + "," + 
				specInfo.toString() + 
	  		((createdDate != null)?("," + createdDate.toString()):"") + "]";
	}
}
