package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Exercice;

public interface ExerciceService {
	
	public void addExercice(Exercice c);
    public List<Exercice> listExercices();
    public void deleteExercice(Exercice c);
    public void updateExercice(Exercice c);
    public void testLog();
	public Exercice getLastOne();
}
