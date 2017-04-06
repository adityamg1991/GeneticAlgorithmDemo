package aditya.ds.example;


public class Population {

	private Chromosome[] chromosomes;
	
	public Population(int length) {
		chromosomes = new Chromosome[length];
		initializePopulation(length);
	}

	
	private void initializePopulation(int length) {
		for (int i=0; i<length; i++) {
			Chromosome unit = new Chromosome();
			chromosomes[i] = unit;
		}
	}
	
	public Chromosome[] getChromosomes() {
		return chromosomes;
	}
	
	public Population getPopulation() {
		return this;
	}
	
	public String toString(boolean showFitness) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<Constants.POPULATION_SIZE; i++) {
			if (showFitness) {
				sb.append(this.getChromosomes()[i].toStringWithFitness());
			} else {
				sb.append(this.getChromosomes()[i].toString());
			}
			sb.append("\n");
		}
		sb.append("------------------------------");
		return sb.toString();
	}
	
	public String toString() {
		return "Kindly specify whether fitness is to be shown or not";
	}
	
	
	public Chromosome[] sortChromosomesByFitness(int length) {
		
		Chromosome temp = new Chromosome();
		for (int i=0; i<length; i++) {
			for (int j=0; j<length-1; j++) {
				if (this.getChromosomes()[j].getFitness() 
						< this.getChromosomes()[j+1].getFitness()) {
					temp = getChromosomes()[j];
					this.getChromosomes()[j] = this.getChromosomes()[j+1];
					this.getChromosomes()[j+1] = temp;
					
				}
			}
		}
		return this.getChromosomes();
	}
}
