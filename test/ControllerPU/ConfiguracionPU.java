/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;

import Componentes.BotonRecrea;
import Componentes.ComboBoxRecrea;
import Componentes.LabelRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TAreaRecrea;
import Componentes.TextBoxRecrea;
import Controller.Configuracion;
import Controller.Util;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ConfiguracionPU {
    private ComboBoxRecrea cbRecrea;
    private BotonRecrea btRecrea;
    private TextBoxRecrea tbRecrea;
    private NumberBoxRecrea nbRecrea;
    private TAreaRecrea taRecrea;
    private LabelRecrea lbRecrea;
    private final Configuracion config;
    
    public ConfiguracionPU() {
        
    btRecrea=new BotonRecrea();
    tbRecrea=new TextBoxRecrea();
    nbRecrea=new NumberBoxRecrea();
    taRecrea=new TAreaRecrea();
    cbRecrea=new ComboBoxRecrea();
    lbRecrea=new LabelRecrea();
    config=new Configuracion();
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void setConfiguracion(){
        
      config.SetConfiguracion(Util.CONFIG_COLOR_LETRA_ROJO, Util.CONFIG_TAMAÑO_LETRA_GRANDE, cbRecrea);
      assertEquals(Color.RED,cbRecrea.getForeground());
      assertEquals(config.textoGrand,cbRecrea.getFont().getSize());
      config.SetConfiguracion(Util.CONFIG_COLOR_LETRA_NEGRO, Util.CONFIG_TAMAÑO_LETRA_INTERMED, tbRecrea);
      assertEquals(Color.BLACK,tbRecrea.getForeground());
      assertEquals(config.textoInter,tbRecrea.getFont().getSize());
      config.SetConfiguracion(Util.CONFIG_COLOR_LETRA_BLANCO, Util.CONFIG_TAMAÑO_LETRA_MED, lbRecrea);
      assertEquals(Color.WHITE,lbRecrea.getForeground());
      assertEquals(config.textoMed,lbRecrea.getFont().getSize());
      config.SetConfiguracion(Util.CONFIG_COLOR_LETRA_AZUL, Util.CONFIG_TAMAÑO_LETRA_PEQUE, taRecrea);
      assertEquals(Color.BLUE,taRecrea.getForeground());
      assertEquals(config.textoPeque,taRecrea.getFont().getSize());
      
    }
    
    @Test
    public void setTamaño(){
        
      cbRecrea.setFont(config.SetTamaño( Util.CONFIG_TAMAÑO_LETRA_GRANDE));
      assertEquals(config.textoGrand,cbRecrea.getFont().getSize());
      nbRecrea.setFont(config.SetTamaño( Util.CONFIG_TAMAÑO_LETRA_MED));
      assertEquals(config.textoMed,nbRecrea.getFont().getSize());
      taRecrea.setFont(config.SetTamaño( Util.CONFIG_TAMAÑO_LETRA_INTERMED));
      assertEquals(config.textoInter,taRecrea.getFont().getSize());
      lbRecrea.setFont(config.SetTamaño( Util.CONFIG_TAMAÑO_LETRA_PEQUE));
      assertEquals(config.textoPeque,lbRecrea.getFont().getSize());
    }
    
    @Test
    public void setColor(){
        
      cbRecrea.setBackground(config.SetColor(Util.CONFIG_COLOR_LETRA_AZUL));
      assertEquals(Color.BLUE,cbRecrea.getBackground());
      tbRecrea.setBackground(config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
      assertEquals(Color.WHITE,tbRecrea.getBackground());
      taRecrea.setBackground(config.SetColor(Util.CONFIG_COLOR_LETRA_NEGRO));
      assertEquals(Color.BLACK,taRecrea.getBackground());
      lbRecrea.setBackground(config.SetColor(Util.CONFIG_COLOR_LETRA_ROJO));
      assertEquals(Color.RED,lbRecrea.getBackground());
      
    }
    
    @Test
    public void maxErrores(){
        int val=3;
        assertNotNull(config.GetMaxErrores());
        config.SetMaxErrores(val);
        assertEquals(val,config.GetMaxErrores());
        config.SetMaxErrores(val+55);
        assertEquals(val+55,config.GetMaxErrores());
    }
    
    @Test
    public void getClave(){
        assertNotNull(config.GetClave());
        assertNotSame("",config.GetClave());
        assertNotNull(config.GetClave());
        assertEquals("recrea2016",config.GetClave());
    }
}
