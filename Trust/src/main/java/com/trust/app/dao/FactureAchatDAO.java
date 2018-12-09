package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.FactureAchat;

public interface FactureAchatDAO {

	public void addFactureAchat(FactureAchat p);
    public List<FactureAchat> listFactureAchats();
    public void deleteFactureAchat(FactureAchat p);
    public void updateFactureAchat(FactureAchat p);

	
}
