public class Fattura{

	String NumeroFattura;
	Data DataFattura;
	String ModalitaPagamento;
	Data DataScadenza;

	public Fattura(){}
	public Fattura(String numerofattura, Data datafattura, String tipofattura){
		NumeroFattura=numerofattura;
		DataFattura=datafattura;
		ModalitaPagamento=tipofattura;
	}

	public void CalcolaScadenza(){
		Data scadenza= new Data();
		switch (ModalitaPagamento) {
			case "DF": scadenza = DataFattura; break;
			case "DFFM": scadenza = DataFattura.FineMese(); break;
			case "DF60": scadenza = DataFattura.PiuSessantaGiorni(); break;
		}
		DataScadenza=scadenza;
	}
}