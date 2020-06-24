package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.algorithm.AbstractSolution.Status;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    //Modification pour le A*
    protected Label constructorLabel(Node node, ShortestPathData data) {
		return new Label(node);
	}
    
    @Override
    protected ShortestPathSolution doRun() {
    	
    	
    	// Initialisation
    	BinaryHeap<Label> tas = new BinaryHeap<Label>();
    	final ShortestPathData data = getInputData();
    	ShortestPathSolution solution = null;
    	Graph graph = data.getGraph();
    	int tailleGraphe = graph.size();
    	boolean fin = false;
    	Label tabLabels[] = new Label [tailleGraphe];
    	Arc[] predecessorArcs = new Arc[tailleGraphe];
		
		// On ajoute le premier point dans le tas
		Label deb = constructorLabel(data.getOrigin(), data);     //Modification pour le A*
		tabLabels[deb.getNode().getId()] = deb;
		tas.insert(deb);
		deb.setInTas(true);
		deb.setCout(0);
		
		// Affichage
		notifyOriginProcessed(data.getOrigin());
		
		//Boucle principal
		while(!tas.isEmpty() && !fin){ 
			Label currentLabel= tas.deleteMin();
			notifyNodeMarked(currentLabel.getNode());
			currentLabel.setMarque(true);
			if (currentLabel.getNode() == data.getDestination()) {
				fin = true;
			}
			
			// On créer un itérator pour parcourir les différents arc partant de notre sommet
			Iterator<Arc> IListArcs = currentLabel.getNode().getSuccessors().iterator();
			
			//Boucle parcourant les différents arcs possible et les ajoutants au tas
			while (IListArcs.hasNext()) {
				
				Arc currentArc = IListArcs.next();

				if (!data.isAllowed(currentArc)) {
					continue;
				}

				Node successeurNode = currentArc.getDestination();

				Label successeurLabel = tabLabels[successeurNode.getId()];
				
				if (successeurLabel == null) {
					successeurLabel = constructorLabel(successeurNode, data); // Modification pour le A*
					tabLabels[successeurLabel.getNode().getId()] = successeurLabel;
					notifyNodeReached(successeurNode);
				}
				
				if (!successeurLabel.getMarque()) {
					//Condition principal : modification avec A*
					if( successeurLabel.getTotalCost()> currentLabel.getCost()+data.getCost(currentArc)+successeurLabel.getTotalCost()-successeurLabel.getCost()
							|| successeurLabel.getCost()==Double.POSITIVE_INFINITY
							){
						
						successeurLabel.setCout(currentLabel.getCost()+(float)data.getCost(currentArc));
						successeurLabel.setPere(currentLabel.getNode());
						
						if(successeurLabel.getInTas()) {
							tas.remove(successeurLabel);
						}
						else {
							successeurLabel.setInTas(true);
						}
						tas.insert(successeurLabel);
						
						predecessorArcs[currentArc.getDestination().getId()] = currentArc;
					}
				}
			}
		
		}
		if (predecessorArcs[data.getDestination().getId()] == null) {
			solution = new ShortestPathSolution(data, Status.INFEASIBLE);
		} else {
			ArrayList<Arc> arcs = new ArrayList<>();
			Arc arc = predecessorArcs[data.getDestination().getId()];

			while (arc != null) {
				arcs.add(arc);
				arc = predecessorArcs[arc.getOrigin().getId()];
			}
			Collections.reverse(arcs);
			solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));
		}
        return solution;
    }

}
