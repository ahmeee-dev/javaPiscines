# Java SQL/JDBC - Java05
**Grade: 100/100**

Per la versione italiana, vedere [Italiano](#italiano).

## Overview
Module 05 of the Java Piscine focuses on using **PostgreSQL via JDBC**.  
Students learn how to design relational schemas, map Java classes to SQL tables, implement DAO patterns, and perform CRUD operations safely and efficiently using connection pooling.

---

## Project Objectives
- Implement domain models (`User`, `Chatroom`, `Message`) with proper relations (one-to-many, many-to-many).  
- Create database schema (`schema.sql`) and populate with sample data (`data.sql`).  
- Implement repository interfaces and JDBC-based implementations:  
  - `MessagesRepository` (`findById`, `save`, `update`)  
  - `UsersRepository` (`findAll` with pagination)  
- Use **HikariCP** for connection pooling.  
- Handle exceptions for missing sub-entities (`NotSavedSubEntityException`).  
- Demonstrate repository methods in `Program.java`.  
- Map relational data to object-oriented Java classes while avoiding recursive sub-entity loading issues.  

---

## Skills Demonstrated
- **Relational modeling**: defining tables, primary keys, foreign keys, and many-to-many relations.  
- **JDBC usage**: connecting to PostgreSQL, executing SQL queries, using `PreparedStatement` and `ResultSet`.  
- **DAO pattern**: separating data access logic from business logic.  
- **CRUD operations**: read, create, update entities efficiently.  
- **Pagination**: retrieve subsets of data using SQL `LIMIT` and `OFFSET` or CTEs.  
- **Connection pooling**: using HikariCP to optimize database access.  
- **Error handling**: handling missing sub-entities with custom exceptions.  
- **Object-relational mapping**: mapping database rows to Java objects including relationships.  

---

## Key Points
- Proper design of schema and relationships is crucial for accurate object mapping.  
- Sub-entities should be partially loaded to prevent infinite recursion or excessive queries.  
- `findById` must populate essential fields and minimal sub-entity references.  
- `save` must validate existence of related entities before persisting.  
- `update` must handle null fields by updating database columns accordingly.  
- `findAll` with pagination must be implemented in a single query to avoid N+1 problem.  

---

## Result
**100/100**

---

## Italiano

## Panoramica
Il Module 05 della Piscine Java si concentra sull’uso di **PostgreSQL tramite JDBC**.  
Gli studenti imparano a progettare schemi relazionali, mappare classi Java a tabelle SQL, implementare pattern DAO e gestire CRUD in modo sicuro ed efficiente utilizzando connection pooling.

---

## Obiettivi del Progetto
- Implementare i modelli (`User`, `Chatroom`, `Message`) con relazioni corrette (one-to-many, many-to-many).  
- Creare schema del database (`schema.sql`) e popolare con dati di esempio (`data.sql`).  
- Implementare interfacce repository e implementazioni JDBC:  
  - `MessagesRepository` (`findById`, `save`, `update`)  
  - `UsersRepository` (`findAll` con paginazione)  
- Utilizzare **HikariCP** per il connection pooling.  
- Gestire eccezioni per sub-entità mancanti (`NotSavedSubEntityException`).  
- Testare i metodi repository in `Program.java`.  
- Mappare correttamente i dati relazionali in classi Java evitando caricamento ricorsivo infinito.  

---

## Competenze Dimostrate
- **Modeling relazionale**: definizione di tabelle, chiavi primarie e esterne, relazioni many-to-many.  
- **Uso di JDBC**: connessione a PostgreSQL, esecuzione di query, uso di `PreparedStatement` e `ResultSet`.  
- **Pattern DAO**: separazione della logica di accesso ai dati dalla logica di business.  
- **Operazioni CRUD**: leggere, creare e aggiornare entità in modo efficiente.  
- **Paginazione**: recupero di sottoinsiemi di dati usando `LIMIT` e `OFFSET` o CTE.  
- **Connection pooling**: uso di HikariCP per ottimizzare accesso al database.  
- **Gestione errori**: gestione delle sub-entità mancanti con eccezioni personalizzate.  
- **Object-relational mapping**: mappare righe del database in oggetti Java, incluse relazioni.  

---

## Punti Chiave
- Progettazione accurata di schema e relazioni per una corretta mappatura oggetti.  
- Le sub-entità devono essere caricate parzialmente per evitare ricorsione infinita o query eccessive.  
- `findById` deve popolare solo i campi essenziali e riferimenti minimi alle sub-entità.  
- `save` deve verificare l’esistenza delle entità correlate prima del salvataggio.  
- `update` deve gestire i campi null aggiornando le colonne del database di conseguenza.  
- `findAll` con paginazione deve essere implementato in una singola query per evitare il problema N+1.  

---

## Risultato
**100/100**
