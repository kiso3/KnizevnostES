package start;


import form.FormPocetna;
import koordinatorform.KoordinatorForm;

public class Start{

	public static void main(String[] args) {
		KoordinatorForm.instance().postaviFormu(new FormPocetna());
	}
}
