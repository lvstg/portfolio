# Othello

Othello est un jeu de société combinatoire abstrait opposant deux joueurs. Il se joue sur un tablier unicolore appelé 
othellier. 

Le but du jeu est simple : avoir le plus de pions de sa couleur sur le plateau à la fin de la partie.

## Table des matières

- [Description](#description)
  - [Mode](#mode)
  - [Taille de plateau](#taille de plateau)
  - [Give Up](#give Up)
  - [Undo](#undo)
  - [Redo](#redo)
- [Problèmes](#problèmes)

## Description

* Ce projet vous permet de jouer à Othello avec des fonctionnalités rajouter et / ou modifier.

### Mode 
Il existe trois modes distincts :
1. 'Human vs human', qui vous permet de jouer contre un autre human.
2. 'Human vs easy computer', qui vous permet de jouer contre un algorithme assez simple.
3. 'Human vs hard computer', qui vous permet de jouer contre un algorithme légèrement réfléchi.
### Taille de plateau
La taille standard de l'othellier est de 8x8 soit 64 cases. Ici vous pouvez choisir une taille de plateau allant de 3x3
à 15x15.
### Give Up
Le bouton 'Give Up' vous permet d'abandonner une partie en cours. Vous pouvez abandonner quand c'est votre tour, même
si votre adversaire est un algorithme.
### Undo
Le 'Undo' vous permet de revenir sur vos coups jouer. Si vous jouez contre un algorithme vous annulée le dernier
coup de votre adversaire et le vôtre en même temps. 

Cette fonctionnalité est activable grâce au bouton ou avec la combinaison des touches 'ctrl+Z'.
### Redo
Le bouton redo vous permet de revenir sur les mouvements déjà fais. Si vous jouez contre un algorithme vous rejouer
votre coup et celui de votre adversaire.

Cette fonctionnalité est possible temps que vous ne modifier pas un de vos anciens coups. Vous pouvez activer le 'Redo'
grâce au bouton ou avec la combinaison des touches 'ctrl+Y'/


