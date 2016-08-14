package form.drama.tragedija;

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
	private JButton btnHorPrisutan;
	private JButton btnHorNijePrisutan;
	private JButton btnPocetna;
	
	public FormAnticka(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postaviBtnHorPrisutan();
		postaviBtnHorNijePrisutan();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnHorPrisutan = new JButton();
		btnHorNijePrisutan = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Da li razumete ulogu Hora u antičkoj drami?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postaviBtnHorPrisutan(){
		btnHorPrisutan.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setUlogaHora("Poznata");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FromPol());
	        }
	    });
		btnHorPrisutan.setText("Razumem je, poznata mi je");
		btnHorPrisutan.setSize(btnHorPrisutan.getPreferredSize());
		btnHorPrisutan.setLocation(10, 40);
		add(btnHorPrisutan);
	}
	
	void postaviBtnHorNijePrisutan(){
		btnHorNijePrisutan.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setUlogaHora("Nije mi poznata");	        	
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnHorNijePrisutan.setText("Ne razumem, nije mi poznata.");
		btnHorNijePrisutan.setSize(btnHorNijePrisutan.getPreferredSize());
		btnHorNijePrisutan.setLocation(250, 40);
		add(btnHorNijePrisutan);
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
