package com.eletronicpoint.pontointeligente.enums;

public enum PerfilEnum {
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_USUARIO("ROLE_USUARIO");
	
	private String value;
	
	PerfilEnum(String value) 
	{
		this.value = value;
	}
}
