package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.*;

import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.junit.Test;

public class PerformanceDijkstra {
	// Paramètres
		final String cheminVersMaps ="/Users/Alexandre/Desktop/3eme Annee MIC/Graphes-et-Algorithmes/Maps/";
		
		final int NB_EXECUTION=20;
		final boolean execBF=true;
		
		// TEST 1 MAP = toulouse : Length
		@Test
		public void testPerfLengthToulouse() throws Exception {
			// Déclaration des variables
			String mapName;
			int nbSommets;
	  		long timeElapsedBF,timeElapsedD,timeElapsedDAStar;
	  		double moyBF,moyD,moyDAStar;
	  		
	  		solutionBellmanFord soluceBF = new solutionBellmanFord();
	  		solutionDijkstraTest soluceD = new solutionDijkstraTest();
	  		solutionDijkstraAStarTest soluceDAStar = new solutionDijkstraAStarTest();
	  		
			// Initialisation des variables
			timeElapsedBF=0;
			timeElapsedD=0;
			timeElapsedDAStar=0;
			


			//System.out.println("TEST N°1----------------------------------------------");
			mapName = "toulouse.mapgr";
			nbSommets=39858;
			
			System.out.println("Map = "+mapName+" | Mode = Distance"+" | nb_exec = "+NB_EXECUTION);
			
			// On créer un tableau et on le remplie de position de départ et d'arrivé
			int tabOrigin[]= new int[NB_EXECUTION];
			int tabDestination[]= new int[NB_EXECUTION];
			for(int i=0;i<NB_EXECUTION;i++) {
				tabOrigin[i]=(int)(Math.random() * (nbSommets  + 1));
				tabDestination[i]=(int)(Math.random() * (nbSommets + 1));
			}

			if(execBF) {
				// Execution pour Bellman Ford
				timeElapsedBF=soluceBF.executeNBellmanFord(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
				moyBF=timeElapsedBF/1000000000.0;// 1000000000 pour avoir le temps en seconde
				System.out.println("\tTemps d'execution de Bellman Ford en seconde = "+moyBF);
			}
			
			// Execution pour Dijkstra
			timeElapsedD=soluceD.executeNDijkstra(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
			moyD=timeElapsedD/1000000000.0;// 1000000000 pour avoir le temps en seconde
			System.out.println("\tTemps d'execution de Dijkstra en seconde = "+moyD);

			// Execution pour Dijkstra A Star
			timeElapsedDAStar=soluceDAStar.executeNAStar(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
			moyDAStar=timeElapsedDAStar/1000000000.0;// 1000000000 pour avoir le temps en seconde
			System.out.println("\tTemps d'execution de A Star en seconde = "+moyDAStar);
			
			System.out.println();
			
			if(execBF) {
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme Dijkstra est "+(double)moyBF/moyD+" fois meilleur que l'algorithme de Bellman Ford");
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyBF/moyDAStar+" fois meilleur que l'algorithme de Bellman Ford");

				assertTrue(timeElapsedBF > timeElapsedD); // On vérifie que l'algorithme de Dijkstra est plus rapide que celui de BellmanFord
				assertTrue(timeElapsedBF > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de BellmanFord
			}
			
			System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyD/moyDAStar+" fois meilleur que l'algorithme de Dijkstra\n");
			

			
			//System.out.println("-------FIN TEST N°1\n");

		}
		
		// TEST 2 MAP = insa : LENGTH
		@Test
		public void testPerfLengthInsa() throws Exception {
			
			// Déclaration Variables
			String mapName;
			int nbSommets;
			long timeElapsedBF,timeElapsedD,timeElapsedDAStar;
	  		double moyBF,moyD,moyDAStar;

	  		solutionBellmanFord soluceBF = new solutionBellmanFord();
	  		solutionDijkstraTest soluceD = new solutionDijkstraTest();
	  		solutionDijkstraAStarTest soluceDAStar = new solutionDijkstraAStarTest();
			
			// Initialisation
			timeElapsedBF=0;
			timeElapsedD=0;
			timeElapsedDAStar=0;
			
			//System.out.println("TEST N°2----------------------------------------------");
			mapName = "insa.mapgr";
			nbSommets=1349;
			
			System.out.println("Map = "+mapName+" | Mode = Distance"+" | nb_exec = "+NB_EXECUTION);
			
			// On créer un tableau et on le remplie de position de départ et d'arrivé
			int tabOrigin[]= new int[NB_EXECUTION];
			int tabDestination[]= new int[NB_EXECUTION];
			for(int i=0;i<NB_EXECUTION;i++) {
				tabOrigin[i]=(int)(Math.random() * (nbSommets  + 1));
				tabDestination[i]=(int)(Math.random() * (nbSommets + 1));
			}
			if(execBF) {
				// Execution pour Bellman Ford
				timeElapsedBF=soluceBF.executeNBellmanFord(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
			}
			
			// Execution pour Dijkstr
			timeElapsedD=soluceD.executeNDijkstra(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
			
			
			// Execution pour Dijkstra A Star
			timeElapsedDAStar=soluceDAStar.executeNAStar(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.LENGTH);
			
			
			if(execBF) {
				moyBF=timeElapsedBF/1000000000.0;// 1000000000 pour avoir le temps en seconde
				System.out.println("\tTemps d'execution de Bellman Ford en seconde = "+moyBF);
			}
			
			moyD=timeElapsedD/1000000000.0;// 1000000000 pour avoir le temps en seconde
			moyDAStar=timeElapsedDAStar/1000000000.0;// 1000000000 pour avoir le temps en seconde
			
			
			
			System.out.println("\tTemps d'execution de Dijkstra en seconde = "+moyD);
			System.out.println("\tTemps d'execution de A Star en seconde = "+moyDAStar);
			
			System.out.println();
			
			if(execBF) {
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme Dijkstra est "+(double)moyBF/moyD+" fois meilleur que l'algorithme de Bellman Ford");
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyBF/moyDAStar+" fois meilleur que l'algorithme de Bellman Ford");

				assertTrue(timeElapsedBF > timeElapsedD); // On vérifie que l'algorithme de Dijkstra est plus rapide que celui de BellmanFord
				assertTrue(timeElapsedBF > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de BellmanFord
			}
			
			System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyD/moyDAStar+" fois meilleur que l'algorithme de Dijkstra\n");
			
			
			//System.out.println("-------FIN TEST N°2\n");
		}
		

		// TEST 3 MAP = paris : TIME
		@Test
		public void testPerfTimeParis() throws Exception {
			// Déclaration Variables
			String mapName;
			int nbSommets;
			long timeElapsedBF,timeElapsedD,timeElapsedDAStar;
	  		double moyBF,moyD,moyDAStar;

			solutionBellmanFord soluceBF = new solutionBellmanFord();
			solutionDijkstraTest soluceD = new solutionDijkstraTest();
			solutionDijkstraAStarTest soluceDAStar = new solutionDijkstraAStarTest();
					
			// Initialisation
			timeElapsedBF=0;
			timeElapsedD=0;
			timeElapsedDAStar=0;
			
			//System.out.println("TEST N°3----------------------------------------------");
			mapName = "paris.mapgr";
			nbSommets=48432;
			
			System.out.println("Map = "+mapName+" | Mode = Temps"+" | nb_exec = "+NB_EXECUTION);
			
			// On créer un tableau et on le remplie de position de départ et d'arrivé
			int tabOrigin[]= new int[NB_EXECUTION];
			int tabDestination[]= new int[NB_EXECUTION];
			for(int i=0;i<NB_EXECUTION;i++) {
				tabOrigin[i]=(int)(Math.random() * (nbSommets  + 1));
				tabDestination[i]=(int)(Math.random() * (nbSommets + 1));
			}

			if(execBF) {
				// Execution pour Bellman Ford
				timeElapsedBF=soluceBF.executeNBellmanFord(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);		
			}	
			
			// Execution pour Dijkstra
			timeElapsedD=soluceD.executeNDijkstra(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);

			// Execution pour Dijkstra A Star
			timeElapsedDAStar=soluceDAStar.executeNAStar(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);
			
			if(execBF) {
				moyBF=timeElapsedBF/1000000000.0;// 1000000000 pour avoir le temps en seconde
				System.out.println("\tTemps d'execution de Bellman Ford en seconde = "+moyBF);
			}
			
			moyD=timeElapsedD/1000000000.0;// 1000000000 pour avoir le temps en seconde
			moyDAStar=timeElapsedDAStar/1000000000.0;// 1000000000 pour avoir le temps en seconde
			
			
			
			System.out.println("\tTemps d'execution de Dijkstra en seconde = "+moyD);
			System.out.println("\tTemps d'execution de A Star en seconde = "+moyDAStar);
			
			System.out.println();
			
			if(execBF) {
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme Dijkstra est "+(double)moyBF/moyD+" fois meilleur que l'algorithme de Bellman Ford");
				System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyBF/moyDAStar+" fois meilleur que l'algorithme de Bellman Ford");

				assertTrue(timeElapsedBF > timeElapsedD); // On vérifie que l'algorithme de Dijkstra est plus rapide que celui de BellmanFord
				assertTrue(timeElapsedBF > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de BellmanFord
			}
			
			System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyD/moyDAStar+" fois meilleur que l'algorithme de Dijkstra\n");
			
			
			//System.out.println("-------FIN TEST N°3\n");
		}
		
		
		// TEST 4 MAP = Toulouse : TIME
				@Test
				public void testPerfTimeToulouse() throws Exception {
					// Déclaration Variables
					String mapName;
					int nbSommets;
					long timeElapsedBF,timeElapsedD,timeElapsedDAStar;
			  		double moyBF,moyD,moyDAStar;

					solutionBellmanFord soluceBF = new solutionBellmanFord();
					solutionDijkstraTest soluceD = new solutionDijkstraTest();
					solutionDijkstraAStarTest soluceDAStar = new solutionDijkstraAStarTest();
							
					// Initialisation
					timeElapsedBF=0;
					timeElapsedD=0;
					timeElapsedDAStar=0;
					
					//System.out.println("TEST N°3----------------------------------------------");
					mapName = "bordeaux.mapgr";
					nbSommets=15322;
					
					System.out.println("Map = "+mapName+" | Mode = Temps"+" | nb_exec = "+NB_EXECUTION);
					
					// On créer un tableau et on le remplie de position de départ et d'arrivé
					int tabOrigin[]= new int[NB_EXECUTION];
					int tabDestination[]= new int[NB_EXECUTION];
					for(int i=0;i<NB_EXECUTION;i++) {
						tabOrigin[i]=(int)(Math.random() * (nbSommets  + 1));
						tabDestination[i]=(int)(Math.random() * (nbSommets + 1));
					}

					if(execBF) {
						// Execution pour Bellman Ford
						timeElapsedBF=soluceBF.executeNBellmanFord(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);		
					}	
					
					// Execution pour Dijkstra
					timeElapsedD=soluceD.executeNDijkstra(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);

					// Execution pour Dijkstra A Star
					timeElapsedDAStar=soluceDAStar.executeNAStar(cheminVersMaps+mapName,tabOrigin,tabDestination,Mode.TIME);
					
					if(execBF) {
						moyBF=timeElapsedBF/1000000000.0;// 1000000000 pour avoir le temps en seconde
						System.out.println("\tTemps d'execution de Bellman Ford en seconde = "+moyBF);
					}
					
					moyD=timeElapsedD/1000000000.0;// 1000000000 pour avoir le temps en seconde
					moyDAStar=timeElapsedDAStar/1000000000.0;// 1000000000 pour avoir le temps en seconde
					
					
					
					System.out.println("\tTemps d'execution de Dijkstra en seconde = "+moyD);
					System.out.println("\tTemps d'execution de A Star en seconde = "+moyDAStar);
					
					System.out.println();
					
					if(execBF) {
						System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme Dijkstra est "+(double)moyBF/moyD+" fois meilleur que l'algorithme de Bellman Ford");
						System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyBF/moyDAStar+" fois meilleur que l'algorithme de Bellman Ford");

						assertTrue(timeElapsedBF > timeElapsedD); // On vérifie que l'algorithme de Dijkstra est plus rapide que celui de BellmanFord
						assertTrue(timeElapsedBF > timeElapsedDAStar); // On vérifie que l'algorithme de Dijkstra en A Star  est plus rapide que celui de BellmanFord
					}
					
					System.out.println("\tSur ces "+NB_EXECUTION+" executions l'algorithme A Star est "+(double)moyD/moyDAStar+" fois meilleur que l'algorithme de Dijkstra\n");
					
					
					//System.out.println("-------FIN TEST N°3\n");
				}
		

	}