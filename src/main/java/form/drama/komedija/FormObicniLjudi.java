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

public class FormObicniLjudi extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnEruditna;
	private JButton btnKomedijaKaraktera;
	private JButton btnKomedijaZapleta;
	private JButton btnPocetna;
	
	public FormObicniLjudi(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnEruditna();
		postavibtnKomedijaKaraktera();
		postaviBrnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnEruditna = new JButton();
		btnKomedijaKaraktera = new JButton();
		btnKomedijaZapleta = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koju vrstu dramske komedije bi voleli da čitate");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnEruditna(){
		btnEruditna.setAction(new AbstractAction("Euruitna") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDramskeKomedije("Euruitna");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	            
	        }
	    });	
		btnEruditna.setSize(btnEruditna.getPreferredSize());
		btnEruditna.setLocation(10, 40);
		add(btnEruditna);
	}
	
	void postavibtnKomedijaKaraktera(){
		btnKomedijaKaraktera.setAction(new AbstractAction("Kmedija karaktera") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDramskeKomedije("Komedija karaktera");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnKomedijaKaraktera.setSize(btnKomedijaKaraktera.getPreferredSize());
		btnKomedijaKaraktera.setLocation(150, 40);
		add(btnKomedijaKaraktera);
	}

	void postaviBrnModerna(){
		btnKomedijaZapleta.setAction(new AbstractAction("Komedija zapleta") {
	        public void actionPerformed(ActionEvent e) {	        
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDramskeKomedije("Komedija zapleta");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnKomedijaZapleta.setSize(btnKomedijaZapleta.getPreferredSize());
		btnKomedijaZapleta.setLocation(340, 40);
		add(btnKomedijaZapleta);
	}
	
	void postaviBtnPocetna(){
		btnPocetna.setAction(new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	//Knizevnost k = KoordinatorForm.instance().getKnjizevnost();	        	
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
