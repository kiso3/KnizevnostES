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

public class FormFabula extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnObimnoDelo;
	private JButton btnKraceDelo;		
	private JButton btnPocetna;
	
	public FormFabula(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnObimnoDelo();
		postavibtnKraceDelo();		
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnObimnoDelo = new JButton();
		btnKraceDelo = new JButton();		
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Da li želite da delo bude kraće ili obimno?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnObimnoDelo(){
		btnObimnoDelo.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVelicinaDela("Obimno delo");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	            	            
	        }
	    });
		btnObimnoDelo.setText("Obimno delo");
		btnObimnoDelo.setSize(btnObimnoDelo.getPreferredSize());
		btnObimnoDelo.setLocation(10, 40);
		add(btnObimnoDelo);
	}
	
	void postavibtnKraceDelo(){
		btnKraceDelo.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVelicinaDela("Kratko delo");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnKraceDelo.setText("Kratko delo");
		btnKraceDelo.setSize(btnKraceDelo.getPreferredSize());
		btnKraceDelo.setLocation(200, 40);
		add(btnKraceDelo);
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
