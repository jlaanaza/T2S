package com.t2s.web.enumeration;

public enum MovementTypeEN {
	
	EMBARQUE("Embarque"),
	DESCARGA("Descarga"),
	GATEIN("Gate IN"),
	GATEOUT("Gate out"),
	POSICIONAMENTO("Posicionamento"),
	PILHA("Pilha"),
	PESAGEM("Pesagem"),
	SCANNER("Scanner");
	
	public String value;
	
	MovementTypeEN(String value) {
        this.value = value;
    }

}
