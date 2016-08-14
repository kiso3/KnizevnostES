package form.drama.moderna;


import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FormMoerna extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnOdaberi;

	private JCheckBox chBoxDijalog;
	private JCheckBox chBoxRazvijenaFabula;
	private JCheckBox chBoxPsihologijaLikova;
	private JCheckBox chBoxSimbologija;
	private JCheckBox chBoxRazlicitost;
	private ArrayList<JCheckBox> chArray;
	private JButton btnPocetna;
	
	
	public FormMoerna(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnOdaberi();	
		postaviChBoxPanel();
		postaviBtnPocetna();
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnOdaberi = new JButton();
		chBoxDijalog = new JCheckBox();
		chBoxRazvijenaFabula = new JCheckBox();
		chBoxPsihologijaLikova = new JCheckBox();
		chBoxSimbologija = new JCheckBox();
		chBoxRazlicitost = new JCheckBox();
		chArray = new ArrayList<>();
		btnPocetna = new JButton();
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Odabrite karakteristike koje bi delo trebalo da sadrži? (Odabrati tri)");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnOdaberi(){
		btnOdaberi.setAction(new AbstractAction("Odaberi") {
	        public void actionPerformed(ActionEvent e) {  	      
	        	if(chBoxRazvijenaFabula.isSelected() && chBoxRazlicitost.isSelected()){
		        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
		        	k.setKategorijaModerneDrame("Naturalisticka drama");
		            KoordinatorForm.instance().setKnjizevnost(k);	
		            KoordinatorForm.instance().postaviFormu(new FormNaturalistickaDrama());		            
	        		
	        	}else{
		        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
		        	k.setKategorijaModerneDrame("Antidrama");
		            KoordinatorForm.instance().setKnjizevnost(k);
		            KoordinatorForm.instance().gtePdf();
	        	}
	        }
	    });	
		btnOdaberi.setSize(btnOdaberi.getPreferredSize());
		btnOdaberi.setLocation(10, 170);
		btnOdaberi.setEnabled(false);
		add(btnOdaberi);
	}
	
	void postaviChBoxPanel(){		
		
		chBoxDijalog.setText("Dijalog");
		chBoxDijalog.setSize(chBoxDijalog.getPreferredSize());
		chBoxDijalog.setLocation(10, 40);
		add(chBoxDijalog);
		chBoxDijalog.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 osluskovac();
			}
		});
		chArray.add(chBoxDijalog);
		
		chBoxRazvijenaFabula.setText("Razvijena fabula");		
		chBoxRazvijenaFabula.setSize(chBoxRazvijenaFabula.getPreferredSize());
		chBoxRazvijenaFabula.setLocation(10, 60);
		add(chBoxRazvijenaFabula);
		chBoxDijalog.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 osluskovac();
			}
		});
		chArray.add(chBoxRazvijenaFabula);
		
		chBoxPsihologijaLikova.setText("Psihologija likova");
		chBoxPsihologijaLikova.setSize(chBoxPsihologijaLikova.getPreferredSize());
		chBoxPsihologijaLikova.setLocation(10, 80);
		add(chBoxPsihologijaLikova);
		chBoxPsihologijaLikova.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 osluskovac();
			}
		});
		chArray.add(chBoxPsihologijaLikova);
		
		chBoxSimbologija.setText("Simbologija");
		chBoxSimbologija.setSize(chBoxSimbologija.getPreferredSize());
		chBoxSimbologija.setLocation(10, 100);
		add(chBoxSimbologija);
		chBoxSimbologija.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 osluskovac();
			}
		});
		chArray.add(chBoxSimbologija);
		
		chBoxRazlicitost.setText("Različitoti");
		chBoxRazlicitost.setSize(chBoxRazlicitost.getPreferredSize());
		chBoxRazlicitost.setLocation(10, 120);
		add(chBoxRazlicitost);
		chBoxRazlicitost.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 osluskovac();	
			}
		});
		chArray.add(chBoxRazlicitost);
		
	}
	
	private void osluskovac() {		
		int cout = 0;
		for (JCheckBox checkbox : chArray) {
			if (checkbox.isSelected()) {
				cout++;			
			}
		}
		if(cout == 3){
			btnOdaberi.setEnabled(true);
		}else{
			btnOdaberi.setEnabled(false);
		}
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
