package com.db1.conta.contaapi.infra;

public class Verificadora {

	public static void verificaValorMaiorQueZero(Double value, String message) {
		if (value == null || value <= 0) {
			throw new RuntimeException(message);
		}
	}
	
}
