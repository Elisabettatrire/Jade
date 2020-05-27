# README

Il repository contiene gli esempi JADE svolti durante le lezioni del corso di Sistemi Operativi in Tempo Reale e Sistemi Operativi Distribuiti 2019/2020 della Laurea Magistrale in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche

## ESEMPI
### PrimoProgettoJade

L'esempio "PrimoProgettoJade" puo' essere quindi direttamente importato in Eclipse, NetBeans e IntelliJ ma occorre ricordare di cambiare il percorso alle librerie "jade.jar" e "commons-codec-1.3.jar" presenti nelle proprietà.

Il progetto e' strutturato in un package, "agents" come segue:

- agents
-- MyAgent.java


Per lanciare direttamente la piattaforma la classe di boot e' jade.Boot

Per la compilazione da riga di comando:
"javac -cp <path_to_jade.jar>/jade.jar:<path_to_commons-codec>/commons-codec-1.3.jar -d <destination_folder> <path_to_java_classes_src>/MyAgent.java"
Per il lancio da riga di comando: "java -cp <path_to_jade.jar>/jade.jar:<path_to_commons-codec>/commons-codec-1.3.jar:<path_to_binaries> jade.Boot -gui Gilbert:agents.MyAgent

In alternativa, si puo' creare una configurazione di lancio nell'IDE usato. Una possibile configurazione delle opzioni di lancio e'

- -gui Gilbert:agents.MyAgent

Per testare lo scambio di messaggi una possibile configurazione delle opzioni di lancio della piattaforma e':

-gui Pippo:agents.MyAgent(send);Pluto:agents.MyAgent

Infine e' possibile lanciare la piattaforma da un'applicazione esterna. Per esempio puo' essere avviata l'applicazione dal main di "PlatformCreator".

Per lanciare un'esempio con due container e' possibile usare due configurazioni
1. -gui Gilbert:agents.MyAgent
2. -container -host <IP_MAIN_CONTAINER> -port <PORTA_MAIN_CONTAINER> Sheed:agents.MyAgent(send)