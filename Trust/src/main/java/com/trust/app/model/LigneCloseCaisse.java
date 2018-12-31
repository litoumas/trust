package com.trust.app.model;

import lombok.Getter;
import lombok.Setter;

public class LigneCloseCaisse {
	public LigneCloseCaisse(LigneVenteComptoir ligneVenteComptoir) {
		this.ligneVenteComptoir = ligneVenteComptoir;
		this.qteDeclarer = 0;
		this.qteNoir = 0;
	}

	@Getter
	@Setter
	LigneVenteComptoir ligneVenteComptoir;
	@Getter
	@Setter
	float qteNoir;
	@Getter
	@Setter
	float qteDeclarer;
	
	@Getter
	@Setter
	VenteComptoir venteComptoir;

}
