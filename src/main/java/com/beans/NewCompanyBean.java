package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.services.CompanyService;
import com.entities.Company;

@ManagedBean(name = "companyBean", eager = true)
@RequestScoped
public class NewCompanyBean {

	private String resourcePerson;
	private String name;
	private String contactEmail;
	private int size;
	private String sector;

	// Injecting CompanyService to handle business logic
	private CompanyService companyService = new CompanyService();

	// Getters and Setters
	public String getResourcePerson() {
		return resourcePerson;
	}

	public void setResourcePerson(String resourcePerson) {
		this.resourcePerson = resourcePerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	// Submit method to handle form submission
	public void submit() {
		Company company = new Company();
		company.setResourcePerson(this.resourcePerson);
		company.setName(this.name);
		company.setContactEmail(this.contactEmail);
		company.setSize(this.size);
		company.setSector(this.sector);

		companyService.saveCompany(company);

		// Redirect to a success page or display a success message
		System.out.println( "success"); // Assuming you have a success.xhtml page configured
	}
}
