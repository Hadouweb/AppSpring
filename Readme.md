# Minimal WebApp with Spring Framework and Docker using API

## Description
Il s'agit d'un projet conçu pour apprendre comment utiliser le Framework Spring et Docker.
C'est une WebApp simple qui utilise un autre projet Spring (une API).

> L'API est disponible ici : [https://github.com/Hadouweb/ApiSpringDocker](https://github.com/Hadouweb/ApiSpringDocker).

## Configuration de Docker
Pour exécuter ce projet à l'aide de Docker, suivez ces étapes :

1. Assurez-vous d'avoir Docker installé sur votre système.
2. Clonez ce dépôt sur votre machine locale.
3. Clonez également le dépôt de l'API HR (`https://github.com/Hadouweb/ApiSpringDocker`).
4. Ouvrez un terminal et rendez-vous dans le répertoire racine du projet ApiSpringDocker.
6. Exécutez la commande suivante pour démarrer les conteneurs Docker de l'api : `docker-compose up -d`
5. Ensuite, placez-vous dans le répertoire racine du projet HR-webapp et exécutez la commande suivante pour construire le projet HR-app avec Maven : `mvn clean package -Dmaven.test.skip=true`
6. Ensuite, exécutez la commande suivante pour démarrer le conteneur Docker de l'application : `docker run -d -p 9001:9001 --network apispring_HR-network --name HR-app hr-app`
7. L'application web sera accessible à l'adresse : http://localhost:9001
8. L'interface phpMyAdmin sera accessible à l'adresse : http://localhost:8081