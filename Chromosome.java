package aditya.ds.example;

import java.util.Arrays;

public class Chromosome {

	private int genes[];
	
	public Chromosome() {
		genes = new int[Constants.GENE_LENGTH];
		initializeGenes();
	}
	
	private void initializeGenes() {
		
		for (int i=0; i<Constants.GENE_LENGTH; i++) {
			if (Math.random() > 0.5) {
				genes[i] = 0;
			} else {
				genes[i] = 1;
			}
		}
	}
	
	public int[] getGenes() {
		return this.genes;
	}
	
	public String toString() {
		return Arrays.toString(genes);
	}
	
	public String toStringWithFitness() {
		return Arrays.toString(genes) + " (Fitness : " + this.getFitness() + ")";
	}
	
	public int getFitness() {
		int fitnessCount = 0;
		for (int i=0; i<Constants.GENE_LENGTH; i++) {
			if (this.getGenes()[i] == Constants.TARGET_CHROMOSOME[i]) {
				fitnessCount++;
			}
		}
		return fitnessCount;
	}
	
}
