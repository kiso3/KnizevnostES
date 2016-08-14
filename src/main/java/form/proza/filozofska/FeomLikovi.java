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

public class FeomLikovi extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnDrustveni;
	private JButton btnReligiozni;		
	private JButton btnPocetna;
	
	public FeomLikovi(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnDrustveni();
		postavibtnReligiozni();		
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnDrustveni = new JButton();
		btnReligiozni = new JButton();		
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Kojeg karaktera delo treba da bude?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnDrustveni(){
		btnDrustveni.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDela("Drustveni");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	            	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Drustvo.png"));		    
		     btnDrustveni.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnDrustveni.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDrustveni.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnDrustveni.setText("Društvenog");
		btnDrustveni.setSize(btnDrustveni.getPreferredSize());
		btnDrustveni.setLocation(10, 40);
		add(btnDrustveni);
	}
	
	void postavibtnReligiozni(){
		btnReligiozni.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKarakterDela("Religiozni");
	            KoordinatorForm.instance().setKnjizevnost(k);	           
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Religija.png"));		    
		     btnReligiozni.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnReligiozni.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReligiozni.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnReligiozni.setText("Religioznog");
		btnReligiozni.setSize(btnReligiozni.getPreferredSize());
		btnReligiozni.setLocation(250, 40);
		add(btnReligiozni);
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
