package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.*;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.junit.Test;

public class DijkstraAStarTest {

	// A changer selon la machine utilisé
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";

		
	    @Test 
	    public void testLengthPathNull() throws Exception{
	  		int origin,destination;
	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.LENGTH;
	  		String mapName = "paris.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas d'un chemin nul --");
			
			origin = 0 ;
			destination = 0;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test 
	    public void testLengthNoNodeOrigin() throws Exception{
	    	int origin,destination;
	    	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.LENGTH;
			String mapName = "insa.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non existant (origine)--");
			origin = 1600 ;
			destination = 1001;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test 
	    public void testLengthNoNodeDestination() throws Exception{
	    	int origin,destination;
	    	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.LENGTH;
			String mapName = "insa.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non destination (origine)--");
			origin = 0 ;
			destination = 1400;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test
	    public void testLengthNoPathByBF() throws Exception{
	    	int origin,destination;
	   	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.LENGTH;
			String mapName = "washington.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non destination (origine)--");
			origin = 1900 ;
			destination = 1645;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    
	    @Test
	  	public void testLength10NormalScenario() throws Exception {

	    	int origin,destination;
	      	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			String mapName = "insa.mapgr";
			Mode modetest=Mode.LENGTH;
			
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
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
			origin = 1218 ;
			destination = 4852;
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
	    public void testTimePathNull() throws Exception{
	  		int origin,destination;
	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.TIME;
	  		String mapName = "bretagne.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas d'un chemin nul --");
			
			origin = 0 ;
			destination = 0;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test 
	    public void testTimeNoNodeOrigin() throws Exception{
	    	int origin,destination;
	    	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.TIME;
			String mapName = "insa.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non existant (origine)--");
			origin = 1600 ;
			destination = 1001;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test 
	    public void testTimeNoNodeDestination() throws Exception{
	    	int origin,destination;
	    	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.TIME;
			String mapName = "insa.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non destination (origine)--");
			origin = 0 ;
			destination = 1400;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    @Test
	    public void testTimeNoPathByBF() throws Exception{
	    	int origin,destination;
	   	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			
			Mode modetest=Mode.TIME;
			String mapName = "washington.mapgr";
	  		
	  		//On affiche la carte et le mode testé
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			
			System.out.println("-- Cas sommet non destination (origine)--");
			origin = 1900 ;
			destination = 1645;
			soluceDijkstraAStar.testScenario(cheminVersMaps+mapName,origin,destination,modetest);
	    }
	    
	    
	    @Test
	  	public void testTime10NormalScenario() throws Exception {

	    	int origin,destination;
	      	 
	  		// Instanciation de la classe test
	  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
	  		
	  		// On affiche l'algo utilisé
	  		System.out.println("-- Algo : Dijkstra classique --");
			
			String mapName = "insa.mapgr";
			Mode modetest=Mode.TIME;
			
	  		System.out.println("-- Mode : "+ modetest.toString() +" --\n");
			System.out.println("-- Carte : "+ mapName +" --");
			
			System.out.println("-- Cas normal 1 --");
			origin = 50 ;
			destination = 1110;
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
			origin = 1218 ;
			destination = 4852;
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
