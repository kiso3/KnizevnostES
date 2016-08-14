package form.proza.psioholoska;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormPsiholoska extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnPrvoLice;
	private JButton btnTreceLice;
	private JButton btnToksSvesti;
	private JButton btnPocetna;
	
	public FormPsiholoska(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnPrvoLice();
		postavibtnTreceLice();
		postaviBrnModerna();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnPrvoLice = new JButton();
		btnTreceLice = new JButton();
		btnToksSvesti = new JButton();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Koji način pripovedanja bi ste voleli da čitate u delu?");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnPrvoLice(){
		btnPrvoLice.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {  	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setTipPripovedaca("1 lice");
	            KoordinatorForm.instance().setKnjizevnost(k);	        
	            KoordinatorForm.instance().gtePdf();
	            
	        }
	    });
		btnPrvoLice.setText("U prvom licu");
		btnPrvoLice.setSize(btnPrvoLice.getPreferredSize());
		btnPrvoLice.setLocation(10, 40);
		add(btnPrvoLice);
	}
	
	void postavibtnTreceLice(){
		btnTreceLice.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        		        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setTipPripovedaca("3 lice");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });
		btnTreceLice.setText("U trećem licu");
		btnTreceLice.setSize(btnTreceLice.getPreferredSize());
		btnTreceLice.setLocation(150, 40);
		add(btnTreceLice);
	}

	void postaviBrnModerna(){
		btnToksSvesti.setAction(new AbstractAction("") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setTipPripovedaca("Tok svesti");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();           
	        }
	    });
		btnToksSvesti.setText("Tok svesti");
		btnToksSvesti.setSize(btnToksSvesti.getPreferredSize());
		btnToksSvesti.setLocation(290, 40);
		add(btnToksSvesti);
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
