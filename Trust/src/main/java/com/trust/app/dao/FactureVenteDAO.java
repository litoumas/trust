package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.FactureVente;

public interface FactureVenteDAO {
	public List<FactureVente> listFactureVentes();

	public void addFactureVente(FactureVente u);

	public void deleteFactureVente(FactureVente u);

	public void updateFactureVente(FactureVente u);

}
