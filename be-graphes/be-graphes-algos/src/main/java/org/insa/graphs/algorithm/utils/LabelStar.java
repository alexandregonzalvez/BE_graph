package org.insa.graphs.algorithm.utils;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Point;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;
import org.insa.graphs.algorithm.AbstractInputData;


public class LabelStar extends Label implements Comparable<Label> {
	private float coutInf;
	
	public LabelStar(Node noeud, ShortestPathData data) {
		super(noeud);
		Point finalPoint= data.getDestination().getPoint();
		if (data.getMode() == AbstractInputData.Mode.LENGTH) {
			this.coutInf = (float)Point.distance(noeud.getPoint(),finalPoint);
		}
		else {
			int vitesse = Math.max(data.getMaximumSpeed(), data.getGraph().getGraphInformation().getMaximumSpeed());
			this.coutInf = (float)Point.distance(noeud.getPoint(),finalPoint)/(vitesse*10.f/36.f);
		}
	}
	@Override
	public float getTotalCost() {
		return this.coutInf+this.cout;
	}
}
