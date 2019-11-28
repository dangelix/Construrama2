package com.finkok.facturacion.cancellation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StringArray", propOrder = { "string" })

public class StringArray {
	@XmlElement(name = "string", nillable = true)
	protected List<String> string;

	public List<String> getString() {
		if(this.string==null) {
			this.string= new ArrayList<String>();
		}
		return string;
	}

	public void setString(List<String> string) {
		this.string = string;
	}
	
	
}
