import java.util.ArrayList;

public class CryptoMarche {

	private ArrayList<Portefeuille> portefeuilles;
	private static CryptoMarche marche;

	private CryptoMarche(){
		portefeuilles = new ArrayList<>();
	}

	public static CryptoMarche getInstance(){
		if(marche == null){ 
			marche = new CryptoMarche();
		}
		return marche;
	}

	public void ajouter(Portefeuille p){
		portefeuilles.add(p);
	}

	public double capitalEnEuros(String proprietaire){
		double total = 0;

		for(Portefeuille p : portefeuilles){
			if(p.getProprietaire().equals(proprietaire)){
				total += p.getMontant() * p.getMonnaie().getValeurDeJeton();
			}
		}

		return total;
	}

	public double capitalMonneaie(Cryptomonnaie monnaie){
		double total = 0;

		for(Portefeuille p : portefeuilles){
			if(p.getMonnaie().getNom().equals(monnaie.getNom())){
				total += p.getMontant() * p.getMonnaie().getValeurDeJeton();
			}
		}

		return total;
	}

	@Override
	public String toString() {
		String ret = "";
		for(Portefeuille p : this.portefeuilles){
			ret += p.toString() + "\n";
		}
		return ret;
	}
}
