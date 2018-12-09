package com.trust.app.service;

import java.util.List;

import com.trust.app.model.FactureAchat;

public interface FactureAchatService {
	
	public void addFactureAchat(FactureAchat c);
    public List<FactureAchat> listFactureAchats();
    public void deleteFactureAchat(FactureAchat c);
    public void updateFactureAchat(FactureAchat c);
    public void testLog();
}
