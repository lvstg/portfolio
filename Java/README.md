# Othello

Othello is an abstract combinatorial board game played by two players. It is played on a single-coloured board called the 
othellier. 

The aim of the game is simple: to have the most pieces of your colour on the board at the end of the game.

## Table of contents

- [Description](#description)
  - [Mode](#mode)
  - [Tray size](#tray size)
  - [Give Up](#give Up)
  - [Undo](#undo)
  - [Redo](#redo)
- [Use It](#Use It)

## Description

* This project lets you play Othello with add and/or modify features.

### Mode 
There are three distinct modes:
1. 'Human vs human', which allows you to play against another human.
2. 'Human vs easy computer', which lets you play against a fairly simple algorithm.
3. 'Human vs hard computer', which allows you to play against a slightly reflexive algorithm.
### Tray size
The standard size of the othellier is 8x8, i.e. 64 squares. Here you can choose a board size ranging from 3x3
to 15x15.
### Give Up
The 'Give Up' button lets you abandon a game in progress. You can give up when it's your turn, even if your
if your opponent is an algorithm.
### Undo
The 'Undo' function allows you to go back to your previous moves. If you're playing against an algorithm, you'll undo your opponent's last move and your own at the same time.
your opponent's last move and your own at the same time. 

This feature can be activated using the button or the 'ctrl+Z' key combination.
### Redo
The redo button allows you to go back over moves you have already made. If you are playing against an algorithm you can replay
your move and that of your opponent.

This feature is available as long as you don't modify any of your old moves. You can activate the 'Redo' function
using the button or the key combination 'ctrl+Y'/.


## Use It
To run this programme you need to add the plugin javafx-maven version 0.0.4 in yours file 'pom.xml'. After you click on side button 'Maven' select the folder 'Plugins', 'javafx' and 'javafx:run'.