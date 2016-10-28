public class Data {

	int Giorno;
	int Mese;
	int Anno;
    public Data(){}
    public Data(int giorno, int mese, int anno){
    	Giorno=giorno;
    	Mese=mese;
    	Anno=anno;
    }
    
	  public Data FineMese(){
		  int giorno=0;
		  switch (Mese){
	    	case 1: giorno=31;break;
          	case 2: giorno= this.eBisestile() ? 29 : 28;break;
          	case 3: giorno=31;break;
          	case 4: giorno=30;break;
          	case 5: giorno=31;break;
          	case 6: giorno=30;break;
          	case 7: giorno=31;break;
          	case 8: giorno=31;break;
          	case 9: giorno=30;break;
          	case 10: giorno=31;break;
          	case 11: giorno=30;break;
          	case 12: giorno=31;break;
          }
	  	Data nuova = new Data(giorno,Mese,Anno);
	  	return nuova;
	  }

	  public Data PiuSessantaGiorni(){
		 int giorno; int mese; int anno;
		 if(Mese<11){mese=Mese+2;anno=Anno;}
         else{anno=Anno+1;mese=(Mese+2)%12;}
		 giorno = (Giorno>ultimoGiorno(mese,anno)) ? ultimoGiorno(mese,anno) : Giorno;
		 Data nuova = new Data(giorno,mese,anno);
		 return nuova;
	  }
	  
	  public Boolean eBisestile(){
		  Boolean ans;
		  ans = ((Anno%4)==0 && (Anno%100)!=0) || Anno%400==0;
		  return ans;
	  }
	  
	  public int ultimoGiorno(int mese,int anno){
		  int giorno=0;

		  switch (mese){
		  	case 1: giorno=31;break;
		  	case 2: giorno= annoBisestile(anno) ? 29 : 28;break;
		  	case 3: giorno=31;break;
		  	case 4: giorno=30;break;
		  	case 5: giorno=31;break;
		  	case 6: giorno=30;break;
		  	case 7: giorno=31;break;
    		case 8: giorno=31;break;
    		case 9: giorno=30;break;
    		case 10: giorno=31;break;
    		case 11: giorno=30;break;
    		case 12: giorno=31;break;
		  	}
	  	return giorno;
	  }
	  
	  public Boolean annoBisestile(int anno){
		  Boolean ans;
		  ans = ((anno%4)==0 && (anno%100)!=0) || (anno%400==0);

		  return ans;
	  }
	  
	  public Boolean ePrimaDi(Data data){
		  if(Anno<data.Anno){return true;}
		  else if(Anno==data.Anno && Mese<data.Mese){return true;}
		  else if(Anno==data.Anno && Mese==data.Mese && Giorno<data.Giorno){return true;}
		  else{return false;}
	  }
}