package form.drama.komedija;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormSrednjeVekovna extends OpstaEkranskaForma{
	
	private JLabel lblPitanje;
	private JButton btnObicniLjudi;
	private JButton btnVisokoDrustvo;
	private JButton btnPocetna;
	
	public FormSrednjeVekovna(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnObicniLjudi();
		postavibtnVisokoDrustvo();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {
		lblPitanje = new JLabel();
		btnObicniLjudi = new JButton();
		btnVisokoDrustvo = new JButton();		
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Kakvi bi ljudi voleli da budu u delu?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnObicniLjudi(){
		btnObicniLjudi.setAction(new AbstractAction("Obični ljudi") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKlasnaPodelaDrustva("Obicni ljudi");
	            KoordinatorForm.instance().setKnjizevnost(k);	            
	            KoordinatorForm.instance().postaviFormu(new FormObicniLjudi());
	        }
	    });		
		btnObicniLjudi.setSize(btnObicniLjudi.getPreferredSize());
		btnObicniLjudi.setLocation(10, 40);
		add(btnObicniLjudi);
	}
	
	void postavibtnVisokoDrustvo(){
		btnVisokoDrustvo.setAction(new AbstractAction("Visoko društvo") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKlasnaPodelaDrustva("Visoko drustvo");
	            KoordinatorForm.instance().setKnjizevnost(k);	            
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnVisokoDrustvo.setSize(btnVisokoDrustvo.getPreferredSize());
		btnVisokoDrustvo.setLocation(150, 40);
		add(btnVisokoDrustvo);
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
