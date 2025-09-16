# Java Multithreading - Java03
**Grade: 100/100**

Per la versione italiana, vedere [Italiano](#italiano).

## Overview
Module 03 of the Java Piscine focuses on multithreading in Java.  
Students learn how to create, manage, and synchronize threads to perform tasks concurrently, simulating real-world client/server operations and optimizing computational workloads.

---

## Project Objectives
- Implement threads using `Thread` and `Runnable` (`Exercise 00: Egg, Hen... or Human?`).  
- Orchestrate sequential interaction between threads using synchronization (`Exercise 01: Egg, Hen, Egg, Hen...`).  
- Perform parallel computation by splitting array processing across multiple threads (`Exercise 02: Real Multithreading`).  
- Manage a limited number of threads to download files concurrently without creating excessive threads (`Exercise 03: Too Many Threads...`).  
- Handle command-line arguments for controlling program execution (`--count`, `--arraySize`, `--threadsCount`).  
- Use thread-safe operations and synchronization mechanisms (`synchronized` keyword, Object monitors).  

---

## Skills Demonstrated
- **Thread creation and management**: implementing `Runnable` or extending `Thread`.  
- **Synchronization techniques**: ensuring sequential execution of threads when needed.  
- **Parallel computation**: splitting workload and aggregating results safely across threads.  
- **Thread pooling concept**: managing limited concurrent threads to process multiple tasks efficiently.  
- **Non-deterministic behavior understanding**: recognizing that thread execution order is unpredictable.  
- **Console output management**: producing structured output despite concurrent execution.  

---

## Key Points
- Threads allow asynchronous execution and prevent the main process from blocking.  
- Understanding Producer-Consumer patterns helps coordinate thread interaction.  
- Splitting computation across threads can improve performance on large datasets.  
- Excessive thread creation can be costly; managing a fixed pool of threads is more efficient.  
- Multithreading requires careful handling of shared resources to prevent race conditions.  
- The output of multithreaded programs may vary due to non-deterministic scheduling.  

---

## Result
**100/100**

---

## Italiano

## Panoramica
Il Module 03 della Piscine Java si concentra sul multithreading.  
Gli studenti imparano a creare, gestire e sincronizzare thread per eseguire attività in parallelo, simulando scenari reali di client/server e ottimizzando carichi computazionali.

---

## Obiettivi del Progetto
- Implementare thread usando `Thread` e `Runnable` (`Esercizio 00: Egg, Hen... or Human?`).  
- Orchestrare l’interazione sequenziale tra thread usando sincronizzazione (`Esercizio 01: Egg, Hen, Egg, Hen...`).  
- Eseguire calcoli paralleli dividendo l’elaborazione di array tra più thread (`Esercizio 02: Real Multithreading`).  
- Gestire un numero limitato di thread per scaricare file in parallelo senza creare troppi thread (`Esercizio 03: Too Many Threads...`).  
- Gestire argomenti da riga di comando (`--count`, `--arraySize`, `--threadsCount`).  
- Utilizzare operazioni thread-safe e meccanismi di sincronizzazione (`synchronized`, monitor degli oggetti).  

---

## Competenze Dimostrate
- **Creazione e gestione dei thread**: implementazione di `Runnable` o estensione di `Thread`.  
- **Tecniche di sincronizzazione**: garantire l’esecuzione sequenziale dei thread quando necessario.  
- **Calcolo parallelo**: divisione del carico e aggregazione sicura dei risultati tra più thread.  
- **Concetto di thread pooling**: gestione di thread concorrenti limitati per elaborare più attività in modo efficiente.  
- **Comprensione del comportamento non deterministico**: riconoscere che l’ordine di esecuzione dei thread è imprevedibile.  
- **Gestione output console**: produzione di output strutturato nonostante l’esecuzione concorrente.  

---

## Punti Chiave
- I thread consentono l’esecuzione asincrona senza bloccare il processo principale.  
- La conoscenza del modello Producer-Consumer aiuta a coordinare l’interazione tra thread.  
- La divisione del calcolo tra thread può migliorare le performance su dataset grandi.  
- La creazione e completamento continua di thread è costosa; gestire un pool fisso è più efficiente.  
- Il multithreading richiede attenzione nella gestione delle risorse condivise per evitare race condition.  
- L’output dei programmi multithread può variare a causa della schedulazione non deterministica.  

---

## Risultato
**100/100**
