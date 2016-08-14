package form.proza.filozofska;

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

public class FormFilozovska extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnAnticka;
	private JButton btnSrednjevekovna;	
	private JButton btnModerna;	
	private JButton btnPocetna;
	
	public FormFilozovska(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnAnticka();
		postavibtnSrednjevekovna();
		postaviBtnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnAnticka = new JButton();
		btnSrednjevekovna = new JButton();
		btnModerna = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Iz kog vremeskog perioda delo treba da bude?");
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
	            KoordinatorForm.instance().gtePdf();
	            	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Anticki.png"));		    
		     btnAnticka.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		
		btnAnticka.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAnticka.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnAnticka.setText("Antičkog");
		btnAnticka.setSize(btnAnticka.getPreferredSize());
		btnAnticka.setLocation(10, 40);
		add(btnAnticka);
	}
	
	void postavibtnSrednjevekovna(){
		btnSrednjevekovna.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setVremeskiPeriod("Srednji vek");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormSrednjevekovna());
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/SrednjiVek.png"));		    
		     btnSrednjevekovna.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnSrednjevekovna.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSrednjevekovna.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnSrednjevekovna.setText("Srednje vekovnog");
		btnSrednjevekovna.setSize(btnSrednjevekovna.getPreferredSize());
		btnSrednjevekovna.setLocation(250, 40);
		add(btnSrednjevekovna);
	}
	
	void postaviBtnModerna(){
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
		btnModerna.setText("Modernog");
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
