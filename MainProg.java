import java.io.BufferedInputStream;
import java.io.IOException;

import java.util.Scanner;




public class MainProg extends Constantes {
	
	static int width = 28;
	static int height = 28;
	
	static class aSample { //notre echantillon de travail
		
		public int image[][];
		public int label;
	}
	
	static aSample TrainingSample[];
	static aSample TestingSample[];
	
	int aByte;
	private static Scanner sc;
	
	public static void input(BufferedInputStream image, int Matrix[][]) throws IOException{ //réaliser la lecture des image et les stocker dans une matrice
		int u, v;
		for (v = 0; v < height; v++)
			for (u = 0; u < width; u++)
				Matrix[u][v] = image.read();
	}
	
	public static int Manhattan(int Matrix1[][], int Matrix2[][]){ // la distance de manhattan 
		int sum = 0;
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				sum += Math.abs(Matrix1[i][j] - Matrix2[i][j]);
		return sum;
	}
	
	
	
	
	
	
	
	public static void Process() throws IOException {
		sc = new Scanner(System.in);
		System.out.println("Training or Testing ??");
		while (true){
			String name = sc.next();
			
			if (name.equals("Training")) new Training();
			
			if (name.equals("Testing")) new Test();
			
		}
	}
	
	
	
	

	public static void main(String[] args)  throws IOException {
		
		Process();
	
	}

}
