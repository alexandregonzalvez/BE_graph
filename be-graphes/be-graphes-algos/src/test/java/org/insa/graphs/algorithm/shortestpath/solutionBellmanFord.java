package org.insa.graphs.algorithm.shortestpath;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;

public class solutionBellmanFord  extends solutionDijkstraTest{
	// Fonction testant un scénario
			
			
			// Fonction qui execute les scenarios
			public long executeNBellmanFord(String fullPathMap,int [] tabOrigin,int [] tabDestination,Mode modeEval) throws Exception{
				//System.out.println("Bellman Ford ");
				
				
				// Déclaration Variables 
				long startTime,endTime,totalElapseTime;
				
				totalElapseTime=0;
				
				// Create a graph reader.
				GraphReader reader = new BinaryGraphReader(
						new DataInputStream(new BufferedInputStream(new FileInputStream(fullPathMap))));

				// Read the graph.
				Graph graph = reader.read();

				
				ArcInspector arcInspectorBF;
				
				if (modeEval == Mode.TIME) { //Temps
					arcInspectorBF = ArcInspectorFactory.getAllFilters().get(2);
				} else {//LENGTH
					arcInspectorBF = ArcInspectorFactory.getAllFilters().get(0);
				}

				// Trouve les différentes routes
				for(int i=0;i<tabOrigin.length;i++) {
					int origine=tabOrigin[i];
					int destination=tabDestination[i];
					//System.out.println("Origine : " + origine);
					//System.out.println("Destination : " + destination);
					//System.out.print(i+" ");

					ShortestPathData data = new ShortestPathData(graph, graph.get(origine),graph.get(destination), arcInspectorBF);
					BellmanFordAlgorithm BFalgo = new BellmanFordAlgorithm(data);
					
					
					startTime=System.nanoTime();
					/*ShortestPathSolution sol = */BFalgo.run();
					endTime=System.nanoTime();
					//if(sol.getPath() != null){
						totalElapseTime+=endTime-startTime;
					//}				
				}
				reader.close();
				//System.out.println();
				return totalElapseTime;
			}
				
}
