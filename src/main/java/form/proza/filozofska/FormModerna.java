package form.proza.filozofska;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormModerna extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnLikovi;
	private JButton btnFabula;
	private JButton btnLikoviFabula;
	private JButton btnPocetna;
	
	public FormModerna(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnLikovi();
		postavibtnFabula();
		postavibtnLikoviFabula();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnLikovi = new JButton();
		btnFabula = new JButton();
		btnLikoviFabula = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Da li više volide dela sa dominaciojm likova ili fabule?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnLikovi(){
		btnLikovi.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setDominanatniLikovi(true);
	        	k.setDominantnaFabula(false);
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().postaviFormu(new FeomLikovi());	            
	        }
	    });
		btnLikovi.setText("Dominantni likovi");
		btnLikovi.setSize(btnLikovi.getPreferredSize());
		btnLikovi.setLocation(10, 40);
		add(btnLikovi);
	}
	
	void postavibtnFabula(){
		btnFabula.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setDominanatniLikovi(false);
	        	k.setDominantnaFabula(true);
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormFabula());
	        }
	    });
		btnFabula.setText("Dominantna fabula");
		btnFabula.setSize(btnFabula.getPreferredSize());
		btnFabula.setLocation(170, 40);
		add(btnFabula);
	}
	
	void postavibtnLikoviFabula(){
		btnLikoviFabula.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setDominanatniLikovi(true);
	        	k.setDominantnaFabula(true);
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormLikoviFabula());
	        }
	    });
		btnLikoviFabula.setText("Likovi i fabula");
		btnLikoviFabula.setSize(btnLikoviFabula.getPreferredSize());
		btnLikoviFabula.setLocation(350, 40);
		add(btnLikoviFabula);
	}
	
	void postaviBtnPocetna(){
		btnPocetna.setAction(new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {  	
	        	KoordinatorForm.instance().resetujEkspertniSistem();
	            KoordinatorForm.instance().postaviFormu(new FormPocetna());
			}
		});

		btnPocetna.setText("Početna");
		btnPocetna.setVerticalTextPosition(SwingConstants.BOTTOM);		
		btnPocetna.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPocetna.setSize(btnPocetna.getPreferredSize());
		btnPocetna.setLocation(10, 300);
		add(btnPocetna);
	}
}
