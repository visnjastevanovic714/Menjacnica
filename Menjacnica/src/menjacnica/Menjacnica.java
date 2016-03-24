package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterface;

public class Menjacnica implements MenjacnicaInterface {

	LinkedList<Valuta> valute = new LinkedList<Valuta>();
	
	@Override
	public void dodajKurs(String naziv, Kurs kurs) {
		for(int i=0;i<valute.size();i++){
			if(valute.get(i).getNaziv().equals(naziv))
				valute.get(i).getKursevi().add(kurs);
		}
	}

	@Override
	public void obrisiKurs(String naziv, Kurs kurs) {
		for(int i=0;i<valute.size();i++){
			if(valute.get(i).getNaziv().equals(naziv))
				valute.get(i).getKursevi().remove(kurs);
		}
	}

	@Override
	public Kurs pronadjiVratiKurs(String naziv, GregorianCalendar dan) {
		Kurs k = new Kurs();
		for(int i=0;i<valute.size();i++){
			if(valute.get(i).getNaziv().equals(naziv)){
				for(int j=0;j<valute.get(i).getKursevi().size();j++){
					if(valute.get(i).getKursevi().get(j).getDatum().equals(dan))
						k = valute.get(i).getKursevi().get(j);
				}			
			}
				
		}
		return k;
	}

}
