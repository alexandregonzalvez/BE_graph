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

public class solutionDijkstraAStarTest extends solutionDijkstraTest{

	// Fonction testant un scénario
		@Override
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
						//On le test avec Dijkstra comme référence
						DijkstraAlgorithm Dalgo = new DijkstraAlgorithm(data);
						AStarAlgorithm AStaralgo = new AStarAlgorithm(data);
						
						// Recuperation de la solution optimale (Dijkstra) et celle à tester (Dijkstra A Star)
						ShortestPathSolution testSolution = AStaralgo.run();
						ShortestPathSolution optimalSolution = Dalgo.run();
		
						
						if (testSolution.getPath() == null) {// Si on ne trouve pas de solution
							assertEquals(optimalSolution.getPath(), null);
							System.out.println("None");
						}
						// Si un chemin est trouvé 
						else {
							double coutDeLaSolution;
							double CoutEspere;
							if(modeEval ==Mode.TIME) { //Temps
								//Calcul du cout de la solution 
								coutDeLaSolution = testSolution.getPath().getMinimumTravelTime();
								CoutEspere = optimalSolution.getPath().getMinimumTravelTime();
							} else {//LENGTH
								//Calcul du cout de la solution 
								coutDeLaSolution = testSolution.getPath().getLength();
								CoutEspere = optimalSolution.getPath().getLength();
							}
							assertEquals(coutDeLaSolution, CoutEspere,1e-6);// On vérifie que les solutions soit égale (à 1e-6 près)
							System.out.println("Cout solution: " + coutDeLaSolution);
						}
					
				}
			}
			System.out.println("FIN TEST\n");
			reader.close();
		}
		
		
					// Fonction qui execute les scenarios
					public long executeNAStar(String fullPathMap,int [] tabOrigin,int [] tabDestination,Mode modeEval) throws Exception{
						//System.out.println("A Star ");
						
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
							AStarAlgorithm AStaralgo = new AStarAlgorithm(data);

							startTime=System.nanoTime();
							/*ShortestPathSolution sol =*/ AStaralgo.run();
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
