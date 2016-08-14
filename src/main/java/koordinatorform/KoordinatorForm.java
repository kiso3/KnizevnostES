package koordinatorform;

import java.awt.Desktop;
import java.io.IOException;

import org.goodoldai.jeff.wizard.JEFFWizard;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import domen.Knizevnost;
import form.MainFrame;
import form.OpstaEkranskaForma;

public class KoordinatorForm {
	
	private MainFrame mainFrame;
	JEFFWizard wizard;
	private final KieContainer kieContainer;
	private KieSession ksession;	
	private Knizevnost k;
	private FactHandle fh;

    private static KoordinatorForm koordinatorForm;

    private KoordinatorForm() {

    	mainFrame = new MainFrame();    	
    	mainFrame.setSize(800, 400);
    	kieContainer = createKieContainer();
    	createKieSession();    	
    	
    }
    
    public static KoordinatorForm instance(){
        if(koordinatorForm == null){
            koordinatorForm = new KoordinatorForm();
        }
        return koordinatorForm;
    }
        
    public void postaviFormu(OpstaEkranskaForma oef){    	
    	oef.setSize(mainFrame.getWidth(), mainFrame.getHeight());    	
    	mainFrame.posaviAktivanPanel(oef);    	
    }
    
    public OpstaEkranskaForma vratiAktivnuFormu(){
        return mainFrame.vratiAktivnuFormu();
    }   
    
    public void pack(){
    	mainFrame.pack();
    }

    
    private KieContainer createKieContainer(){
       KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
       System.out.println(kc.verify().getMessages().toString());
       return kc;	   
   }
    
    public void createKieSession(){
    	System.out.println("createKieSession");
    	ksession = kieContainer.newKieSession("ksession-rules");
    	
    	wizard = getJEFFWizardWithInterface();

		wizard.setTitle("Ekspertni sistem za preporuku književnih dela za čitanje iz svedske književnosti");			
		wizard.createExplanation();

		k = new Knizevnost();
				
		ksession.setGlobal("wizard", wizard);
		fh= ksession.insert(k);
	
    }
    
    public Knizevnost getKnjizevnost(){ 
    	fh = ksession.getFactHandle(k);
    	return k;
    }
    
    public void setKnjizevnost(Knizevnost kv){    	
    	this.k = kv; 	
    	ksession.update(fh,k );    
    }
    
	private JEFFWizard getJEFFWizardWithInterface() {
		//return new JEFFWizard("Mladen", "srb", "RS", "Auto-moto Savez prepruke", true);
		return new JEFFWizard("Mladen", null, null, "Svedska književnost preporuka za čitanje", true);
		
	}
	
	public void fireallAllRules(){
		ksession.fireAllRules();    
		
	}
	
	public void gtePdf(){
		fireallAllRules();  
		wizard.generatePDFReport("Objasnjenje.pdf",false);
		if (Desktop.isDesktopSupported())
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create((new java.io.File("Objasnjenje.pdf").toURI().toString())));
			} catch (IOException e) {			
				e.printStackTrace();
			}		
	}
	
	public void resetujEkspertniSistem(){
		createKieSession();		
	}
	
	
}
