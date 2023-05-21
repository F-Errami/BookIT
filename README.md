# BookIT

Ce projet de gestion de bibliothèque est composé d'une partie backend développée avec Spring Boot et d'une partie frontend développée avec Vue.js. Il permet de gérer les livres d'une bibliothèque, y compris l'ajout, la modification, la suppression et la recherche de livres.

## Fonctionnalités

Le projet de gestion de bibliothèque offre les fonctionnalités suivantes :

### Backend (Spring Boot)

- Récupérer la liste complète des livres
- Ajouter un livre à la bibliothèque
- Mettre à jour les informations d'un livre
- Supprimer un livre de la bibliothèque
- Rechercher des livres par titre et/ou auteur

### Frontend (Vue.js)

- Afficher la liste des livres de la bibliothèque
- Ajouter un nouveau livre à la bibliothèque
- Modifier les informations d'un livre existant
- Supprimer un livre de la bibliothèque
- Rechercher des livres par titre et/ou auteur

## Prérequis

Avant de lancer le projet, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- Java Development Kit (JDK) pour exécuter le backend 
- Apache Maven pour gérer les dépendances et exécuter le backend
- Node.js et npm pour exécuter le frontend (recommandé : Node.js 18+)
- Un IDE (comme IntelliJ IDEA) pour exécuter le backend (facultatif)

## Installation et Exécution

Suivez les étapes ci-dessous pour installer et exécuter le projet :

1. Cloner le repository GitHub du projet :

   ```bash
    git cone git@github.com:F-Errami/BookIT.git
   
   
 ## Back-end:
1. Créez une base de données MySQL nommée "bookit" sur votre serveur local. Assurez-vous d'avoir les informations d'identification nécessaires (nom d'utilisateur et mot de passe) pour vous connecter à la base de données.

2. Ouvrez le fichier `backend/src/main/resources/application.properties` dans votre éditeur de code.

3. Remplacez les valeurs` spring.datasource.url`, `spring.datasource.username` et `spring.datasource.password` par les informations d'identification de votre base de données MySQL.

4. Ouvrez un terminal et accédez au dossier du projet backend.
    
       cd BookIT/back-end.     
       mvn spring-boot:run 

   
 ## front-end: 

     cd BookIT/front-end
     npm install
     npm run serve 

