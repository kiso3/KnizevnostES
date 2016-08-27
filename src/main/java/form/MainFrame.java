package form;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	JPanel mainPanel;
	OpstaEkranskaForma oef;
	
	 public MainFrame() {
	        super("Ekspertni sistem za davanje preporuke za čitanje dela iz svetske književnosti");
	        kreirajKomponenteEkranskeForme();
	        postaviMainPanel();
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }
		/*
		private Container createContentPane() {
			mainPanel = new JPanel(); 
			mainPanel.setLayout(null);
			mainPanel.add(new FormPocetna());	       
	        return mainPanel;
	    }
		*/
		void kreirajKomponenteEkranskeForme(){
			mainPanel = new JPanel(); 
		}
		
		void postaviMainPanel(){
			mainPanel.setLayout(null);
			add(mainPanel);
		}
		public void posaviAktivanPanel(OpstaEkranskaForma voef) {
			mainPanel.removeAll();
	        oef=voef;
	        mainPanel.add(oef);
	        mainPanel.repaint();
			
		}

		public OpstaEkranskaForma vratiAktivnuFormu() {			
			return oef;
		}

}
