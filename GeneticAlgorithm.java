package aditya.ds.example;

import java.util.Random;

public class GeneticAlgorithm {

	public Chromosome mutateChromosome(Chromosome chrome) {
		
		Chromosome alteredChromosome = new Chromosome();
		for (int i=0; i<Constants.GENE_LENGTH; i++) {
			if (Math.random() < Constants.MUTATE_PROBABILITY) {
				if (Math.random() < 0.5) {
					alteredChromosome.getGenes()[i] = 1;
				} else {
					alteredChromosome.getGenes()[i] = 0;
				}
			} else {
				alteredChromosome.getGenes()[i] = chrome.getGenes()[i];
			}
		}
		return alteredChromosome;
		
	}
	
	
	public Population evolvePopulation(Population population) {
		return crossoverPopulation(mutatePopulation(population));
	}
	
	
	public Population mutatePopulation(Population population) {
		Population mutatedPopulation = new Population(Constants.POPULATION_SIZE);
		for (int i=0; i<Constants.NUM_OF_ELITE_CHROMOSOME; i++) {
			mutatedPopulation.getChromosomes()[i] = population.getChromosomes()[i];
		}
		for (int i=Constants.NUM_OF_ELITE_CHROMOSOME; i<Constants.POPULATION_SIZE; i++) {
			mutatedPopulation.getChromosomes()[i] = mutateChromosome(population.getChromosomes()[i]);
		}
		return mutatedPopulation;
	}
	
	
	public Population crossoverPopulation(Population population) {
		Population crossedPopulation = new Population(Constants.POPULATION_SIZE);
		for (int i=0; i<Constants.NUM_OF_ELITE_CHROMOSOME; i++) {
			crossedPopulation.getChromosomes()[i] = population.getChromosomes()[i];
		}
		for (int i=Constants.NUM_OF_ELITE_CHROMOSOME; i<Constants.POPULATION_SIZE; i++) {
			Chromosome cm1 = selectTournamentPopulation(population).getChromosomes()[0];
			Chromosome cm2 = selectTournamentPopulation(population).getChromosomes()[0];
			crossedPopulation.getChromosomes()[i] = crossoverChromosome(cm1, cm2);
		}
		return crossedPopulation;
	}
	
	
	public Chromosome crossoverChromosome(Chromosome cm1, Chromosome cm2) {
		Chromosome crossedChromosome = new Chromosome();
		for (int i=0; i<Constants.GENE_LENGTH; i++) {
			if (Math.random() < 0.5) {
				crossedChromosome.getGenes()[i] = cm1.getGenes()[i];
			} else {
				crossedChromosome.getGenes()[i] = cm2.getGenes()[i];
			}
		}
		return crossedChromosome;
	}
	

	public Population selectTournamentPopulation(Population population) {
		Random random = new Random();
		Population tournamentPopulation = new Population(Constants.TOURNAMENT_SIZE);
		for (int i=0; i<Constants.TOURNAMENT_SIZE; i++) {
			tournamentPopulation.getChromosomes()[i] = 
					population.getChromosomes()[random.nextInt(Constants.TOURNAMENT_SIZE)];
		}
		tournamentPopulation.sortChromosomesByFitness(Constants.TOURNAMENT_SIZE);
		return tournamentPopulation;
	}
	
}
