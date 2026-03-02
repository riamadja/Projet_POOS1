Scrapper & Analyzer

(Projet d'Étude - Programmation Orientée Objet)

Ce projet est un outil de Web Scraping en Java permettant de récupérer, traiter et analyser des données produits à partir d'une plateforme de vente en ligne. Il permet d'extraire des informations telles que les marques, les tailles et les prix pour en tirer des statistiques d'analyse.

---
# 1- Installation & Lancement

Le projet est conçu pour être utilisé avec Maven et peut être exécuté via un container ou directement en local.

    Compilation :
    Bash

    mvn clean install

Exécution :
Lancez la classe Main.java. Le programme va :

Charger les données (via le cache local par défaut).

Parser le contenu HTML pour créer des objets Item.

Afficher les attributs de chaque produit.

Générer une analyse statistique complète.

---
# 2- Composants du Projet

*ItemsScrapper.java

C'est le moteur d'extraction du projet.

Fonctionnalité : Parcourt le code source HTML brut.

Extraction : Récupère dynamiquement le nom, la marque, la taille, le prix de base et le prix de vente.

Nettoyage : Gère les formats de prix (conversion virgule/point) et l'anonymisation des marques inconnues.

*ItemAnalyzer.java

Module d'analyse de données post-scraping.

Prix : Calcule le prix le plus bas et la moyenne des prix de vente.

Statistiques : Identifie la marque la plus fréquente dans la liste.

 Écarts : Calcule l'écart maximum entre prix de base et prix réduit, ainsi que la moyenne des remises effectuées.

*ContentProxy & WebPageFetcher

Gestion de la source de données.

    Mode Cache : Utilise un fichier local (scrapped0.txt) pour éviter les requêtes réseau inutiles pendant le développement.

    Mode Fresh : Capable de récupérer le contenu en temps réel via une URL distante.

*Item.java

Le modèle de données (POJO).

    Représente un produit avec ses propriétés : Marque, Taille, PrixDeBase, PrixDevente, NomComplet.

*Statistiques Générées

Lors de l'exécution, le programme affiche automatiquement :

    Le listing complet des items détectés avec leurs caractéristiques.

    L'analyse comparative :

        Moyenne des prix.

        Marque dominante.

        Écart de prix (Promotion) le plus important.

        Moyenne des remises constatées.
---
# 3- Structure du Projet

```
src/main/java/fr/pantheonsorbonne/ufr27/miashs/poo/
├── Main.java                # Point d'entrée de l'application
├── Item.java                # Modèle de données
├── ItemsScrapper.java       # Logique d'extraction HTML
├── ItemAnalyzer.java        # Calculs statistiques
├── ContentProxy.java        # Gestionnaire de source (Cache/Remote)
└── WebPageFetcher.java      # Utilitaire de connexion HTTP

```

---
# 4- Prérequis

Java 17+

Maven

Note : Ce projet a été réalisé dans un cadre pédagogique pour illustrer les concepts de POO, de manipulation de chaînes de caractères et de gestion de flux de données.
