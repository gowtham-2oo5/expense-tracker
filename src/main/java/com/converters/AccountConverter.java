package com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.entities.Account;
import com.services.AccountServices;

@FacesConverter(forClass = Account.class, value="accConverter")
public class AccountConverter implements Converter {

	private AccountServices accountService; // Inject a service or method to retrieve accounts

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		try {
			Long id = Long.valueOf(value);
			return accountService.findAccountById(id); // Use a service to fetch Account
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid account ID: " + value, e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || !(value instanceof Account)) {
			return "";
		}
		return String.valueOf(((Account) value).getId()); // Convert Account to ID
	}
}
