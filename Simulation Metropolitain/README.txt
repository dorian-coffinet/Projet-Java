Projet de simulation simplifié de métropolitain en Java
Réalisation d’un simulateur d’une ligne de métro et d’étudier l’impact des pannes de rames sur le temps de transport des passagers.

Les rames tournent dans le même sens.
Les passagers doivent tous descendre à la fin d’une ligne (une rame ne doit pas avoir de passagers lorsqu’elle change de coté) 

Une liste d’évènement est créée avec les éléments suivant :

APS : Arrivée Passager Station. Les passagers arrivent à droite ou à gauche avec une probabilité identique.
ARR : Arrivée Rame Rail. La rame ouvre ses portes.
DRS : Départ Rame Station. La rame ferme ses portes et redémarre 
RAP : Redémarre Après Panne d’une rame 
PAN : PANne de la rame
FIN : FIN de la simulation

On lance la simulation puis on choisit le nombre de pas à réaliser.