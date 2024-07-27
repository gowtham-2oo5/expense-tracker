package com.beans;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import com.entities.User;
import com.entities.UserType;
import com.services.AdminServices;

@ManagedBean(name = "adminBean", eager = true)
public class NewAdminBean {

	private String name;
	private String uname;
	private String mail;
	private String phone;
	private String password;
	private Part dp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Part getDp() {
		return dp;
	}

	public void setDp(Part dp) {
		this.dp = dp;
	}

	public void submit() {
		if (dp != null) {
			try (InputStream inputStream = dp.getInputStream()) {
				byte[] imageBytes = new byte[(int) dp.getSize()];

				inputStream.read(imageBytes);

				User newAdmin = new User();
				// t.setId(id);
				newAdmin.setEmail(mail);
				newAdmin.setName(name);
				newAdmin.setUsername(uname);
				newAdmin.setPassword(password);
				newAdmin.setPhone(phone);
				newAdmin.setProfilePicture(imageBytes);
				newAdmin.setUserType(UserType.ADMIN);
				newAdmin.setStatus(false);
				newAdmin.setWorkRole("N/A");

				AdminServices ra = new AdminServices();
				ra.addAdmin(newAdmin);
				// rt.insertData(t);

				System.out.println("INserted ok");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
