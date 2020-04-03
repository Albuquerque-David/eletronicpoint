package com.eletronicpoint.pontointeligente.api.enums;

public enum PerfilEnum {
	ROLE_ADMIN("ROLE ADMIN"),
	ROLE_USUARIO("ROLE USUARIO");
	
	private String value;
	
	PerfilEnum(String value) 
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
