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

public class FormSrednjevekovna extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnAntickoNasledje;
	private JButton btnReligiozna;	
	private JButton btnPocetna;
	
	public FormSrednjevekovna(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnAntickoNasledje();
		postavibtnReligiozna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnAntickoNasledje = new JButton();
		btnReligiozna = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Kojeg karaktera delo treba da bude?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnAntickoNasledje(){
		btnAntickoNasledje.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDela("Anticko nasledje");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();	            	           
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Anticki.png"));		    
		     btnAntickoNasledje.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnAntickoNasledje.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAntickoNasledje.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnAntickoNasledje.setText("Antičko nasleđe");
		btnAntickoNasledje.setSize(btnAntickoNasledje.getPreferredSize());
		btnAntickoNasledje.setLocation(10, 40);
		add(btnAntickoNasledje);
	}
	
	void postavibtnReligiozna(){
		btnReligiozna.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDela("Religiozno");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Religija.png"));		    
		     btnReligiozna.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnReligiozna.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReligiozna.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnReligiozna.setText("Religiozno");
		btnReligiozna.setSize(btnReligiozna.getPreferredSize());
		btnReligiozna.setLocation(250, 40);
		add(btnReligiozna);
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
