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

public class FormLjubavnaTematikaNe extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnPsiholoskiProfilisanoDa;
	private JButton btnPsiholoskiProfilisanoNe;
	private JButton btnPsiholoskiProfilisanoSvejedno;
	private JButton btnPocetna;
	
	public FormLjubavnaTematikaNe(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnPsiholoskiProfilisanoDa();
		postavibtnPsiholoskiProfilisanoNe();
		postavibtnPsiholoskiProfilisanoSvejedno();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnPsiholoskiProfilisanoDa = new JButton();
		btnPsiholoskiProfilisanoNe = new JButton();
		btnPsiholoskiProfilisanoSvejedno = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Da li želite psihološki profilisane likove u delu?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnPsiholoskiProfilisanoDa(){
		btnPsiholoskiProfilisanoDa.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setPsiholoskiProfilisaniLikovi("Da");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnPsiholoskiProfilisanoDa.setText("Da");
		btnPsiholoskiProfilisanoDa.setSize(btnPsiholoskiProfilisanoDa.getPreferredSize());
		btnPsiholoskiProfilisanoDa.setLocation(10, 40);
		add(btnPsiholoskiProfilisanoDa);
	}
	
	void postavibtnPsiholoskiProfilisanoNe(){
		btnPsiholoskiProfilisanoNe.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setPsiholoskiProfilisaniLikovi("Ne");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	            
	        }
	    });
		btnPsiholoskiProfilisanoNe.setText("Ne");
		btnPsiholoskiProfilisanoNe.setSize(btnPsiholoskiProfilisanoNe.getPreferredSize());
		btnPsiholoskiProfilisanoNe.setLocation(70, 40);
		add(btnPsiholoskiProfilisanoNe);
	}
	
	void postavibtnPsiholoskiProfilisanoSvejedno(){
		btnPsiholoskiProfilisanoSvejedno.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setPsiholoskiProfilisaniLikovi("Svejedno");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	            
	        }
	    });
		btnPsiholoskiProfilisanoSvejedno.setText("Svejedno");
		btnPsiholoskiProfilisanoSvejedno.setSize(btnPsiholoskiProfilisanoSvejedno.getPreferredSize());
		btnPsiholoskiProfilisanoSvejedno.setLocation(130, 40);
		add(btnPsiholoskiProfilisanoSvejedno);
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
