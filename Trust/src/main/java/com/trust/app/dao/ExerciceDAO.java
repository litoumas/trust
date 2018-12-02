package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Exercice;

public interface ExerciceDAO {
	public void addExercice(Exercice p);
    public List<Exercice> listExercices();
    public void deleteExercice(Exercice Exercice);
    public void updateExercice(Exercice Exercice);
}
