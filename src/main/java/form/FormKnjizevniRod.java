package form;

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
import form.drama.FormDrama;
import form.proza.FormProza;
import koordinatorform.KoordinatorForm;

public class FormKnjizevniRod extends OpstaEkranskaForma{
	
	private JLabel lblPitanje;
	private JButton btnDrama;
	private JButton btnProza;
	private JButton btnPocetna;
	
	public FormKnjizevniRod(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postaviBtnDrama();
		postaviBtnProza();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnDrama = new JButton();
		btnProza = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koji književni rod bi ste voleli da čitate?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postaviBtnDrama(){	 
		btnDrama.setAction(new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKnjizevniRod("Drama");
	            KoordinatorForm.instance().setKnjizevnost(k);	        	
	            KoordinatorForm.instance().postaviFormu(new FormDrama());
	        }
	    });	
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Drama.png"));		    
		     btnDrama.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
	      
		btnDrama.setText("Drama");
		btnDrama.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDrama.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDrama.setSize(btnDrama.getPreferredSize());
		btnDrama.setLocation(10, 40);
		add(btnDrama);
	}
		
	void postaviBtnProza(){
		btnProza.setAction(new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKnjizevniRod("Proza");
	            KoordinatorForm.instance().setKnjizevnost(k);		
	            KoordinatorForm.instance().postaviFormu(new FormProza());
			}
		});
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Proza.png"));		    
		     btnProza.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnProza.setText("Proza");
		btnProza.setVerticalTextPosition(SwingConstants.BOTTOM);		
		btnProza.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProza.setSize(btnProza.getPreferredSize());
		btnProza.setLocation(250, 40);
		add(btnProza);
	}
	
	
	void postaviBtnPocetna(){
		btnPocetna.setAction(new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	//Knizevnost k = KoordinatorForm.instance().getKnjizevnost();	        	
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
