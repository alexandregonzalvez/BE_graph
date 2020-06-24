package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.*;
import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.junit.Test;

public class PerformanceDijkstraAStar {

	@Test
	public void testLength1() throws Exception {
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
		
		String mapName;
		int nbSommets;
		
		
		// TEST 1 MAP = Toulouse : Length
		System.out.println("TEST N°1----------------------------------------------");
		mapName = "toulouse.mapgr";
		nbSommets=39857;
		executeNTestOnAMap(cheminVersMaps,mapName,nbSommets,Mode.LENGTH);
		System.out.println("-------FIN TEST N°1\n");

	}
	
	@Test
	public void testLength2() throws Exception {
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
		
		String mapName;
		int nbSommets;
		
		// TEST 2 MAP = Paris : LENGTH
		System.out.println("TEST N°2----------------------------------------------");
		mapName = "paris.mapgr";
		nbSommets=48432;
		executeNTestOnAMap(cheminVersMaps,mapName,nbSommets,Mode.LENGTH);
		System.out.println("-------FIN TEST N°2\n");
	}
	

	
	@Test
	public void testTime1() throws Exception {
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
		
		String mapName;
		int nbSommets;
		
		// TEST 3 MAP = Toulouse : TIME
		System.out.println("TEST N°3----------------------------------------------");
		mapName = "toulouse.mapgr";
		nbSommets=39857;
		executeNTestOnAMap(cheminVersMaps,mapName,nbSommets,Mode.TIME);
		System.out.println("-------FIN TEST N°3\n");
	}
	
	@Test
	public void testTime2() throws Exception {
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
		
		String mapName;
		int nbSommets;
		
		// TEST 4 MAP = Paris : TIME
		System.out.println("TEST N°4----------------------------------------------");
		mapName = "paris.mapgr";
		nbSommets=48432;
		executeNTestOnAMap(cheminVersMaps,mapName,nbSommets,Mode.TIME);
		System.out.println("-------FIN TEST N°4\n");
	}
	
	public void executeNTestOnAMap(String cheminVersMaps,String mapName,int nbSommets,Mode modeTest) throws Exception {
		// Constante(s)
		int NB_EXECUTION=20;
		
		// Variables
  		int origin,destination;
  		long startTime,endTime,timeElapsedBF,timeElapsedD,timeElapsedDAStar;
  		int valid; // On ne prend les valeurs que si la solution est valide
  		
  		// Initialisation des classes de tests
  		solutionBellmanFord soluceBellmanFord = new solutionBellmanFord();
  		solutionDijkstraTest soluceDijkstra=new solutionDijkstraTest();
  		solutionDijkstraAStarTest soluceDijkstraAStar=new solutionDijkstraAStarTest();
  		
  		
		

		//-- TEST -- NB_EXECUTION executions de l'algorithme 
  		timeElapsedBF=0;
		timeElapsedD=0;
		timeElapsedDAStar=0;
		System.out.println(NB_EXECUTION+" executions des algorithmes sur la carte : "+mapName+" en mode : "+modeTest.toString()+"\n");
		
		int Max=nbSommets;// Nombre de sommets dans toulouse.mapgr
		
		for(int i=0;i<NB_EXECUTION;i++) {
			System.out.println("**Execution"+(i+1)+"\n");
			
			// Initialisation d'une origine et destination aléatoire
			origin=(int)(Math.random() * (Max  + 1));
			destination=(int)(Math.random() * (Max + 1));
			
			// BellmanFord 
			startTime=System.nanoTime();
			valid = soluceBellmanFord.execute(cheminVersMaps+mapName,origin,destination,modeTest);
			endTime=System.nanoTime();
			if(valid==1) {
				timeElapsedBF+=endTime-startTime;
			}
			System.out.println("Total time elapsed = "+timeElapsedBF);

			System.out.println("\n");
			
			// Dijkstra classique
			startTime=System.nanoTime();
			valid = soluceDijkstra.execute(cheminVersMaps+mapName,origin,destination,modeTest);
			endTime=System.nanoTime();
			if(valid==1) {
				timeElapsedD+=endTime-startTime;
			}
			System.out.println("Total time elapsed = "+timeElapsedD);

			System.out.println("\n");
			
			// AStar
			startTime=System.nanoTime();
			valid=soluceDijkstraAStar.execute(cheminVersMaps+mapName,origin,destination,modeTest);
			endTime=System.nanoTime();
			if(valid==1) {
				timeElapsedDAStar+=endTime-startTime;
			}
			System.out.println("Total time elapsed = "+timeElapsedDAStar);
			System.out.println("\n");
		}
		
		double moyBF=timeElapsedBF/1000000000.0;// 1000000000 pour avoir le temps en seconde
		double moyD=timeElapsedD/1000000000.0;// 1000000000 pour avoir le temps en seconde
		double moyDAStar=timeElapsedDAStar/1000000000.0;// 1000000000 pour avoir le temps en seconde
		
		System.out.println("Temps d'execution de Bellman Ford en seconde = "+moyBF);
		System.out.println("Temps d'execution de Dijkstra en seconde = "+moyD);
		System.out.println("Temps d'execution de A Star en seconde = "+moyDAStar);
		
		System.out.println("");
		
		System.out.println("Sur ces "+NB_EXECUTION+" executions l'algorithme Dijkstra est "+(double)moyBF/moyD+" fois meilleur que l'algorithme de Bellman Ford\n");
		System.out.println("Sur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyBF/moyDAStar+" fois meilleur que l'algorithme de Bellman Ford\n");
		System.out.println("Sur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyD/moyDAStar+" fois meilleur que l'algorithme de Dijkstra\n");
		
		assertTrue(timeElapsedBF > timeElapsedD); // On vérifie que l'algorithme de Dijkstra est plus rapide que celui de BellmanFord
		assertTrue(timeElapsedBF > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de BellmanFord
		assertTrue(timeElapsedD > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de Dijkstra classique

	}

}
