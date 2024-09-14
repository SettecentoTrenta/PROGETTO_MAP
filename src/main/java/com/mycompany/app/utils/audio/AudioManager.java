package com.mycompany.app.utils.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import static com.mycompany.app.view.NewGameView.musicButtonSetValue;

import java.nio.file.Path;

/**
 * AudioManager class.
 */
public final class AudioManager {

    /**
     * Clip.
     */
    private static Clip clip; 

    /**
     * Stato di riproduzione.
     */
    private static boolean isPlaying = false;

    /**
     * Carica la clip audio.
     * @param filePath percorso del file audio
     */
    public static void loadClip(final Path filePath) {
        try (AudioInputStream inputStream = AudioSystem.getAudioInputStream(filePath.toFile())) {
            clip = AudioSystem.getClip();
            clip.open(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Avvia la riproduzione della clip.
     */
    public static synchronized void startClip() {
        if (clip != null && !isPlaying) {
            isPlaying = true;
            changeIcon();
            clip.start();
        }
    }

    /**
     * Ferma la riproduzione della clip.
     */
    public static synchronized void stopClip() {
        if (clip != null && isPlaying) {
            isPlaying = false;
            changeIcon();
            clip.stop();
        }
    }

    public static boolean mixerStatus() {
        return isPlaying;
    }

    /**
     * Cambia l'icona del pulsante della musica in base allo stato di riproduzione.
     */
    private static synchronized void changeIcon() {
        if (!isPlaying) {
            musicButtonSetValue("🔇");
        } else {
            musicButtonSetValue("🔊");
        }
    }
}