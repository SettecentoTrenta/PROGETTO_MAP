# Breve descrizione generale

Nel progetto, sono stati ampiamente utilizzati i concetti della programmazione orientata agli oggetti (OOP). La OOP è un paradigma di programmazione che organizza il codice intorno agli oggetti, che sono istanze di classi. Questo approccio favorisce la modularità, la riutilizzabilità e la manutenibilità del codice.

Nel progetto, sono state create diverse classi che rappresentano concetti specifici del dominio. Ogni classe ha le sue proprietà (attributi) e comportamenti (metodi). Questo permette di organizzare il codice in modo strutturato e coerente.

Inoltre, sono state utilizzate le relazioni tra le classi, come l'ereditarietà e l'aggregazione, per modellare le interazioni tra gli oggetti. L'ereditarietà permette di definire una classe base da cui altre classi possono ereditare attributi e metodi, facilitando la creazione di gerarchie di classi. L'aggregazione permette di creare relazioni tra oggetti, in cui un oggetto può contenere uno o più oggetti di altre classi.

Grazie all'utilizzo della OOP, il progetto è stato sviluppato in modo modulare e flessibile. Questo ha permesso di separare le responsabilità tra le diverse classi e facilitare la manutenzione del codice nel tempo.

# Trama del gioco
L'ambiente del gioco è un astronave e il protagonista è il pilota.
L'astronave durante un viaggio spaziale presenta dei problemi e l'obiettivo del protagonista è quello di risolvere i guasti, se ci riesce, riceverà in premio degli oggetti.

Si scopre andando avanti nel gioco che, in ogni stanza, è presente non solo un guasto, ma anche un intruso.
Se il giocatore finirà sopra l'intruso, allora il gioco sarà terminato.


# Spiegazione uso OOP

1. Classi e Oggetti

Nella OOP, le classi sono blueprint (modelli) che definiscono le proprietà e i comportamenti degli oggetti. Un oggetto è un'istanza di una classe.

Esempi di classi nei frammenti di codice:

    Commands: Una classe che contiene i metodi relativi alle azioni e ai comandi del gioco, come il movimento del giocatore o la gestione di eventi speciali (come incontrare un guasto).
    LevelController: Una classe che probabilmente controlla il flusso di gioco nei diversi livelli, gestendo la posizione del giocatore e i cambiamenti di mappa.
    FaultDetails: Queste classi rappresentano le strutture dati per il parsing del JSON ricevuto da un'API. Contengono le proprietà che descrivono una domanda di un quiz (come la categoria, la domanda e la risposta corretta).

In OOP, ogni classe rappresenta un concetto o entità, e viene utilizzata per creare oggetti che interagiscono tra loro.


2. Incapsulamento

L'incapsulamento è il concetto di nascondere i dettagli interni di una classe e rendere accessibili solo alcune parti di essa tramite metodi pubblici (getter e setter, o altri metodi). Questo protegge i dati interni della classe e mantiene il controllo sull'accesso e la modifica di questi dati.

Esempi:

    Nella classe FaultDetails, i campi type, difficulty, category, question, correct_answer, e incorrect_answers sono incapsulati. Sono privati (private) e accessibili solo tramite i metodi getter e setter. Questo permette di controllare come questi dati vengono letti e modificati.

```java
public String getQuestion() {
    return question;
}

public void setQuestion(String question) {
    this.question = question;
}
```

Nella classe Commands, i campi currentLevelX, currentLevelY, map, e levels sono dichiarati privati. Solo i metodi della classe stessa possono modificarli direttamente.

```java
private static int currentLevelX = 0;
private static int currentLevelY = 0;

```

3. Astrazione

L'astrazione è il concetto di nascondere la complessità interna e fornire un'interfaccia semplice per l'uso di un oggetto. L'obiettivo è nascondere i dettagli implementativi, esponendo solo ciò che è necessario all'utente.

Esempi:

    Nella classe Commands, il metodo movePlayer(EnumDirections directions) nasconde tutti i dettagli interni su come il giocatore viene effettivamente spostato sulla mappa. L'utente di questo metodo non ha bisogno di sapere come sono gestite le coordinate o i livelli. Basta chiamare il metodo con una direzione, e il movimento del giocatore verrà gestito automaticamente.

    ```java
    public static String movePlayer(final EnumDirections directions) {
    // logica complessa per spostare il giocatore
}
    ```

4. Polimorfismo

Il polimorfismo consente di utilizzare lo stesso metodo in diversi contesti. In pratica, puoi avere più versioni dello stesso metodo, o usare una classe base per trattare oggetti di classi derivate in modo uniforme.

Esempi di polimorfismo:

    Nei frammenti che hai fornito, c'è un piccolo accenno di polimorfismo nei metodi che gestiscono diverse direzioni di movimento (EnumDirections). Anche se c'è un solo metodo movePlayer, può accettare diverse direzioni (NORD, SUD, EST, OVEST) e reagisce in modo diverso in base alla direzione.

La programmazione orientata agli oggetti (OOP) è uno stile di programmazione che si basa sull'uso di "oggetti", che sono istanze di "classi", per strutturare e organizzare il codice. Nei frammenti di codice che mi hai inviato, la OOP viene utilizzata in vari modi. Di seguito spiegherò i principali concetti della OOP (come astrazione, incapsulamento, ereditarietà e polimorfismo) e come sono stati applicati.
1. Classi e Oggetti

Nella OOP, le classi sono blueprint (modelli) che definiscono le proprietà e i comportamenti degli oggetti. Un oggetto è un'istanza di una classe.

Esempi di classi nei frammenti di codice:

    Commands: Una classe che contiene i metodi relativi alle azioni e ai comandi del gioco, come il movimento del giocatore o la gestione di eventi speciali (come incontrare un guasto).
    LevelController: Una classe che probabilmente controlla il flusso di gioco nei diversi livelli, gestendo la posizione del giocatore e i cambiamenti di mappa.
    FaultDetails e FaultDetailsResponse: Queste classi rappresentano le strutture dati per il parsing del JSON ricevuto da un'API. Contengono le proprietà che descrivono una domanda di un quiz (come la categoria, la domanda e la risposta corretta).

In OOP, ogni classe rappresenta un concetto o entità, e viene utilizzata per creare oggetti che interagiscono tra loro.
2. Incapsulamento

L'incapsulamento è il concetto di nascondere i dettagli interni di una classe e rendere accessibili solo alcune parti di essa tramite metodi pubblici (getter e setter, o altri metodi). Questo protegge i dati interni della classe e mantiene il controllo sull'accesso e la modifica di questi dati.

Esempi:

    Nella classe FaultDetails, i campi type, difficulty, category, question, correct_answer, e incorrect_answers sono incapsulati. Sono privati (private) e accessibili solo tramite i metodi getter e setter. Questo permette di controllare come questi dati vengono letti e modificati.

    ```java

public String getQuestion() {
    return question;
}

public void setQuestion(String question) {
    this.question = question;
}
```

Nella classe Commands, i campi currentLevelX, currentLevelY, map, e levels sono dichiarati privati. Solo i metodi della classe stessa possono modificarli direttamente.

    ```java
    private static int currentLevelX = 0;
    private static int currentLevelY = 0;
    ```

In questo modo, i dettagli interni della gestione del livello e della mappa sono nascosti all'esterno della classe Commands, e solo i metodi pubblici (come movePlayer) possono accedervi e modificarli.

3. Astrazione

L'astrazione è il concetto di nascondere la complessità interna e fornire un'interfaccia semplice per l'uso di un oggetto. L'obiettivo è nascondere i dettagli implementativi, esponendo solo ciò che è necessario all'utente.

Esempi:

    Nella classe Commands, il metodo movePlayer(EnumDirections directions) nasconde tutti i dettagli interni su come il giocatore viene effettivamente spostato sulla mappa. L'utente di questo metodo non ha bisogno di sapere come sono gestite le coordinate o i livelli. Basta chiamare il metodo con una direzione, e il movimento del giocatore verrà gestito automaticamente.

    ```java
    public static String movePlayer(final EnumDirections directions) {
        // logica complessa per spostare il giocatore
    }
    ```

    Il metodo handleFault() astrarre la logica di comunicazione con l'API di trivia. L'utente non ha bisogno di sapere come funziona l'HTTP, il parsing del JSON o la gestione della risposta: deve solo sapere che, quando c'è un guasto, viene fatta una richiesta e viene presentata una domanda.


5. Polimorfismo

Il polimorfismo consente di utilizzare lo stesso metodo in diversi contesti. In pratica, puoi avere più versioni dello stesso metodo, o usare una classe base per trattare oggetti di classi derivate in modo uniforme.

Esempi di polimorfismo:

    Nei frammenti, c'è un piccolo accenno di polimorfismo nei metodi che gestiscono diverse direzioni di movimento (EnumDirections). Anche se c'è un solo metodo movePlayer, può accettare diverse direzioni (NORD, SUD, EST, OVEST) e reagisce in modo diverso in base alla direzione.

6. Responsabilità separate

Ogni classe ha una responsabilità unica:

    La classe Commands gestisce i comandi del giocatore e le interazioni con la mappa.
    La classe FaultDetails è responsabile di rappresentare una domanda e le sue risposte.
    La classe LevelController (anche se non mostrata qui completamente) probabilmente si occupa del controllo dei livelli.

Complessivamente, l'utilizzo della OOP in questo progetto ha permesso di creare una struttura chiara e organizzata, facilitando la comprensione e la manutenzione del codice nel tempo. L'incapsulamento, l'ereditarietà e l'aggregazione sono state fondamentali per modellare i concetti del dominio e creare interazioni tra gli oggetti in modo efficace.


# FILE

All'interno del nostro progetto, abbiamo utilizzato i file per la memorizzazione di alcune informazioni a lungo termine senza utilizzare il DB. La gestione dei file ci ha permesso di memorizzare e recuperare i dati del gioco in modo persistente, garantendo la continuità dell'esperienza di gioco per gli utenti. Per la maggior parte, abbiamo usato file di tipo JSON per memorizzare i dati in modo strutturato e leggibile, facilitandone la lettura e la manipolazione.

Un altro uso dei file in questo progetto è per l'esecuzioni di script .sql


Classe SaveGame

Questa classe rappresenta lo stato del gioco da salvare e caricare. Viene implementata in modo che ogni istanza contenga i dati necessari per ripristinare lo stato di gioco.

    Attributi:
        inventory: una lista che rappresenta l'inventario del giocatore, memorizzato tramite una lista di oggetti di tipo InventoryModel. L'inventario potrebbe includere armi, oggetti curativi o altre risorse.
        levelController: un oggetto di tipo LevelController che gestisce lo stato e la logica del livello corrente.
        playerX, playerY: rappresentano le coordinate del giocatore nella mappa o nel mondo di gioco. Questi valori sono fondamentali per ripristinare la posizione esatta del giocatore.

    Costruttore: Il costruttore è annotato con @JsonCreator e accetta come parametri l'inventario e il controller del livello. Questa annotazione consente alla libreria Jackson di creare istanze di SaveGame durante la deserializzazione.
        @JsonProperty: specifica i nomi dei campi nel file JSON, che devono corrispondere ai parametri passati al costruttore.

    Metodi getter e setter:
        I getter (getInventory(), getLevelController(), getPlayerX(), getPlayerY()) permettono di accedere ai vari attributi della classe.
        I setter (setPlayerX(), setPlayerY()) consentono di modificare le coordinate del giocatore.

    Annotazione @JsonTypeInfo:
        L'annotazione @JsonTypeInfo indica come Jackson dovrebbe gestire la serializzazione delle informazioni di tipo. In questo caso, il tipo della classe viene incluso come proprietà nel JSON (@class). Questo è utile nel caso in cui SaveGame sia parte di un sistema che supporta la serializzazione polimorfica, dove sono presenti sottoclassi.

Classe SaveManager

Questa classe si occupa di gestire il salvataggio e il caricamento dei file di stato del gioco. Si tratta di una classe "utility" con due metodi statici, il che significa che non è necessario creare un'istanza di SaveManager per utilizzarla.

    Metodi:

        saveFile(SaveGame game): Questo metodo salva lo stato di gioco passato come parametro in un file JSON.
            Usa la libreria Gson per convertire l'oggetto SaveGame in una stringa JSON (gson.toJson()).
            Il file viene salvato nel percorso specificato (gamedata.json) usando un FileWriter. Il try-with-resources assicura che il file venga chiuso automaticamente alla fine dell'operazione.
            In caso di errore, l'eccezione viene stampata tramite e.printStackTrace().

        loadFile(): Questo metodo carica lo stato di gioco da un file JSON.
            Usa FileReader per leggere il contenuto del file, e Gson per deserializzare il JSON in un oggetto SaveGame (gson.fromJson()).
            Anche qui, il blocco try-with-resources garantisce che il file venga chiuso correttamente dopo la lettura.
            Se si verifica un errore durante la lettura, l'eccezione viene gestita stampando lo stack trace.

# Database

Spiegazione dettagliata con commenti
1. Variabili e Attributi

    instance (singleton): La classe DatabaseConnection implementa il pattern Singleton, assicurandosi che solo un'istanza di questa classe venga creata. Il campo instance è utilizzato per mantenere questa istanza univoca.

    PROPERTIES_PATH (file delle proprietà): Definisce il percorso del file database.properties, che contiene le informazioni necessarie per stabilire la connessione al database (come URL, username e password).

    properties: Un oggetto Properties che viene utilizzato per caricare le informazioni di configurazione del database dal file database.properties.

    connection, url, username, password:
        connection: l'oggetto Connection che rappresenta la connessione al database.
        url: l'URL del database a cui connettersi.
        username: il nome utente per accedere al database.
        password: la password corrispondente.

2. Blocco static per il caricamento del driver

Prima che il sistema possa interagire con un database, è necessario caricare il driver corrispondente:

```java

static {
    try {
        Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
```

Il blocco static viene eseguito una volta alla prima esecuzione della classe. Qui viene caricato il driver del database H2, necessario per stabilire una connessione. Se il driver non viene trovato, viene lanciata un'eccezione ClassNotFoundException.
3. Costruttore Privato (Singleton)

```java

private DatabaseConnection() {
}
```

Il costruttore privato impedisce che la classe venga istanziata dall'esterno, assicurando che solo getInstance() possa creare e restituire l'istanza della classe.
4. Metodi per il Singleton

    getInstance(): Questo metodo controlla se l'istanza esiste. Se non esiste, la crea; altrimenti, restituisce quella esistente.

```java

public static DatabaseConnection getInstance() {
    if (instance == null) {
        instance = new DatabaseConnection();
    }
    return instance;
}
```

5. Inizializzazione e caricamento delle proprietà

    initProperties(Path propertiesPathParam): Carica le proprietà dal file specificato nel path PROPERTIES_PATH.

```java

private void initProperties(final Path propertiesPathParam) throws IOException {
    properties = new Properties();
    properties.load(new FileInputStream(PROPERTIES_PATH.toFile()));
}
```

    loadProperties(): Chiama il metodo initProperties() e legge le proprietà database.url, database.username, e database.password dal file delle proprietà.

```java

private void loadProperties() throws IOException {
    initProperties(PROPERTIES_PATH);
    this.url = properties.getProperty("database.url");
    this.username = properties.getProperty("database.username");
    this.password = properties.getProperty("database.password");
}
```

6. Inizializzazione della connessione

    initConnection(): Stabilisce la connessione al database utilizzando i valori url, username, e password caricati dalle proprietà.

```java

private void initConnection() throws SQLException {
    this.connection = DriverManager.getConnection(url, username, password);
}
```

7. Esecuzione degli script del database

    runSchemaScript(): Esegue uno script SQL specificato nel file delle proprietà per impostare lo schema del database.

```java

private void runSchemaScript() throws SQLException {
    final String scriptPath = properties.getProperty("database.runSchemaScript");
    Statement stmt = connection.createStatement();
    stmt.executeUpdate(scriptPath);
}
```

    runInventoryScript(): Esegue uno script SQL per creare o aggiornare l'inventario del database.

```java

private void runInventoryScript() throws SQLException {
    final String scriptPath = properties.getProperty("database.runInventoryScript");
    Statement stmt = connection.createStatement();
    stmt.executeUpdate(scriptPath);
}
```

8. Metodi di Connessione e Chiusura

    connect(): Questo è il metodo principale che gestisce la connessione al database. Carica le proprietà, inizializza la connessione e esegue gli script SQL necessari per impostare lo schema e l'inventario.

```java

public void connect() throws SQLException, IOException {
    loadProperties();
    initConnection();
    runSchemaScript();
    runInventoryScript();
}
```

    getConnection(): Restituisce l'oggetto Connection, permettendo ad altre parti del codice di interagire direttamente con il database.

```java

public Connection getConnection() {
    return connection;
}
```

    close(): Chiude la connessione al database quando non è più necessaria.

```java

public void close() throws SQLException {
    connection.close();
}
```

# Thread

Nella classe NewGameView abbiamo usato i thread in questo modo:
```java
        Thread timerThread = new Thread(() -> {
            timer = new Timer(1000, e -> {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                long hours = elapsedTime / 3600;
                long minutes = (elapsedTime % 3600) / 60;
                long seconds = elapsedTime % 60;
                String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timerLabel.setText(timeString);
            });
```

# GUI
Il progetto fa uso di una GUI realizzata mediante Java Swing
sono presenti 3 classi per la GUI:
    - HelpView
    - NewGameView
    - StartView


# API REST
Il programma effettua una richiesta HTTP e successivamente parsa il JSON

```java

/**
 * API request class.
 */
public final class ApiRequest {

    /**
     * Effettua una richiesta HTTP GET all'URL specificato e stampa la risposta.
     */
    public String fetch() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://opentdb.com/api.php?amount=10&difficulty=easy&type=boolean"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```
In questo frammento di codice, viene effettuata la richiesta HTTP e il risultato (il body) viene restituito sottoforma di una stringa


# Specifiche algebriche

Nel progetto, ci sono diverse specifiche algebriche che vanno sottolineate, ad esempio:

## FaultModel:

getCorrectAnswer: () -> String
Restituisce la risposta corretta.

setCorrectAnswer: (String correctAnswer) -> void
Imposta la risposta corretta.

getType: () -> String
Restituisce il tipo di errore.

setType: (String type) -> void
Imposta il tipo di errore.

getDifficulty: () -> String
Restituisce il livello di difficoltà.

setDifficulty: (String difficulty) -> void
Imposta il livello di difficoltà.

getCategory: () -> String
Restituisce la categoria della domanda.

setCategory: (String category) -> void
Imposta la categoria della domanda.

getQuestion: () -> String
Restituisce il testo della domanda.

setQuestion: (String question) -> void
Imposta il testo della domanda.

getIncorrectAnswers: () -> String[]
Restituisce un array di risposte errate.

setIncorrectAnswers: (String[] incorrectAnswers) -> void
Imposta l'array delle risposte errate.

getHint: () -> String
Restituisce l'indizio per la domanda.

setHint: (String hint) -> void
Imposta l'indizio per la domanda.

## GameObjModel

IMPOSTOR: () -> GameObjModel
Restituisce l'istanza dell'enum con il valore 'I'.

FAULT: () -> GameObjModel
Restituisce l'istanza dell'enum con il valore 'F'.

EMPTY: () -> GameObjModel
Restituisce l'istanza dell'enum con il valore ' ' (spazio vuoto).

GameObjModel: (char valueParam) -> GameObjModel
Costruttore che accetta un parametro di tipo char e inizializza l'istanza con il valore passato (valueParam).

## InventoryModel

getId: () -> int
Restituisce l'ID dell'item.

getItemName: () -> String
Restituisce il nome dell'item.

getItemDescription: () -> String
Restituisce la descrizione dell'item.

setId: (int idParam) -> void
Imposta l'ID dell'item.

setItemName: (String itemNameParam) -> void
Imposta il nome dell'item.

setItemDescription: (String itemDescriptionParam) -> void
Imposta la descrizione dell'item.

addToList: (InventoryModel model) -> void
Aggiunge un'istanza di InventoryModel alla lista statica degli item.

getList: () -> List<InventoryModel>
Restituisce la lista statica degli item.


## Level
    getName: () -> String
    Restituisce il nome del livello.

    setMap: (GameObjModel[][] mapParam) -> void
    Imposta la mappa del livello con un array bidimensionale di oggetti GameObjModel.

    getMap: () -> GameObjModel[][]
    Restituisce la mappa del livello, un array bidimensionale di oggetti GameObjModel.

Costruttore

    Level: (String name) -> Level
    Costruttore che accetta un parametro name di tipo String e crea un'istanza della classe Level con quel nome.