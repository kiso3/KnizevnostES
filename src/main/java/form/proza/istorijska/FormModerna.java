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

public class FormModerna extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnLjubavnaTematikaDa;
	private JButton btnLjubavnaTematikaNe;	
	private JButton btnPocetna;
	
	public FormModerna(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnLjubavnaTematikaDa();
		postavibtnLjubavnaTematikaNe();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnLjubavnaTematikaDa = new JButton();
		btnLjubavnaTematikaNe = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Da li želite da ljubavna tematika bude prisutna u delu?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnLjubavnaTematikaDa(){
		btnLjubavnaTematikaDa.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setLjubavnaTematika("Prisutna");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().postaviFormu(new FormLjubavnaTematikaDa());
	        }
	    });
		btnLjubavnaTematikaDa.setText("Da");
		btnLjubavnaTematikaDa.setSize(btnLjubavnaTematikaDa.getPreferredSize());
		btnLjubavnaTematikaDa.setLocation(10, 40);
		add(btnLjubavnaTematikaDa);
	}
	
	void postavibtnLjubavnaTematikaNe(){
		btnLjubavnaTematikaNe.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setLjubavnaTematika("Nije prisutna");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormLjubavnaTematikaNe());
	        }
	    });
		btnLjubavnaTematikaNe.setText("Ne");
		btnLjubavnaTematikaNe.setSize(btnLjubavnaTematikaNe.getPreferredSize());
		btnLjubavnaTematikaNe.setLocation(200, 40);
		add(btnLjubavnaTematikaNe);
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
