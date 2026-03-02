package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.String;

public final class Item {
  private Double PrixDeBase;

  private String Taille;

  private Double PrixDevente;

  private String Marque;

  private String NomComplet;

  public Double getPrixDeBase() {
    return this.PrixDeBase;
  }

  public void setPrixDeBase(Double PrixDeBase) {
    this.PrixDeBase=PrixDeBase;
  }

  public String getTaille() {
    return this.Taille;
  }

  public void setTaille(String Taille) {
    this.Taille=Taille;
  }

  public Double getPrixDevente() {
    return this.PrixDevente;
  }

  public void setPrixDevente(Double PrixDevente) {
    this.PrixDevente=PrixDevente;
  }

  public String getMarque() {
    return this.Marque;
  }

  public void setMarque(String Marque) {
    this.Marque=Marque;
  }

  public String getNomComplet() {
    return this.NomComplet;
  }

  public void setNomComplet(String NomComplet) {
    this.NomComplet=NomComplet;
  }
}
