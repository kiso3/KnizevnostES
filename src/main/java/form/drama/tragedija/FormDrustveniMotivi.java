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

public class FormDrustveniMotivi extends OpstaEkranskaForma{
	
	private JLabel lblPitanje;
	private JButton btnIstorijski;
	private JButton btnLjubavni;
	private JButton btnMoraliteti;
	private JButton btnPocetna;
	
	public FormDrustveniMotivi(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnIstorijski();
		postavibtnLjubavni();
		postavibtnMoralitet();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnIstorijski = new JButton();
		btnLjubavni = new JButton();			
		btnMoraliteti = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Kojeg karaktera bi trebalo da bude delo?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnIstorijski(){
		btnIstorijski.setAction(new AbstractAction("Istorijskog") {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDrustvenihDela("Istorijski");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnIstorijski.setSize(btnIstorijski.getPreferredSize());
		btnIstorijski.setLocation(10, 40);
		add(btnIstorijski);
	}
	
	void postavibtnLjubavni(){
		btnLjubavni.setAction(new AbstractAction("Lubavnog") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDrustvenihDela("Ljubavni");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnLjubavni.setSize(btnLjubavni.getPreferredSize());
		btnLjubavni.setLocation(150, 40);
		add(btnLjubavni);
	}
	
	void postavibtnMoralitet(){
		btnMoraliteti.setAction(new AbstractAction("Moralitet") {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDrustvenihDela("Moralitet");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnMoraliteti.setSize(btnMoraliteti.getPreferredSize());
		btnMoraliteti.setLocation(320, 40);
		add(btnMoraliteti);
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
