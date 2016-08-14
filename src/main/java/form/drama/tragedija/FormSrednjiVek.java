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

public class FormSrednjiVek extends OpstaEkranskaForma{
		
		private JLabel lblPitanje;
		private JButton btnIgrana;
		private JButton btnPevana;	
		private JButton btnPocetna;
		
		public FormSrednjiVek(){
			this.setLayout(null);
			kreirajKomponenteEkranskeForme();
			postaviLblPitanje();	
			postavibtnIgrana();
			postavibtnPevana();
			postaviBtnPocetna();
		}

		private void kreirajKomponenteEkranskeForme() {

			lblPitanje = new JLabel();
			btnIgrana = new JButton();
			btnPevana = new JButton();			
			btnPocetna = new JButton();
		}
		
		void postaviLblPitanje()
		{  	
			lblPitanje.setText("Da li želite igrana ili pevana dela?");
			lblPitanje.setSize(lblPitanje.getPreferredSize());
			lblPitanje.setLocation(10, 10);
			add(lblPitanje);		
		}
		
		void postavibtnIgrana(){
			btnIgrana.setAction(new AbstractAction("Igrana") {
		        public void actionPerformed(ActionEvent e) {
		        	
		        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
		        	k.setNacinIzvodjenjaDramskogDela("Igrana");
		            KoordinatorForm.instance().setKnjizevnost(k);	            
		            KoordinatorForm.instance().postaviFormu(new FormIgrana());
		        }
		    });		
			btnIgrana.setSize(btnIgrana.getPreferredSize());
			btnIgrana.setLocation(10, 40);
			add(btnIgrana);
		}
		
		void postavibtnPevana(){
			btnPevana.setAction(new AbstractAction("Pevana") {
		        public void actionPerformed(ActionEvent e) {
		        	
		        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
		        	k.setNacinIzvodjenjaDramskogDela("Pevana");
		            KoordinatorForm.instance().setKnjizevnost(k);	            
		            KoordinatorForm.instance().gtePdf();
		        }
		    });		
			btnPevana.setSize(btnPevana.getPreferredSize());
			btnPevana.setLocation(150, 40);
			add(btnPevana);
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
