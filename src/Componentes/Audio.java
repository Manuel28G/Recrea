/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Clase para la reproducción de sonido en la aplicación
 * @author Manuel Goncalves L.
 */
   public class Audio {
    private Clip clip;
    public Audio(String audio) throws FileNotFoundException, IOException {
        try{
        clip= AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(audio)));
        }
        catch(Exception ex){
        System.out.println("Error encontrado en constructor Sonido: "+ex);
        }
    }
    
    public void Play(){
        clip.start();
    }
}
