public class Portefeuille {
  private Cryptomonnaie monnaie;
  private double montant;
  private String proprietaire;

  public Portefeuille(Cryptomonnaie monnaie, double montant, String proprietaire){
      this.monnaie      = monnaie;
      this.montant      = montant;
      this.proprietaire = proprietaire;
  }
 /**
   * Cette fonction vous permet de transférer des devises du portefeuille actuel 
   * vers le portefeuille de destination pour le montant indiqué. Le type de devise 
   * (nom du Jeton) doit être le même entre les deux portefeuilles et le montant 
   * du portefeuille actuel doit être supérieur ou égal à celui indiqué.
   * @param destination 
   * @param montantJetons
   * @return true si la transaction a été effectuée, false sinon.  
   */
  public boolean transfertDevise(Portefeuille destination, double montantJetons){

      if (!this.monnaie.getNom().equals(destination.monnaie.getNom())) {
          return false;
      }

      if (montantJetons <= 0 || this.montant < montantJetons) {
          return false;
      }

      this.montant -= montantJetons;
      destination.montant += montantJetons;

      return true;
  }

  /**
   * Cette fonction vous permet d'acheter des jetons de la 
   * crypto-devise en fonction de leur valeur en euros. 
   * Le résultat est l'augmentation des jetons de la crypto-monnaie.
   * @param montantEuros Valeur d'achat en euros 
   * @return true si le montant en euros est supérieur ou égal à 0 
   */
  public boolean achatDevise(double montantEuros){

      if (montantEuros < 0) {
          return false;
      }

      double jetonsAchetes = montantEuros / this.monnaie.getValeurDeJeton();

      this.montant += jetonsAchetes;

      return true;
  }

  public boolean estProprietaire(String proprietaire){
        return proprietaire.equals(this.proprietaire);
  }

  public double valeurEnEuros(){
      return this.montant * this.monnaie.getValeurDeJeton();
  }

  public String getProprietaire() {
      return proprietaire;
  }

  public Cryptomonnaie getMonnaie() {
      return monnaie;
  }

  public double getMontant() {
      return montant;
  }

  @Override
  public String toString() {
      return String.format("%10s",proprietaire) + " : "
           + String.format("%10.1f", montant)   + " x " 
           + this.monnaie.toString()            + " = "
           + String.format("%10.1f", valeurEnEuros());
  }
}
