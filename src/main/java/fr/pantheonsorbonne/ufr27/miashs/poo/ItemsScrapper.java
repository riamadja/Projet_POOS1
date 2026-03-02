package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.String;
import java.util.ArrayList;

public final class ItemsScrapper {
  public ArrayList<Item> parseSource(String pageSource) {
    ArrayList<Item> itemList = new ArrayList<>();
    //int condition =0;
    int startIndex = pageSource.indexOf("class=\"product-title h6 \" data-instant> <b>Soutien-gorge");
    while(startIndex !=-1){

      if (startIndex == -1 ) {
        System.out.println("Fin du scraping ou aucun 'Soutien-gorge' trouvé.");
        break;
    }

      String inter = "class=\"product-title h6 \" data-instant> <b>Soutien-gorge"; //str du début de la recherche nom item
      String inter2= "<span class=\"sr-only\">Prix normal</span>€";
      String inter3= "<span class=\"sr-only\">Prix de vente</span>€";
      int taille2=inter2.length(); 
      int taille = inter.length(); //taille du str du début 
      int taille3 = inter3.length();
      
      //extraction nom 
      
      int EndName= pageSource.indexOf("</b",startIndex+taille);
      String Marque = pageSource.substring(startIndex+taille,EndName);
      
      
      //extraction taille
      int IndexTaille = pageSource.indexOf("Taille : ", startIndex);
      String Taille = pageSource.substring(IndexTaille+9, IndexTaille+14);
      
      //extraction prix de base 
      int IndexPxBase= pageSource.indexOf("<span class=\"sr-only\">Prix normal</span>€", startIndex);
      String PxBase= pageSource.substring(IndexPxBase+taille2, IndexPxBase+taille2+6).replace(',', '.'); 
      double PrixDeBase = Double.parseDouble(PxBase);
      
      //extraction prix de vente 
      int IndexPxVente= pageSource.indexOf("<span class=\"sr-only\">Prix de vente</span>€",startIndex);
      String PxVente = pageSource.substring(IndexPxVente+taille3, IndexPxVente+taille3+6).replace(',', '.');
      double PrixDeVente = Double.parseDouble(PxVente);
      
      
      
      
     //apres avoir initalisé toutes les propriétés on crée l'item et ajout à la liste 
      Item item = new Item();
      if(Marque.length()>15){
        item.setMarque("Non Communiqué");
      }else{
        item.setMarque(Marque);
      }
      
      item.setNomComplet("Soutien-gorge");
      item.setTaille(Taille);
      item.setPrixDeBase(PrixDeBase);
      item.setPrixDevente(PrixDeVente);
      itemList.add(item);

      
      // Mise à jour de startIndex pour chercher le prochain item
      startIndex = pageSource.indexOf("Soutien-gorge", EndName);
      
    }

    
    

  return itemList;
   }

    
}
  

