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

public class FormGrcka extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnOdlazakJunaka;
	private JButton btnPovratakJunaka;	
	private JButton btnPocetna;
	
	public FormGrcka(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnOdlazakJunaka();
		postavibtnPovratakJunaka();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnOdlazakJunaka = new JButton();
		btnPovratakJunaka = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Izaberite neku od ponuđenih karakterisitka grčkih istoriskih dela.");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnOdlazakJunaka(){
		btnOdlazakJunaka.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setOdlazakPovratakJunaka("Odlazak junaka u rat");
	            KoordinatorForm.instance().setKnjizevnost(k);	
	            KoordinatorForm.instance().gtePdf();
	            	            
	        }
	    });
		btnOdlazakJunaka.setText("Odlazak junaka u rat");
		btnOdlazakJunaka.setSize(btnOdlazakJunaka.getPreferredSize());
		btnOdlazakJunaka.setLocation(10, 40);
		add(btnOdlazakJunaka);
	}
	
	void postavibtnPovratakJunaka(){
		btnPovratakJunaka.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setOdlazakPovratakJunaka("Povratak junaka iz rata");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();	            
	        }
	    });
		btnPovratakJunaka.setText("Povratak junaka iz rat");
		btnPovratakJunaka.setSize(btnPovratakJunaka.getPreferredSize());
		btnPovratakJunaka.setLocation(200, 40);
		add(btnPovratakJunaka);
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
