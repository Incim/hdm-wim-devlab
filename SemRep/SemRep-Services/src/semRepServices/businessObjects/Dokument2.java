package semRepServices.businessObjects;

public class Dokument2 {

	public String dok_Str;
	public String dok_KlasseStr;
	public String dok_NameStr;
	public String dok_IDStr;
	public String dok_URLStr;
	public String dok_erstelldatumStr;
	public String dok_UpdatedatumStr;
	public String dok_VersionStr;
	public String dok_TypStr;
	public String dokument_verfasst_von_Person;
	public String dokument_gehoert_zu_Phase;
	public String dokument_hat_Dokumentenkategorie;
	public String dokument_gehoert_zu_Projekt;
	public String dokument_favorisiert_von_Person;
	public String dokument_hat_Kontext;
	public String dokument_hat_Keyword;

	public String dok_folder;

	public Dokument2(String dok_Str, String dok_KlasseStr, String dok_NameStr, String dok_IDStr, String dok_URLStr,
			String dok_erstelldatumStr, String dok_UpdatedatumStr, String dok_VersionStr, String dok_TypStr, 
			String dok_folder, String dokument_verfasst_von_Person, String dokument_gehoert_zu_Phase,
			String dokument_hat_Dokumentenkategorie, String dokument_gehoert_zu_Projekt,
			String dokument_favorisiert_von_Person, String dokument_hat_Kontext, String dokument_hat_Keyword) {
		this.dok_Str = dok_Str;
		this.dok_KlasseStr = dok_KlasseStr;
		this.dokument_verfasst_von_Person = dokument_verfasst_von_Person;
		this.dokument_gehoert_zu_Phase = dokument_gehoert_zu_Phase;
		this.dokument_hat_Dokumentenkategorie = dokument_hat_Dokumentenkategorie;
		this.dokument_gehoert_zu_Projekt = dokument_gehoert_zu_Projekt;
		this.dok_NameStr = dok_NameStr;
		this.dok_IDStr = dok_IDStr;
		this.dok_URLStr = dok_URLStr;
		this.dok_erstelldatumStr = dok_erstelldatumStr;
		this.dok_UpdatedatumStr = dok_UpdatedatumStr;
		this.dok_VersionStr = dok_VersionStr;
		this.dok_TypStr = dok_TypStr;
		this.dok_folder = dok_folder;
		this.dokument_favorisiert_von_Person = dokument_favorisiert_von_Person;
		this.dokument_hat_Kontext = dokument_hat_Kontext;
		this.dokument_hat_Keyword = dokument_hat_Keyword;
	}

	public void flushDokumentObjekt() {
		setDok_Str("");
		setDok_KlasseStr("");
		setDok_erstelldatumStr("");
		setDok_IDStr("");
		setDok_NameStr("");
		setDok_TypStr("");
		setDok_folder("");
		setDok_UpdatedatumStr("");
		setDok_URLStr("");
		setDok_VersionStr("");
		setDokument_gehoert_zu_Phase("");
		setDokument_gehoert_zu_Projekt("");
		setDokument_hat_Dokumentenkategorie("");
		setDokument_verfasst_von_Person("");
		setDokument_favorisiert_von_Person("");
		setDokument_hat_Keyword("");
		setDokument_hat_Kontext("");
	}
	
	public String getDok_folder() {
		return dok_folder;
	}

	public void setDok_folder(String dok_folder) {
		this.dok_folder = dok_folder;
	}

	public String getDokument_hat_Kontext() {
		return dokument_hat_Kontext;
	}

	public void setDokument_hat_Kontext(String dokument_hat_Kontext) {
		this.dokument_hat_Kontext = dokument_hat_Kontext;
	}

	public String getDokument_hat_Keyword() {
		return dokument_hat_Keyword;
	}

	public void setDokument_hat_Keyword(String dokument_hat_Keyword) {
		this.dokument_hat_Keyword = dokument_hat_Keyword;
	}

	public String getDok_Str() {
		return dok_Str;
	}

	public void setDok_Str(String dok_Str) {
		this.dok_Str = dok_Str;
	}

	public String getDok_KlasseStr() {
		return dok_KlasseStr;
	}

	public void setDok_KlasseStr(String dok_KlasseStr) {
		this.dok_KlasseStr = dok_KlasseStr;
	}

	public String getDok_NameStr() {
		return dok_NameStr;
	}

	public void setDok_NameStr(String dok_NameStr) {
		this.dok_NameStr = dok_NameStr;
	}

	public String getDok_IDStr() {
		return dok_IDStr;
	}

	public void setDok_IDStr(String dok_IDStr) {
		this.dok_IDStr = dok_IDStr;
	}

	public String getDok_URLStr() {
		return dok_URLStr;
	}

	public void setDok_URLStr(String dok_URLStr) {
		this.dok_URLStr = dok_URLStr;
	}

	public String getDok_erstelldatumStr() {
		return dok_erstelldatumStr;
	}

	public void setDok_erstelldatumStr(String dok_erstelldatumStr) {
		this.dok_erstelldatumStr = dok_erstelldatumStr;
	}

	public String getDok_UpdatedatumStr() {
		return dok_UpdatedatumStr;
	}

	public void setDok_UpdatedatumStr(String dok_UpdatedatumStr) {
		this.dok_UpdatedatumStr = dok_UpdatedatumStr;
	}

	public String getDok_VersionStr() {
		return dok_VersionStr;
	}

	public void setDok_VersionStr(String dok_VersionStr) {
		this.dok_VersionStr = dok_VersionStr;
	}

	public String getDok_TypStr() {
		return dok_TypStr;
	}

	public void setDok_TypStr(String dok_TypStr) {
		this.dok_TypStr = dok_TypStr;
	}

	public String getDokument_verfasst_von_Person() {
		return dokument_verfasst_von_Person;
	}

	public void setDokument_verfasst_von_Person(String dokument_verfasst_von_Person) {
		this.dokument_verfasst_von_Person = dokument_verfasst_von_Person;
	}

	public String getDokument_gehoert_zu_Phase() {
		return dokument_gehoert_zu_Phase;
	}

	public void setDokument_gehoert_zu_Phase(String dokument_gehoert_zu_Phase) {
		this.dokument_gehoert_zu_Phase = dokument_gehoert_zu_Phase;
	}

	public String getDokument_hat_Dokumentenkategorie() {
		return dokument_hat_Dokumentenkategorie;
	}

	public void setDokument_hat_Dokumentenkategorie(String dokument_hat_Dokumentenkategorie) {
		this.dokument_hat_Dokumentenkategorie = dokument_hat_Dokumentenkategorie;
	}

	public String getDokument_gehoert_zu_Projekt() {
		return dokument_gehoert_zu_Projekt;
	}

	public void setDokument_gehoert_zu_Projekt(String dokument_gehoert_zu_Projekt) {
		this.dokument_gehoert_zu_Projekt = dokument_gehoert_zu_Projekt;
	}

	public String getDokument_favorisiert_von_Person() {
		return dokument_favorisiert_von_Person;
	}

	public void setDokument_favorisiert_von_Person(String dokument_favorisiert_von_Person) {
		this.dokument_favorisiert_von_Person = dokument_favorisiert_von_Person;
	}

}
