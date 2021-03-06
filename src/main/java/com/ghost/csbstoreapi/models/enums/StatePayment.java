package com.ghost.csbstoreapi.models.enums;

public enum StatePayment {

//	PENDING(1, "Payment Pending"),
	PENDING(1, "Aguardando Pagamento"),
	PAID(2, "Payment Paid"),
	CANCELED(3, "Payment Canceled");
	
	private int cod;
	private String description;
	
	private StatePayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return description;
	}
	
	public static StatePayment toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (StatePayment x : StatePayment.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: " + cod);
	}

}
