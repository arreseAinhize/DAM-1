package paagbat.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

public class AudioManager {

    private MediaPlayer mediaPlayer;

    /**
     * Reproduce un archivo de audio.
     * @param audioFilePath La ruta del archivo de audio relativa a la carpeta de recursos (por ejemplo, "/paagbat/sounds/musica.mp3").
     */
    
    public void playAudio(String audioFilePath) {
        try {
            // Cargar el archivo de audio
            Media media = new Media(getClass().getResource(audioFilePath).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            // Configurar reproducción en bucle
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));
            mediaPlayer.play();

        } catch (URISyntaxException e) {
            System.err.println("Error al cargar el archivo de audio: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Archivo de audio no encontrado: " + audioFilePath);
        }
    }

    /**
     * Detiene la reproducción del audio actual.
     */
    public void stopAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    /**
     * Pausa la reproducción del audio actual.
     */
    public void pauseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    /**
     * Reanuda la reproducción del audio actual.
     */
    public void resumeAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }
}
