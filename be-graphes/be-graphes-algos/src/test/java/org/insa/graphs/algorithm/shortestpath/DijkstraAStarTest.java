package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.*;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.junit.Test;

public class DijkstraAStarTest {

    
    
    @Test
  	public void testDoDistance() throws Exception {
  		// A changé selon la machine utilisé
  		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
  		int origin,destination;
 
  		
  		Mode modetest=Mode.LENGTH;
  		String mapName = "paris.mapgr";
  		
  		// Instanciation de la classe test
  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
  		
  	//On affiche la carte et le mode testé
  		System.out.println("-- Algo : Dijkstra classique --");
		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
		
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas d'un chemin nul --");
		origin = 0 ;
		destination = 0;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "insa.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas sommet non existant (origine)--");
		origin = 1600 ;
		destination = 1001;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas sommet non existant (destination)--");
		origin = 0 ;
		destination = 1400;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "washington.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Pas de chemin selon Bellman-Ford --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "insa.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas normal 1 --");
		origin = 50 ;
		destination = 1300;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "bordeaux.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 2 --");
		origin = 354 ;
		destination = 1789;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		

		System.out.println("-- Cas normal 3 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 4 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		
		mapName = "washington.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 5 --");		
		origin = 121833 ;
		destination = 113525;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "paris.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 6 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 7 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 8 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 9 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
  	}
  	
    @Test
  	public void testDoTemps() throws Exception {
  		// A changé selon la machine utilisé
  		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
  		int origin,destination;
 
  		
  		Mode modetest=Mode.TIME;
  		String mapName = "bretagne.mapgr";
  		
  		// Instanciation de la classe test
  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
  		
  	//On affiche la carte et le mode testé
  		System.out.println("-- Algo : Dijkstra classique --");
		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
		
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas d'un chemin nul --");
		origin = 0 ;
		destination = 0;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "insa.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas sommet non existant (origine)--");
		origin = 1600 ;
		destination = 1001;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas sommet non existant (destination)--");
		origin = 0 ;
		destination = 1400;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "washington.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Pas de chemin selon Bellman-Ford --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "insa.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		
		System.out.println("-- Cas normal 1 --");
		origin = 50 ;
		destination = 1300;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "bordeaux.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 2 --");
		origin = 354 ;
		destination = 1789;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		

		System.out.println("-- Cas normal 3 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 4 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		
		mapName = "washington.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 5 --");		
		origin = 121833 ;
		destination = 113525;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		mapName = "paris.mapgr";
		System.out.println("-- Carte : "+ mapName +" --");
		System.out.println("-- Cas normal 6 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 7 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 8 --");
		origin = 1900 ;
		destination = 1645;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
		
		System.out.println("-- Cas normal 9 --");
		origin = 100 ;
		destination = 25;
		soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
  	}

}
