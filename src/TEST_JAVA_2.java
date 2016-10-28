import java.io.IOException;

public class TEST_JAVA_2{
	
	public static void main(String[] args) throws IOException{
		ElencoFatture elencoFatture = new ElencoFatture();
		elencoFatture.LeggiFileFatture("src/fatture.in");
		elencoFatture.CalcolaScadenze();
		elencoFatture.quicksort(0,elencoFatture.size()-1);
		elencoFatture.ScriviFileFatture("src/fatture.out");
		System.out.println("fatto!");
	}

}