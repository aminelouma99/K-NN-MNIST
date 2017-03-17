 
import java.util.Scanner;
import java.io.*;
 



import java.text.DecimalFormat;


public class Test extends MainProg  {
	static int INF = 1000000000;
	static int BigCellLength = 4;
	static int SmallCellLength = 2;
	static double rate;
	
	static int NeighborsIndex[];
	static int NeighborsDistance[];
	static int CountingLabel[] = new int [10];
	Scanner sc = new Scanner(System.in);
	static boolean viewed;
	
	
	public static void GetData() throws IOException {
		BufferedInputStream image = new BufferedInputStream(new FileInputStream(Testing_Image_Directory));
		BufferedInputStream label = new BufferedInputStream(new FileInputStream(Testing_Label_Directory));
		
		for (int i = 0; i < 16; i++) {
		}
			
		for (int i = 0; i < 8; i++) {
		}
		
		TestingSample = new aSample [nTesting];
		
		for (int i = 0; i < nTesting; i++){
			TestingSample[i] = new aSample();
			TestingSample[i].image = new int [width][height];
			
			input(image, TestingSample[i].image);
			TestingSample[i].label = label.read();
		}
		
		image.close();
		label.close();
	}
	public static int search(int Matrix[][]){
		for (int i = 0; i < K; i++)
			NeighborsDistance[i] = INF;
		
		for (int i = 0; i < nTraining; i++){
			int dist = Manhattan(Matrix, TrainingSample[i].image);
			
			for (int j = 0; j < K; j++)
				if (dist < NeighborsDistance[j]){
					for (int v = K - 1; v > j; v--){
						NeighborsDistance[v] = NeighborsDistance[v - 1];
						NeighborsIndex[v] = NeighborsIndex[v - 1];
					}
					NeighborsDistance[j] = dist;
					NeighborsIndex[j] = i;
					break;
				}
		}
		
		for (int i = 0; i < 10; i++) CountingLabel[i] = 0;
		for (int i = 0; i < K; i++){
			int j = TrainingSample[NeighborsIndex[i]].label;
			CountingLabel[j]++;
		}
		
		int res = 0;
		for (int i = 1; i < 10; i++)
			if (CountingLabel[i] > CountingLabel[res])
				res = i;
		
		return res;
	}
	public static double roundTwoDecimals(double d){ //arrondir un double en deux décimales 
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    System.out.println("test" + twoDForm);
	    return Double.valueOf(twoDForm.format(d));
	}
	public static void showResult(int index){
		int res = search(TestingSample[index].image);
		int ans = TestingSample[index].label;
		
		if (res == ans){
			rate += 100.0 / nTesting;
			//System.out.println("Recognition rate: " + Double.toString(roundTwoDecimals(rate)) + "%");
		}
		
		System.out.println("Sample: " + Integer.toString(index + 1));
		System.out.println("Label: " + ans);
		System.out.println("Predict: " + res);
		
		
	}
	
	public static void TestingProcess(){
		
		
		
	
		for (int i = 0; i < nTesting; i++){
		showResult(i);
		
		}
	}
	
	public Test() throws IOException {
		if (nTraining == 0){
			System.out.println( "There is no training data!");
			return;
		}
		System.out.println( "n testing please");	
		nTesting = sc.nextInt();		
		if ((nTesting <= 0) || (nTesting > Default_nTesting)){
			System.out.println("Number of testing samples is not valid!");
			return;
		}
		System.out.println("k please");
		K = sc.nextInt();
		if ((K <= 0) || (K > nTraining)){
			System.out.println( "Number of neighbors is not valid!");
			return;
		}
		
		NeighborsIndex = new int [K];
		NeighborsDistance = new int [K];
		
		
		rate = 0.0;
		
		
		
		GetData();
		TestingProcess();
		

	}
	
}

	
	


