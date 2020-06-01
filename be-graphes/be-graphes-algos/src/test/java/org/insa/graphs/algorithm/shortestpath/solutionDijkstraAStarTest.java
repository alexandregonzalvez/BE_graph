package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;
import org.junit.Test;

public class solutionDijkstraAStarTest {

	// Fonction testant un scénario
		public void testScenario(String mapName, int origine, int destination, Mode modeEval) throws Exception {

			System.out.println("Origine : " + origine);
			System.out.println("Destination : " + destination);

			// Create a graph reader.
			GraphReader reader = new BinaryGraphReader(
					new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

			// Read the graph.
			Graph graph = reader.read();

			
				if (origine<0 || destination<0 || origine>=(graph.size()-1) || destination>=(graph.size()-1)) { // On est hors du graphe. / Sommets inexistants
					System.out.println("ERREUR : Sommet innexistant ");
					
				} else {
					ArcInspector arcInspectorDijkstraAStar;
					
					if (modeEval == Mode.TIME) { //Temps
						System.out.println("Mode d'évaluation : Temps");
						arcInspectorDijkstraAStar = ArcInspectorFactory.getAllFilters().get(2);
					} else {//LENGTH
						System.out.println("Mode d'évaluation : Distance");
						arcInspectorDijkstraAStar = ArcInspectorFactory.getAllFilters().get(0);
					}
					
					
					if(origine==destination) {
						System.out.println("L'origine et la destination sont identiques");
						System.out.println("Cout nul");
						
					} else {			
						ShortestPathData data = new ShortestPathData(graph, graph.get(origine),graph.get(destination), arcInspectorDijkstraAStar);
						//On le test avec BellmanFord comme référence
						DijkstraAlgorithm Dalgo = new DijkstraAlgorithm(data);
						AStarAlgorithm AStaralgo = new AStarAlgorithm(data);
						
						// Recuperation des solutions de Bellman et Dijkstra pour comparer 
						ShortestPathSolution solution = AStaralgo.run();
						ShortestPathSolution expected = Dalgo.run();
		
						
						if (solution.getPath() == null) {
							assertEquals(expected.getPath(), solution.getPath());
							System.out.println("PAS DE SOLUTION");
							System.out.println("(infini) ");
						}
						// Un plus court chemin trouve 
						else {
							double coutDeLaSolution;
							double CoutEspere;
							if(modeEval ==Mode.TIME) { //Temps
								//Calcul du cout de la solution 
								coutDeLaSolution = solution.getPath().getMinimumTravelTime();
								CoutEspere = expected.getPath().getMinimumTravelTime();
							} else {//LENGTH
								//Calcul du cout de la solution 
								coutDeLaSolution = solution.getPath().getLength();
								CoutEspere = expected.getPath().getLength();
							}
							assertEquals(coutDeLaSolution, CoutEspere,1e-6);
							System.out.println("Cout solution: " + coutDeLaSolution);
						}
					
				}
			}
			System.out.println("FIN TEST");
			System.out.println();
		}
		
		
		// Fonction qui execute un scenario
				public void execute(String mapName, int origine, int destination, Mode modeEval) throws Exception {

					System.out.println("Origine : " + origine);
					System.out.println("Destination : " + destination);

					// Create a graph reader.
					GraphReader reader = new BinaryGraphReader(
							new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

					// Read the graph.
					Graph graph = reader.read();

					
					ArcInspector arcInspectorDijkstra;
					
					if (modeEval == Mode.TIME) { //Temps
						System.out.println("Mode d'évaluation : Temps");
						arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(2);
					} else {//LENGTH
						System.out.println("Mode d'évaluation : Distance");
						arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
					}
					
					ShortestPathData data = new ShortestPathData(graph, graph.get(origine),graph.get(destination), arcInspectorDijkstra);
					AStarAlgorithm DAStaralgo = new AStarAlgorithm(data);
								
					// Recuperation des solutions de Bellman et Dijkstra pour comparer 
					ShortestPathSolution solution = DAStaralgo.run();
				
								
					if (solution.getPath() == null) {
						System.out.println("PAS DE SOLUTION");
						System.out.println("(infini) ");
					}
					// Un plus court chemin trouve 
					else {
						double coutDeLaSolution;
						if(modeEval ==Mode.TIME) { //Temps
							//Calcul du cout de la solution 
							coutDeLaSolution = solution.getPath().getMinimumTravelTime();
						} else {//LENGTH
							//Calcul du cout de la solution 
							coutDeLaSolution = solution.getPath().getLength();
						}
						System.out.println("Cout solution: " + coutDeLaSolution);
								
							
						}
					System.out.println();
				}

}
