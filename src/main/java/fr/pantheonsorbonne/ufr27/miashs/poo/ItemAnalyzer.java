package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ItemAnalyzer {
  private ArrayList<Item> items = new ArrayList<>();

  public ItemAnalyzer(ArrayList<Item> items) {
    this.items=items;
  }

  public Double getPrixLePlusBas() { 
    Double PrixMinimum =10000.0; //nbr choisit de manière arbitraire 
    for (Item i: items){
       double prix=i.getPrixDevente();
       
      if (prix<PrixMinimum){
        PrixMinimum=prix;
      }
    }
    
    return PrixMinimum;
  }

  public String getMarqueLaPlusFréquente() {
     if (items == null || items.isEmpty()) {
        return null;
    }

    // Map pour compter les occurrences des marques
    HashMap<String, Integer> marqueCount = new HashMap<>();

    // Compter les occurrences de chaque marque
    for (Item item : items) {
        String marque = item.getMarque(); // Récupérer la marque
        if (marque != null && !marque.isEmpty()) {
            marqueCount.put(marque, marqueCount.getOrDefault(marque, 0) + 1); //gestion de la création et incrémentation en mm tmps
        }
    }

    // Trouver la marque la plus fréquente
    String marqueLaPlusFréquente = null;
    int maxCount = 0;

    for (Map.Entry<String, Integer> entry : marqueCount.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            marqueLaPlusFréquente = entry.getKey();
        }
    }

    return marqueLaPlusFréquente; // Retourner la marque la plus fréquente;
  }

  public Double getEcartDePrixLePlusImportant() {
    // Variable pour suivre l'écart maximum
    double ecartMax = 0.0;

    // Parcourt chaque item dans la liste
    for (Item item : items) {
        // Récupère le prix de base et le prix de vente
        double prixDeBase = item.getPrixDeBase();
        double prixDeVente = item.getPrixDevente();

        // Calcule l'écart entre le prix de base et le prix de vente
        double ecart = prixDeBase - prixDeVente;

        // Met à jour l'écart maximum si nécessaire
        if (ecart > ecartMax) {
            ecartMax = ecart;
        }
    }

    
    return ecartMax;
  }

  public Double getMoyenneDesPrixDeVente() {
    // Initialiser la somme des prix de vente
    double sommePrixDeVente = 0.0;

    // Parcourir la liste pour additionner les prix de vente
    for (Item item : items) {
        sommePrixDeVente += item.getPrixDevente(); 
    }

    // Calculer la moyenne
    double moyenne = sommePrixDeVente / items.size();

    
    return moyenne;
  }

  public Double getMoyenneDesEcartsDesPrixDeVente() {
    
    double sommeDesEcarts = 0.0;

    // Parcourir chaque item pour calculer et accumuler l'écart
    for (Item item : items) {
        double prixDeBase = item.getPrixDeBase(); 
        double prixDeVente = item.getPrixDevente(); 

        // Calculer l'écart  entre le prix de base et le prix de vente
        double ecart = prixDeBase - prixDeVente;

        // Ajouter l'écart à la somme
        sommeDesEcarts += ecart;
    }

    // Calculer la moyenne des écarts
    double moyenneDesEcarts = sommeDesEcarts / items.size();

    
    return moyenneDesEcarts;
  }

  public String getPlusGrandeTaille() {
       return null; 
  }
}
