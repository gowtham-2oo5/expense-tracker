package com.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "admin", eager = true)
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String dp;

	public AdminBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			this.id = (String) context.getExternalContext().getSessionMap().get("adminId");
			this.name = (String) context.getExternalContext().getSessionMap().get("adminName");
			this.dp = (String) context.getExternalContext().getSessionMap().get("adminDp");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

}
