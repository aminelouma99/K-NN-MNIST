import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;




public class Training extends MainProg {
	Scanner sc = new Scanner(System.in);
	
	
	public static void TrainingProcess() throws IOException {
		BufferedInputStream image = new BufferedInputStream(new FileInputStream(Training_Image_Directory));
		BufferedInputStream label = new BufferedInputStream(new FileInputStream(Training_Label_Directory));
		
		int aByte;
		
		for (int i = 0; i < 16; i++)
			aByte = image.read();
			
		for (int i = 0; i < 8; i++)
			aByte = label.read();

		TrainingSample = new aSample [nTraining];
		
		for (int i = 0; i < nTraining; i++){
			TrainingSample[i] = new aSample();
			TrainingSample[i].image = new int [width][height];
			
			input(image, TrainingSample[i].image);
			TrainingSample[i].label = label.read();
			
			System.out.println("Sample: " + Integer.toString(i + 1));
			System.out.println("Label: " + Integer.toString(TrainingSample[i].label));
			
		}
	
	
	image.close();
	label.close();
	new Test();
}
	
	public Training() throws IOException {
		System.out.println("Gime the n training pliz");
		nTraining = sc.nextInt();
		
		if ((nTraining <= 0) || (nTraining > Default_nTraining)){
			System.out.println("Errooooooooor !!!!");
			return;
		}
						
		TrainingProcess();
	
			
	}
	
}

