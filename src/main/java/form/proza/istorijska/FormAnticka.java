package form.proza.istorijska;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormAnticka extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnGrcka;
	private JButton btnRim;	
	private JButton btnPocetna;
	
	public FormAnticka(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnGrcka();
		postavibtnRim();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnGrcka = new JButton();
		btnRim = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Iz kog antičkog perioda bi voleli da delo bude?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnGrcka(){
		btnGrcka.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskaPodelaAtickiPeriod("Grcka");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().postaviFormu(new FormGrcka());
	            
	        }
	    });
		btnGrcka.setText("Grčki period");
		btnGrcka.setSize(btnGrcka.getPreferredSize());
		btnGrcka.setLocation(10, 40);
		add(btnGrcka);
	}
	
	void postavibtnRim(){
		btnRim.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskaPodelaAtickiPeriod("Rim");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnRim.setText("Rimski period");
		btnRim.setSize(btnRim.getPreferredSize());
		btnRim.setLocation(150, 40);
		add(btnRim);
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
