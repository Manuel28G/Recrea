/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Manuel Goncalves L.
 */
   public class Audio {
    private InputStream inputStm;
    private AudioStream audioStm;
    public Audio(String audio) throws FileNotFoundException, IOException {
        inputStm=new FileInputStream(audio);
        audioStm=new AudioStream(inputStm);
    }
    
    public void Play(){
        AudioPlayer.player.start(audioStm);
    }
}
