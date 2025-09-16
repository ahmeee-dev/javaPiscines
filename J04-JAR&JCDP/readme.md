# Java JAR - Module 04 Piscine Java
**Grade: 100/100**

## Overview
Module 04 of the Java Piscine introduces Java Archive (JAR) creation and external library integration.  
Students learn to package compiled classes and resources into JARs and use libraries like JCommander and JCDP/JColor for command-line parsing and colored console output.

## Project Objectives
- Organize source code into packages and proper folder structure (`edu.school21.printer`, `app`, `logic`).  
- Implement an image-to-character console printer using BMP files (`Exercise 00: Packages`).  
- Create a distribution package as a JAR containing both compiled classes and resources (`Exercise 01: First JAR`).  
- Integrate external libraries for enhanced functionality:
  - **JCommander** for command-line argument parsing  
  - **JCDP or JColor** for colored output (`Exercise 02: JCommander & JCDP`)  
- Ensure the application can be executed from the console with proper startup parameters.  
- Maintain a clean `target` folder with compiled classes and the final JAR.

## Skills Demonstrated
- **Package structuring**: proper separation of logic, startup, and utility classes  
- **File handling**: reading BMP images and converting them to character arrays  
- **JAR creation**: compiling classes and packaging resources into executable archives  
- **External library usage**: importing and using JAR libraries (`lib/` folder)  
- **Command-line parsing**: flexible startup parameters using JCommander  
- **Colored output**: enhancing console output with JCDP or JColor  
- **Build and assembly**: preparing a ready-to-run archive with all dependencies included

## Key Points
- JARs allow easy distribution of Java applications with all resources included  
- External libraries must be referenced correctly in the project structure (`lib/`) and during assembly  
- Command-line argument parsing simplifies configuration and makes programs more versatile  
- Colored output improves visual feedback for console-based applications  
- Proper package organization ensures maintainability and scalability of the code  
- README.txt should include instructions for compiling and running both source code and JAR

## Example
```bash
$ java -jar images-to-chars-printer.jar --white=RED --black=GREEN
```
## Result
**100/100**

## Italiano

# Module 04 – Piscine Java: JAR

## Panoramica
Il Module 04 della Piscine Java introduce la creazione di Java Archive (JAR) e l’integrazione di librerie esterne.  
Gli studenti imparano a impacchettare classi compilate e risorse in JAR e utilizzare librerie come JCommander e JCDP/JColor per parsing dei parametri da riga di comando e output colorato in console.

## Obiettivi del Progetto
- Organizzare il codice sorgente in pacchetti e cartelle corrette (`edu.school21.printer`, `app`, `logic`)  
- Implementare un programma che stampa immagini BMP in console usando caratteri (`Esercizio 00: Packages`)  
- Creare un pacchetto di distribuzione JAR contenente classi compilate e risorse (`Esercizio 01: First JAR`)  
- Integrare librerie esterne:
  - **JCommander** per la gestione dei parametri da riga di comando  
  - **JCDP o JColor** per output colorato (`Esercizio 02: JCommander & JCDP`)  
- Assicurare l’esecuzione del programma dalla console con parametri corretti  
- Mantenere la cartella `target` pulita con classi compilate e JAR finale  

## Competenze Dimostrate
- **Strutturazione pacchetti**: separazione chiara di logica, startup e classi utility  
- **Gestione file**: lettura di immagini BMP e conversione in array di caratteri  
- **Creazione JAR**: compilazione e impacchettamento delle risorse in archivi eseguibili  
- **Uso di librerie esterne**: importazione e utilizzo di librerie JAR (`lib/`)  
- **Parsing riga di comando**: parametri flessibili con JCommander  
- **Output colorato**: migliorare l’esperienza visiva in console  
- **Build e assemblaggio**: preparare un archivio pronto all’esecuzione con tutte le dipendenze incluse  

## Punti Chiave
- I JAR permettono distribuzione semplice di applicazioni Java con tutte le risorse incluse  
- Le librerie esterne devono essere referenziate correttamente nella struttura del progetto (`lib/`) e durante l’assemblaggio  
- Il parsing dei parametri da riga di comando semplifica la configurazione e rende il programma più versatile  
- L’output colorato migliora il feedback visivo nelle applicazioni console  
- Una corretta organizzazione dei pacchetti garantisce manutenibilità e scalabilità del codice  
- Il file README.txt deve contenere istruzioni per compilare e avviare sia il codice sorgente sia l’archivio JAR  

## Esempio di Avvio
```bash
$ java -jar images-to-chars-printer.jar --white=RED --black=GREEN
```
L’immagine viene visualizzata in console con i caratteri colorati specificati.

## Risultato
**100/100**
