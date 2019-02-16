# Classroom
ABOUT THIS APP

Le but de ce projet est de réaliser une application mobile native pour système Android, dédiés à des challenges sous forme de QUIZ, à savoir ici des questions avec réponses à choix multiples.
Cette application est distribuée sur un ensemble d'appareils qui exploite un référentiel de données commun, accessibles sous forme de services web

SPECIFICATIONS & FONCTIONNEMENT

Un utilisateur se connecte. Une fois reconnu, il accède à la liste de ses amis. Une coloration différente au moment de l'affichage distingue les amis qui sont connectés/déconnectés. En sélectionnant un de ses amis connectés, un
duel est lancé avec celui-ci. Une question d'un quiz s'affiche à l'utilisateur, dans une nouvelle activité, en même temps qu'elle est envoyée à l'ami sélectionné. Les 2 adversaires doivent répondre à la question en un temps limité. La note de chacun est fonction du temps qu'il a pris pour bien répondre. Le gagnant sera celui qui aura la meilleure note du quiz.

GETTING STARTED!

Pour commencer, il faut cloner le projet dans le repositoire local de votre machine.
Lien:
Ouvrir le projet dans votre android studio. Puis synchroniser si nécessaire
Avoir XAMPP, WAMPP ou tout autre equivalent installé pour gérer la partie serveur.

minSdkVersion: 15
targetSdkVersion: 28
compileSdkVersion : 28

QUELQUES DETAILS D'IMPLEMENTATION

-Cette application est structurée à travers les packages(package pour activités, package pour fragments, classes...)

-Application construite autour des activités et fragments

-Usage d'un drawer pour illustrer le menu principale

-Un écran de préférence pour gérer les personnalisations de l'utilisateur

-Possibilité de se connecter(connexion réalisée avec la librairie Volley) et de se déconnecter de l'application

-ProgressBar de décompte de temps  lors d'un quiz

-Possibilité de partager l'application sur les réseaux sociaux

-Usage des intents et des Async Tasks

Les captures ci-dessous presentent quelques interfaces ded l'application:


