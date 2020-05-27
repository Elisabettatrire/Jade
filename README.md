# README

Il repository contiene gli esempi JADE svolti durante le lezioni del corso di Sistemi Operativi in Tempo Reale e Sistemi Operativi Distribuiti 2019/2020 della Laurea Magistrale in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche

## ESEMPI
### PrimoProgettoJade

L'esempio "PrimoProgettoJade" puo' essere quindi direttamente importato in Eclipse, NetBeans e IntelliJ ma occorre ricordare di cambiare il percorso alle librerie "jade.jar" e "commons-codec-1.3.jar" presenti nelle proprietà.

Il progetto e' strutturato in tre package, "agents", "behav" e "utils" come segue:

Agent
- MyAgent.java

Behav
- MyBehaviour.java
- MyCyclic.java
- MyOneShot.java
- MyTicker.java
- MyWaker.java
- ReceiveMessage.java
- SendMessage.java

Utils
- PlatformCreator.java

Per lanciare direttamente la piattaforma la classe di boot e' jade.Boot

Per la compilazione da riga di comando:
"javac -cp <path_to_jade.jar>/jade.jar:<path_to_commons-codec>/commons-codec-1.3.jar -d <destination_folder> <path_to_java_classes_src>/MyAgent.java"
Per il lancio da riga di comando: "java -cp <path_to_jade.jar>/jade.jar:<path_to_commons-codec>/commons-codec-1.3.jar:<path_to_binaries> jade.Boot -gui Gilbert:agents.MyAgent

In alternativa, si puo' creare una configurazione di lancio nell'IDE usato. Una possibile configurazione delle opzioni di lancio e'

- -gui Gilbert:agents.MyAgent

Per testare lo scambio di messaggi una possibile configurazione delle opzioni di lancio della piattaforma e':

- -gui Sheed:agents.MyAgent(send);Gilbert:agents.MyAgent

Infine e' possibile lanciare la piattaforma da un'applicazione esterna. Per esempio puo' essere avviata l'applicazione dal main di "PlatformCreator".

Per lanciare un'esempio con due container e' possibile usare due configurazioni
1. -gui -host <IP_MAIN_CONTAINER> -port <PORTA_MAIN_CONTAINER> Gilbert:agents.MyAgent
2. -container -host <IP_MAIN_CONTAINER> -port <PORTA_MAIN_CONTAINER> Sheed:agents.MyAgent(send)

Si noti che -host può essere omesso se si lavora sulla stessa meccanica, come pure meno -port, se si lancia una sola piattaforma.

### DFProject

Anche il progetto DFProject puo' essere direttamente importato in Eclipse, NetBeans e IntelliJ, ma occorre ricordare di cambiare il percorso alle librerie "jade.jar" e "commons-codec-1.3.jar".

Il progetto e' strutturato in due package, "agents" e "behav" come segue:

Agents
	- Richiedente.java -> agente che ricerca il servizio di stampa presso il DF, e lo richiede
	- Stampatore.java -> agente che offre il servizio di stampa, pubblicandolo presso il DF
Behav
	- InteractionBehaviour.java -> OneShot behaviour di interazione con un altro agente; lascia il metodo action vuoto
	- ReceiveMessage.java -> Cyclic behaviour per ricevere i messaggi di accettazione e avvenuta stampa
	- ReceivePrintingRequest.java -> Cyclic behaviour per ricevere la richiesta di stampa
	- RegisterToDF.java -> OneShotBehaviour per registrare un servizio al DF
	- RequestPrintService.java -> InteractionBehaviour per richiedere una stampa
	- SearchService.java -> Ticker behaviour per cercare un servizio presso il DF
	- SubscribeToPrint.java -> Behaviour per iscriversi al servizio di notifica del DF

Per testare scambio di messaggi e uso del DF di default su una stessa piattaforma, una possibilita' e' lanciare due volte JADE con le seguenti configurazioni: 

- -gui -host <IP_HOST_MAIN_CONTAINER> Rick:agents.Richiedente
- -container -host <IP_HOST_MAIN_CONTAINER> Stam:agents.Stampatore

Per testare scambio di messaggi e federazione tra DF, su una stessa macchina e' possibile lanciare in sequenza jade con le seguenti configurazioni:

- -gui -host <IP_HOST_MAIN_CONTAINER> -mtps jade.mtp.http.MessageTransportProtocol(http://<IP_HOST_MAIN_CONTAINER>:7778/acc) Ricj:agents.Richiendente
- -gui -host <IP_HOST_MAIN_CONTAINER> -port 2099 -mtps jade.mtp.http.MessageTransportProtocol(http://<IP_HOST_MAIN_CONTAINER>:7779/acc) Stam:agents.Stampatore

Nella seconda piatafforma, quella con lo stampatore, basta aprire la GUI del df, cliccare il bottone per la federazione e aggiungere GUID e indirizzo del DF della prima piattaforma.