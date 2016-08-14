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

public class FormLikoviFabula extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnPravoLice;
	private JButton btnTreceLice;	
	private JButton btnPocetna;
	
	public FormLikoviFabula(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnPravoLice();
		postavibtnTreceLice();		
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnPravoLice = new JButton();
		btnTreceLice = new JButton();		
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koji način pripovedanja bi se voleli da bude u delu?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnPravoLice(){
		btnPravoLice.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setTipPripovedaca("1 lice");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnPravoLice.setText("1 lice");
		btnPravoLice.setSize(btnPravoLice.getPreferredSize());
		btnPravoLice.setLocation(10, 40);
		add(btnPravoLice);
	}
	
	void postavibtnTreceLice(){
		btnTreceLice.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setTipPripovedaca("3 lice");
	            KoordinatorForm.instance().setKnjizevnost(k);	
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnTreceLice.setText("3 lice");
		btnTreceLice.setSize(btnTreceLice.getPreferredSize());
		btnTreceLice.setLocation(200, 40);
		add(btnTreceLice);
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
