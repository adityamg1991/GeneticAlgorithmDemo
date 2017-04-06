package aditya.ds.example;

public class Driver {
	
	private static int generationNumber = 1;;
	
	public static void main(String args[]) {
		
		Population population = new Population(Constants.POPULATION_SIZE);
		GeneticAlgorithm genAlgo = new GeneticAlgorithm();
		population.sortChromosomesByFitness(Constants.POPULATION_SIZE);
		System.out.println(population.toString(true));
		printGeneration();
		
		while ((population.getChromosomes()[0]).getFitness() != Constants.GENE_LENGTH) {
			generationNumber++;
			population = genAlgo.evolvePopulation(population);
			population.sortChromosomesByFitness(Constants.POPULATION_SIZE);
			System.out.println(population.toString(true));
			printGeneration();
		}
		
	}
	
	private static void printGeneration() {
		System.out.println("Generation: " + generationNumber);
		System.out.println("------------------------------");
		System.out.println();
	}
	
}
