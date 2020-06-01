package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.Node;

public class Label implements Comparable<Label> {
	protected float cout;
	private boolean marque;
	private Node pere;
	private Node node;
	private boolean insideTas; // Pour savoir si l'élément est dans l'état et ainsi l'enlever (on aurait pu intégrer une méthode dans BinaryHeap, mais semble complexe par rapport à cet ajout)
	
	
	public Label(Node noeud){
		this.node = noeud;
		this.marque = false;
		this.cout = Float.POSITIVE_INFINITY;
		this.pere = null; 
		this.insideTas=false;
	}
	
	//Modification avec le A*
    @Override
    /* Compare les Labels selon leur coût */
	public int compareTo(Label autre) {
		int resultat;
		if (this.getTotalCost() < autre.getTotalCost()) {
			resultat = -1;
		}
		else if (this.getTotalCost() == autre.getTotalCost()) {
			resultat = 0;
		}
		else {
			resultat = 1;
		}
		return resultat;
	}
	
	public Node getNode() {
		return this.node;
	}
	
	public float getCost() {
		return this.cout;
	}
	
	public float getTotalCost() {
		return this.cout;
	}
	
	public boolean getMarque() {
		return this.marque;
	}
	
	public Node getPere() {
		return this.pere;
	}
	
	
	public void setMarque(boolean bool) {
		this.marque = bool;
	}
	
	public void setCout(float cout) {
		this.cout = cout;
	}
	
	public void setPere(Node pere) {
		this.pere = pere;
	}
	public boolean getInTas() {
		return this.insideTas;
	}
	public void setInTas(boolean bool) {
		this.insideTas = bool;
	}
	
}
