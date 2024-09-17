package com.mycompany.app.utils.timemanager;

/**
 * Classe per gestire il tempo.
 */
public final class TimeManager {
    /**
     * Istanza singleton.
     */
    private static TimeManager instance;

    /**
     * Tempo in secondi.
     */
    private static int seconds;

    /**
     * Tempo in minuti.
     */
    private static int minutes;

    /**
     * Tempo in ore.
     */
    private static int hours;

    /**
     * Flag per indicare se il timer è in esecuzione.
     */
    private static boolean running;

    /**
     * Tempo di attesa.
     */
    private static final int SLEEP = 1000;

    /**
     * Costanti per la conversione.
     */
    private static final int CAST_SECONDS = 60;

    /**
     * Costanti per la conversione.
     */
    private static final int CAST_MINUTES = 60;

    /**
     * Costruttore privato.
     */
    private TimeManager() {

    }

    /**
     * Metodo per ottenere l'istanza singleton.
     * @return Istanza singleton.
     */
    public static TimeManager getInstance() {
        if (instance == null) {
            instance = new TimeManager();
        }
        return instance;
    };

    /**
     * Metodo per avviare il timer.
     */
    public static void startTimer() {
        running = true;
        Thread timerThread = new Thread(() -> {
            while (running && !Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(SLEEP);
                    seconds++;
                    if (seconds == CAST_SECONDS) {
                        seconds = 0;
                        minutes++;
                        if (minutes == CAST_MINUTES) {
                            minutes = 0;
                            hours++;
                        }
                    }
                } catch (InterruptedException e) {
                    running = false;
                    Thread.currentThread().interrupt();
                }
            }
        });
        timerThread.start();
    }

    /**
     * Metodo per fermare il timer.
     */
    public static void stopTimer() {
        running = false;
    }

    /**
     * Metodo per restituire il tempo.
     * @return Tempo
     */
    public static String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
