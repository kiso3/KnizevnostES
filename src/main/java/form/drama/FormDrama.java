package form.drama;

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
import form.drama.komedija.FormKomedije;
import form.drama.moderna.FormMoerna;
import form.drama.tragedija.FormTragedija;
import koordinatorform.KoordinatorForm;

public class FormDrama extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnTragedija;
	private JButton btnKomedija;
	private JButton btnModerna;
	private JButton btnPocetna;
	
	public FormDrama(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postaviBtnTragedija();
		postaviBtnKomedija();
		postaviBrnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnTragedija = new JButton();
		btnKomedija = new JButton();
		btnModerna = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koju vrstu dramskih dela bstei voleli da čitate?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postaviBtnTragedija(){
		btnTragedija.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDraskihDela("Tragedija");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().postaviFormu(new FormTragedija());
	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Tragedija.png"));		    
		     btnTragedija.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnTragedija.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTragedija.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnTragedija.setText("Tragedija");
		btnTragedija.setSize(btnTragedija.getPreferredSize());
		btnTragedija.setLocation(10, 40);
		add(btnTragedija);
	}
	
	void postaviBtnKomedija(){
		btnKomedija.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDraskihDela("Komedija");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormKomedije());	            //
	        }
	    });
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Komedija.png"));		    
		     btnKomedija.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
		btnKomedija.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKomedija.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnKomedija.setText("Komedija");
		btnKomedija.setSize(btnKomedija.getPreferredSize());
		btnKomedija.setLocation(250, 40);
		add(btnKomedija);
	}

	void postaviBrnModerna(){
		btnModerna.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaDraskihDela("Moderna");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormMoerna());	            
	        }
	    });
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Moderna.png"));		    
		     btnModerna.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	  }
				
		btnModerna.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModerna.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModerna.setText("Moderna drama");
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
