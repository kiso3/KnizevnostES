package form.proza.istorijska;

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

public class FormIstorijska extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnAnticka;
	private JButton btnSredVek;
	private JButton btnModerna;
	private JButton btnPocetna;
	
	public FormIstorijska(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnAnticka();
		postavibtnSredVek();
		postaviBrnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnAnticka = new JButton();
		btnSredVek = new JButton();
		btnModerna = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Na koji istorijski period delo treba da se odnosi?");
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
		btnSredVek.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskiPeriod("Srednji vek");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormSrednjevekovna());
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/SrednjiVek.png"));		    
		     btnSredVek.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnSredVek.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSredVek.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnSredVek.setText("Srednje vekovni");
		btnSredVek.setSize(btnSredVek.getPreferredSize());
		btnSredVek.setLocation(250, 40);
		add(btnSredVek);
	}

	void postaviBrnModerna(){
		btnModerna.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskiPeriod("Moderna");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormModerna());
	        }
	    });
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Moderna.png"));		    
		     btnModerna.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnModerna.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModerna.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModerna.setText("Moderni");
		btnModerna.setSize(btnModerna.getPreferredSize());
		btnModerna.setLocation(500, 40);
		add(btnModerna);
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
