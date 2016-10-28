import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ElencoFatture{

	ArrayList<Fattura> elencoFatture = new ArrayList<Fattura>();

	public void LeggiFileFatture(String fileName) throws IOException{
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		ArrayList<String> lines = new ArrayList<String>(); String line;
		while((line = bufferedReader.readLine()) != null){ lines.add(line);}
		bufferedReader.close();
		for (int i=0;i<lines.size();i++){
			String delims = "; ";
			String[] tokens = lines.get(i).split(delims);
			delims = "[/]";
			String[] dataTokens = tokens[1].split(delims);
			Data data = new Data(Integer.parseInt(dataTokens[0]),Integer.parseInt(dataTokens[1]),Integer.parseInt(dataTokens[2]));
			Fattura fattura = new Fattura(tokens[0],data,tokens[2]);
			elencoFatture.add(fattura);
		}
	}

	public void ScriviFileFatture(String fileName) throws IOException{
		FileWriter fileWriter = new FileWriter(fileName); 
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(int i=0;i<elencoFatture.size();i++){
			bufferedWriter.write(elencoFatture.get(i).NumeroFattura + " " + elencoFatture.get(i).DataFattura.Giorno + "/" + elencoFatture.get(i).DataFattura.Mese + "/" +elencoFatture.get(i).DataFattura.Anno + " " +  elencoFatture.get(i).DataScadenza.Giorno + "/" + elencoFatture.get(i).DataScadenza.Mese + "/" +elencoFatture.get(i).DataScadenza.Anno);
			if(i<elencoFatture.size()-1){bufferedWriter.newLine();}
		}
		bufferedWriter.close();
	}

	public void bubblesort(){
		Boolean scambio = true;
		while(scambio){
			scambio=false;
			for(int i=0;i<elencoFatture.size()-1;i++){
				if(elencoFatture.get(i+1).DataFattura.ePrimaDi(elencoFatture.get(i).DataFattura)){
					Fattura temp = elencoFatture.get(i);
					elencoFatture.set(i,elencoFatture.get(i+1));
					elencoFatture.set(i+1,temp);
					scambio=true;
				}
			}
		}
	}


	public void quicksort(int lo, int hi){
		if (lo < hi){
			int p  = partition(elencoFatture, lo, hi);
			quicksort(lo, p-1);
			quicksort(p+1, hi);
			}
		}

	public int partition(ArrayList<Fattura> elencofatture,int lo, int hi){
		Data pivot = elencofatture.get(hi).DataScadenza;
		int i = lo;
		for (int j = lo;j<hi;j++){
			if( elencofatture.get(j).DataScadenza.ePrimaDi(pivot)){
				Fattura temp =  elencofatture.get(i);
				elencofatture.set(i, elencofatture.get(j));
				elencofatture.set(j, temp);
				i++;
				}
			}
		Fattura temp =  elencofatture.get(i);
		elencofatture.set(i, elencofatture.get(hi));
		elencofatture.set(hi, temp);
		return i;
		}

	public int size(){return elencoFatture.size();}
	public Fattura get(int i){return elencoFatture.get(i);}
	
	public void CalcolaScadenze(){for(int i=0;i<elencoFatture.size();i++){elencoFatture.get(i).CalcolaScadenza();}
}

}