# tess4j-test
Projet de test d'écriture d'un webservice avec Spring qui retourne le contenu d'un fichier sous forme de texte.

Les implémentations d'engine OCR disponibles sont :
* Tesseract à l'aide de la bibliothèque tess4j.
* Google Vision OCR (Work in progress, pas fonctionnel)

## Prérequis d'environnement

* Java 8
* VC++ 2015 ou 2017 pour tesseract sous Windows

## Configuration du projet

Ci-dessous les variables utilisées pour configurer le projet. Aucune valeur par défaut signifie qu'il faut la renseigner manuellement (sauf si inutile pour l'engine OCR demandé).

| Nom de la variable | Description                                                                 | Types   |Valeur par défaut | Valeurs possibles|
|--------------------|-----------------------------------------------------------------------------|---------|------------------|------------------|
| ocr.mode           | Type d'engine OCR à utiliser                                                | String  |                  | tesseract, google_vision       |
| ocr.impl.tesseract.dataPath  | Chemin vers les fichiers .traineddata nécessaire au fonctionnement de Tesseract    | String  |                  |                  |                  
|ocr.tesseract.language | Langues que Tesseract doit être capable de lire. Pour en renseigner plusieurs il faut utiliser le symbole "+". Par exemple eng+spa demande un support pour l'anglais et l'espagnol.
Si les fichiers traineddata associés ne sont pas présent le langage sera ignoré dans l'analyse | String | String |eng | En fonction des fichiers .traineddata à disposition. Se référer à [tessdata](https://github.com/tesseract-ocr/tessdata)
| web.maxUploadSize      | Taille maximum en octet des fichiers pouvant être upload                  | Entier  | 10000000                 |                  |
|server.port| Port d'écoute pour les requêtes HTTP|Entier|8080

## Compilation

Executer à la racine du projet 
```java
mvn clean install
```

Ce qui gênera un .jar  **PROJECT_ROOT\target\ocrdemo.jar** avec l'application et le serveur embarqué.

## Execution

Mettre dans le même dossier que le jar à lancer un fichier appelé **application.properties** contenant les propriétés à utiliser. Le fichier **application.properties.sample** à la racine de ce dépôt est un bon point de départ. Lancer le serveur avec la commande :
```
java -jar ocrdemo.jar
```

L'application sera accessible sous http://localhost:8080/ (sauf si vous avez surchargé le port).
Une documentation OpenApi est disponible à l'url http://localhost:8080/swagger-ui.html pour tester facilement l'API.


## Sources externes
* Dépôt avec les modèles entrainés pour les languages pour Tessseract : [tessdata](https://github.com/tesseract-ocr/tessdata)