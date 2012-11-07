Projet de résolution d’une grille Sudoku

L’objectif est de réaliser la résolution de Sudoku avec un programme récursif.
Le programme doit retrouver toutes les grilles possibles.

Le programme se lance de la manière suivante :

java SusokuAll 420 009 500 000 000 097 970 068 002 000 690 308 090 253 010 503 084 000 100 830 069 780 000 000 004 900 071

L’ensemble des chiffres correspond à la lecture de la grille de gauche a droite et de bas en haut.
Exemple de la grille rentrée en paramètre:

 -------------------- 
|4 2   |    9 |5     |
|      |      |  9 7 |
|9 7   |  6 8 |    2 |
 -------------------- 
|      |6 9   |3   8 |
|  9   |2 5 3 |  1   |
|5   3 |  8 4 |      |
 -------------------- 
|1     |8 3   |  6 9 |
|7 8   |      |      |
|    4 |9     |  7 1 |
 -------------------- 

Le programme donne les solutions sous forme d'affichage dans le terminal:
 -------------------- 
|4 2 6 |1 7 9 |5 8 3 |
|8 3 1 |5 4 2 |6 9 7 |
|9 7 5 |3 6 8 |1 4 2 |
 -------------------- 
|2 4 7 |6 9 1 |3 5 8 |
|6 9 8 |2 5 3 |7 1 4 |
|5 1 3 |7 8 4 |9 2 6 |
 -------------------- 
|1 5 2 |8 3 7 |4 6 9 |
|7 8 9 |4 1 6 |2 3 5 |
|3 6 4 |9 2 5 |8 7 1 |
 -------------------- 

L’option –test permet de donner les solutions au format que l’on rentre en paramètre.

java SusokuAll –test 420 009 500 000 000 097 970 068 002 000 690 308 090 253 010 503 084 000 100 830 069 780 000 000 004 900 071
