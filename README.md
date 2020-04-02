## Mini Contrôle ferroviaire

Adel Anani, Nasreddine Anani, Aissa Atif

### Description 

L'application se lance dans un terminal. 
Tous les trains sont lancés dans des threads 
et suivent les tracks du tp1. Le chemin 
emprunter par les différentes lignes sont décrites
dans les fichiers TrainA et TrainB. Avec 
différents paramètres vous pouvez modifier les traces
afficher dans le terminal. 

Les traces décrivent l'action de chaque train. Par example
pour `Train B0 enter track B1`, on nous informe que 
le train B0 entre dans la track B1.

***Pour simplifier le travail pour chaque track un train entre et sort.*

Exemple de sortie du terminal : 

    Train B0 enter track B1
    Train A1 panne track A1
    Train B0 exit track B1
    Train A1 reparation track A1
    Train B1 enter track B1
    Train A2 panne track A1
    Train A2 reparation track A1



### Paramétrisation 

Si vous désirez ajouter des `pannes` ou des `delai` 
sur certains tronçons, vous pouvez les ajouter dans la 
fonction run des fichiers `TrainA` et `TrainB`. 

***Voir comment faire dans les commentaires contenu dans ses fichiers.*

De plus, tous les paramètres modifiables se trouvent dans le fichier : `src/main/java/com/company/Main`

    static int NOMBRE_DE_TRAINS_A = 5;
    static int NOMBRE_DE_TRAINS_B = 5;

    static boolean EXECUTION_RALENTIT = true; // add 1 seconde wait between execution inside a thread

    static boolean ONLY_A = false; // cancel B traces
    static boolean ONLY_B = true; // cancel A traces

    static boolean TRACE_ROUTE_A = true; // show traces for route A
    static boolean TRACE_ROUTE_B = true; // show traces for route B
    static boolean TRACE_ROUTE_AB = true; // show traces for route AB
    static boolean TRACE_ROUTE_ABC = true; // show traces for route ABC

    static boolean TRACE_REPARATION = true; // show traces for reparation
    static boolean TRACE_DELAI = true; // show traces for delai
    

### Lancer l'application

Pour pouvoir lancer l'application, il vous faut
une version de java 1.8 ou supérieur et 
installer maven.

Pour installer Maven vir : http://maven.apache.org/install.html

Si vous avez un Mac : vous pouvez utiliser le gestionnaire de dépendance Brew pour simplifier la tâche.


Pour lancer l'application, simplement utiliser la commande suivante dans votre terminal

`mvn install && mvn exec:java`

Si vous avez des questions n'hésitez pas à nous contacter.
