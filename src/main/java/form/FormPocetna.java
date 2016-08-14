package form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;

import koordinatorform.KoordinatorForm;

public class FormPocetna extends OpstaEkranskaForma{
	
	private JLabel lblPoruka;
	private JButton btnPokreniPitanja;

	public FormPocetna(){		
		setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPoruka();	
		postaviBtnPokreniPitanja();
	}
	
	void kreirajKomponenteEkranskeForme(){		
		btnPokreniPitanja = new JButton();
		lblPoruka = new JLabel();
	}
	
	void  postaviLblPoruka(){
		lblPoruka.setText("Ekspertni sistem za preporuku za čitanje dela iz svedske kjiževnosti");
		lblPoruka.setSize(lblPoruka.getPreferredSize());
		lblPoruka.setLocation(10, 10);
        add(lblPoruka);        	
	}
	
	void postaviBtnPokreniPitanja(){
		btnPokreniPitanja.setAction(new AbstractAction("Pokreni pitanja") {
	        public void actionPerformed(ActionEvent e) {
	        	KoordinatorForm.instance().postaviFormu(new FormKnjizevniRod());
	        }
	    });
		
		btnPokreniPitanja.setSize(btnPokreniPitanja.getPreferredSize());
		btnPokreniPitanja.setLocation(50, 50);		
		add(btnPokreniPitanja);
	
		
		
	}

}

