## Gestione dell'Ereditarietà

L'approccio principale che ho scelto per la creazione delle tabelle del database è stato l'utilizzo della strategia **Single-Table** per quanto riguarda la tabella **Pubblicazioni**. Ho optato per questa soluzione perché, nonostante lo svantaggio di non poter impostare i campi come non-nullable, le sottoclassi presentavano pochissimi attributi specifici (solo due per i libri e uno per le riviste). Di conseguenza, utilizzare una strategia JOINED o TABLE PER CLASS mi sarebbe sembrato eccessivo. Il diagramma che ho disegnato è leggermente diverso da quello generato su pgAdmin: **per una mia organizzazione mentale** ho preferito rappresentare la classe padre come se fosse una tabella staccata, ma l'idea della **Single-Table** era presente fin dall'inizio.

## Relazioni e Gestione dei Prestiti

La tabella che fa da ponte tra la tabella delle pubblicazioni e quella degli utenti è quella dei **prestiti**, la quale ha una relazione **ManyToOne** con entrambe. Questa scelta è stata dettata dal fatto che una singola pubblicazione può essere oggetto di più prestiti nel tempo e un utente può prendere più libri. Inizialmente avevo anche ipotizzato una relazione ManyToMany con gli utenti, ma poiché nelle indicazioni la classe **Prestito** faceva riferimento a un singolo **Utente** e non a una lista e la classe **Utente** non ha una lista di prestiti al suo interno, ho pensato che questa fosse la soluzione più corretta sia a livello organizzativo, sia per quanto richiesto nelle ricerche tramite le **TypedQuery**.

## Metodologia di Sviluppo

Come consigliato, ho lavorato a step commitando in specifici momenti:

1. Ho impostato e testato la connessione con il database.
2. Ho creato le classi e i collegamenti fra di loro per strutturare il DB secondo il diagramma creato in precedenza
3. Per la creazione dei metodi ho seguito i seguenti step:
   1. Creazione del metodo
   2. Test del metodo e creazione di eventuali **Exceptions**
   3. Verifica finale del suo funzionamento tramite vari test
   4. Commit del lavoro
