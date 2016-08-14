package form.proza;

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
import form.proza.filozofska.FormFilozovska;
import form.proza.istorijska.FormIstorijska;
import form.proza.psioholoska.FormPsiholoska;
import koordinatorform.KoordinatorForm;

public class FormProza  extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnPsiholoska;
	private JButton btnIstorijska;
	private JButton btnFilozofska;
	private JButton btnPocetna;
	
	public FormProza(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnPsiholoska();
		postavibtnIstorijska();
		postaviBrnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnPsiholoska = new JButton();
		btnIstorijska = new JButton();
		btnFilozofska = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koju tematiku bi voleli da čitate?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnPsiholoska(){
		btnPsiholoska.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaProznihDela("Psiholoska");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().postaviFormu(new FormPsiholoska());
	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Psihologija.png"));		    
		     btnPsiholoska.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	 }

		btnPsiholoska.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPsiholoska.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnPsiholoska.setText("Psihološka");
		btnPsiholoska.setSize(btnPsiholoska.getPreferredSize());
		btnPsiholoska.setLocation(10, 40);
		add(btnPsiholoska);
	}
	
	
	
	void postavibtnIstorijska(){
		btnIstorijska.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaProznihDela("Istorijsak");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormIstorijska());	            //
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Istorija.png"));		    
		     btnIstorijska.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	 }

		btnIstorijska.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIstorijska.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnIstorijska.setText("Istorijsak");
		btnIstorijska.setSize(btnIstorijska.getPreferredSize());
		btnIstorijska.setLocation(250, 40);
		add(btnIstorijska);
	}

	void postaviBrnModerna(){
		btnFilozofska.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setKategorijaProznihDela("Filozofska");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().postaviFormu(new FormFilozovska());	            
	        }
	    });
		
		try {
		     Image img = ImageIO.read(getClass().getResource("/image/Filozofija.png"));		    
		     btnFilozofska.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
	 }

		btnFilozofska.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFilozofska.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		btnFilozofska.setText("Filozofksa");
		btnFilozofska.setSize(btnFilozofska.getPreferredSize());
		btnFilozofska.setLocation(500, 40);
		add(btnFilozofska);
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
