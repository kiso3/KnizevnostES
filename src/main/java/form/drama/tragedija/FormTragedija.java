package form.drama.tragedija;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormTragedija extends OpstaEkranskaForma{
	
	private JLabel lblPitanje;
	private JButton btnAnticka;
	private JButton btnSredVek;
	private JButton btnPocetna;
	
	public FormTragedija(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnAnticka();
		postavibtnSredVek();
		postaviBtnPocetna();	
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnAnticka = new JButton();
		btnSredVek = new JButton();		
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Iz kog vremeskog perioda bi ste voleli da bude delo?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnAnticka(){
		btnAnticka.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskiPeriod("Anticka");
	            KoordinatorForm.instance().setKnjizevnost(k);	            
	             KoordinatorForm.instance().postaviFormu(new FormAnticka());
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Anticki.png"));		    
		     btnAnticka.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		
		btnAnticka.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAnticka.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnAnticka.setText("Antički");
		btnAnticka.setSize(btnAnticka.getPreferredSize());
		btnAnticka.setLocation(10, 40);
		add(btnAnticka);
	}
	
	void postavibtnSredVek(){
		btnSredVek.setAction(new AbstractAction("Srednje vekovni") {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskiPeriod("Srednji vek");
	            KoordinatorForm.instance().setKnjizevnost(k);	            
	            KoordinatorForm.instance().postaviFormu(new FormSrednjiVek());
	        }
	    });		
		
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/SrednjiVek.png"));		    
		     btnSredVek.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnSredVek.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSredVek.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnSredVek.setSize(btnSredVek.getPreferredSize());
		btnSredVek.setLocation(250, 40);
		add(btnSredVek);
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
