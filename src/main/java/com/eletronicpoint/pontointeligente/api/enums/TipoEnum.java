package com.eletronicpoint.pontointeligente.api.enums;

public enum TipoEnum {
	INICIO_TRABALHO("INICIO TRABALHO"),
	TERMINO_TRABALHO("TERMINO TRABALHO"),
	INICIO_ALMOCO("INICIO ALMOCO"),
	TERMINO_ALMOCO("TERMINO ALMOCO"),
	INICIO_PAUSE("INICIO PAUSE"),
	TERMINO_PAUSE("TERMINO PAUSE");
	
	private String value;
	
	TipoEnum(String value) 
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
