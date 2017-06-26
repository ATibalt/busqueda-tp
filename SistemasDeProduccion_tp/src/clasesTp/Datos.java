/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class Datos {
    static List<Regla> listaReglas;
    private static final String GPSFAMILIA = "Enviar posicion GPS a familiar y audio del incidente";
    private static final String GPSPOLICIA = "Enviar posicion GPS a policia y audio";
    private static final String LLAMA911 = "Llamar al 911 y dejar microfono abierto";
    private static final String LLAMABOMBERO = "Llamar a bomberos y dejar microfono abierto";
    private static final String LLAMAFAMILIA = "Llamar a familiar y dejar micrófono abierto";
    private static final String LLAMAPOLICIA = "Llamar a policía de la zona y dejar micrófono abierto";
    private static final String LLAMAAMBULANCIA = "Llamar ambulancia y dejar micrófono abierto";
    private static final String SONARALARMAGPSPOLICIA  = "Sonar alarma vecinal y enviar posición GPS a policía de la zona";
    
    public static List<Regla> cargarDatos(){
        
        listaReglas = new ArrayList<>();
        List<String> listaCondicion;

        listaCondicion= new ArrayList<>();
        listaCondicion.add("dar");
        listaCondicion.add("plata");

        Regla regla1 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla1.setId(1.0);
        listaReglas.add(regla1);

        Regla regla2 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla2.setId(1.1);
        listaReglas.add(regla2);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("mover");
        listaCondicion.add("disparar");

        Regla regla3 = new Regla(listaCondicion,LLAMA911);
        regla3.setId(2.0);
        listaReglas.add(regla3);
        
        Regla regla4 = new Regla(listaCondicion,GPSPOLICIA);
        regla4.setId(2.1);
        listaReglas.add(regla4);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("arriba");
        listaCondicion.add("manos");
        listaCondicion.add("quieto");
        Regla regla5 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla5.setId(3.0);
        listaReglas.add(regla5);
        
        Regla regla6 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla6.setId(3.1);
        listaReglas.add(regla6);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("amigo");
        listaCondicion.add("quieto");

        Regla regla7 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla7.setId(4.0);
        listaReglas.add(regla7);
        
        Regla regla8 = new Regla(listaCondicion,GPSFAMILIA);
        regla8.setId(4.1);
        listaReglas.add(regla8);
        
         listaCondicion= new ArrayList<>();
        listaCondicion.add("dale");
        listaCondicion.add("amigo");
        listaCondicion.add("dar");
        listaCondicion.add("cosas");
        Regla regla9 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla9.setId(5.0);
        listaReglas.add(regla9);
        
        Regla regla10 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla10.setId(5.1);
        listaReglas.add(regla10);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("dale");
        listaCondicion.add("disparar");
       
        Regla regla11 = new Regla(listaCondicion,LLAMA911);
        regla11.setId(6.0);
        listaReglas.add(regla11);
        
        Regla regla12 = new Regla(listaCondicion,GPSPOLICIA);
        regla12.setId(6.1);
        listaReglas.add(regla12);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("dar");
        listaCondicion.add("cosas");
        listaCondicion.add("rapido");
       
        Regla regla13 = new Regla(listaCondicion, SONARALARMAGPSPOLICIA);
        regla13.setId(7.0);
        listaReglas.add(regla13);
        
        Regla regla14 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla14.setId(7.1);
        listaReglas.add(regla14);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("tener");
        listaCondicion.add("arma");
       
        Regla regla15 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla15.setId(8.0);
        listaReglas.add(regla15);
        
        Regla regla16 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla16.setId(8.1);
        listaReglas.add(regla16);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("nadie");
        listaCondicion.add("mover");
        listaCondicion.add("matar");
       
        Regla regla17 = new Regla(listaCondicion,LLAMA911);
        regla17.setId(9.0);
        listaReglas.add(regla17);
        
        Regla regla18 = new Regla(listaCondicion,GPSPOLICIA);
        regla18.setId(9.1);
        listaReglas.add(regla18);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("estar");
        listaCondicion.add("plata");
       
        Regla regla19 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla19.setId(10.0);
        listaReglas.add(regla19);
        
        Regla regla20 = new Regla(listaCondicion,GPSFAMILIA);
        regla20.setId(10.1);
        listaReglas.add(regla20);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("mover");
        listaCondicion.add("matar");
       
        Regla regla21 = new Regla(listaCondicion,LLAMA911);
        regla21.setId(11.0);
        listaReglas.add(regla21);
        
        Regla regla22 = new Regla(listaCondicion,GPSPOLICIA);
        regla22.setId(11.1);
        listaReglas.add(regla22);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("mover");
        listaCondicion.add("nadie");
        listaCondicion.add("salir");
        listaCondicion.add("vivo");
       
        Regla regla23 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla23.setId(12.0);
        listaReglas.add(regla23);
        
        Regla regla24 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla24.setId(12.1);
        listaReglas.add(regla24);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("abrir");
        listaCondicion.add("caja");
        listaCondicion.add("dar");
        listaCondicion.add("plata");
       
        Regla regla25 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla25.setId(13.0);
        listaReglas.add(regla25);
        
        Regla regla26 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla26.setId(13.1);
        listaReglas.add(regla26);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("llamar");
        listaCondicion.add("policia");
        listaCondicion.add("matar");
       
        Regla regla27 = new Regla(listaCondicion,LLAMA911);
        regla27.setId(14.0);
        listaReglas.add(regla27);
        
        Regla regla28 = new Regla(listaCondicion,GPSPOLICIA);
        regla28.setId(14.1);
        listaReglas.add(regla28);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("gritar");
        listaCondicion.add("matar");
       
        Regla regla29 = new Regla(listaCondicion,LLAMA911);
        regla29.setId(15.0);
        listaReglas.add(regla29);
        
        Regla regla30 = new Regla(listaCondicion,GPSPOLICIA);
        regla30.setId(15.1);
        listaReglas.add(regla30);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("plata");
        listaCondicion.add("tener");
        listaCondicion.add("dar");
       
        Regla regla31 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla31.setId(16.0);
        listaReglas.add(regla31);
        
        Regla regla32 = new Regla(listaCondicion,GPSFAMILIA);
        regla32.setId(16.1);
        listaReglas.add(regla32);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("estar");
        listaCondicion.add("robar");
        listaCondicion.add("ayudar");
       
        Regla regla33 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla33.setId(17.0);
        listaReglas.add(regla33);
        
        Regla regla34 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla34.setId(17.1);
        listaReglas.add(regla34);
      
        listaCondicion= new ArrayList<>();
        listaCondicion.add("llevar");
        listaCondicion.add("cosas");
        listaCondicion.add("hacer");
        listaCondicion.add("dañar");
       
        Regla regla35 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla35.setId(18.0);
        listaReglas.add(regla35);
        
        Regla regla36 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla36.setId(18.1);
        listaReglas.add(regla36);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("ayudar");
        listaCondicion.add("dañar");
       
        Regla regla37 = new Regla(listaCondicion,LLAMA911);
        regla37.setId(19.0);
        listaReglas.add(regla37);
        
        Regla regla38 = new Regla(listaCondicion,GPSPOLICIA);
        regla38.setId(19.1);
        listaReglas.add(regla38);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("pegar");
       
        Regla regla39 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla39.setId(20.0);
        listaReglas.add(regla39);
        
        Regla regla40 = new Regla(listaCondicion,GPSFAMILIA);
        regla40.setId(20.1);
        listaReglas.add(regla40);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("salir");
        listaCondicion.add("abusador");
       
        Regla regla41 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla41.setId(21.0);
        listaReglas.add(regla41);
        
        Regla regla42 = new Regla(listaCondicion,GPSFAMILIA);
        regla42.setId(21.1);
        listaReglas.add(regla42);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("hacer");
        listaCondicion.add("soltar");
        listaCondicion.add("cuchillo");
       
        Regla regla43 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla43.setId(22.0);
        listaReglas.add(regla43);
        
        Regla regla44 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla44.setId(22.1);
        listaReglas.add(regla44);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("gritar");
       
        Regla regla45 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla45.setId(23.0);
        listaReglas.add(regla45);

        Regla regla46 = new Regla(listaCondicion,GPSFAMILIA);
        regla46.setId(23.1);
        listaReglas.add(regla46);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("soltar");
        listaCondicion.add("dolor");
       
        Regla regla47 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla47.setId(24.0);
        listaReglas.add(regla47);

        Regla regla48 = new Regla(listaCondicion,GPSFAMILIA);
        regla48.setId(24.1);
        listaReglas.add(regla48);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("voler");
        listaCondicion.add("hacer");
        listaCondicion.add("matar");
       
        Regla regla49 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla49.setId(25.0);
        listaReglas.add(regla49);

        Regla regla50 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla50.setId(25.1);
        listaReglas.add(regla50);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("ayudar");

        Regla regla51 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla51.setId(26.0);
        listaReglas.add(regla51);

        Regla regla56 = new Regla(listaCondicion,GPSFAMILIA);
        regla56.setId(26.1);
        listaReglas.add(regla56);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("alguien");
        listaCondicion.add("llamar");
        listaCondicion.add("ambulancia");

        Regla regla57 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla57.setId(27.0);
        listaReglas.add(regla57);

        Regla reglas58 = new Regla(listaCondicion,GPSPOLICIA);
        reglas58.setId(27.1);
        listaReglas.add(reglas58);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("fuego");

        Regla regla59 = new Regla(listaCondicion,LLAMABOMBERO);
        regla59.setId(28.0);
        listaReglas.add(regla59);
        
        Regla regla60 = new Regla(listaCondicion,GPSPOLICIA);
        regla60.setId(28.1);
        listaReglas.add(regla60);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("morir");

        Regla regla61 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla61.setId(29.0);
        listaReglas.add(regla61);

        Regla regla62 = new Regla(listaCondicion,GPSPOLICIA);
        regla62.setId(29.1);
        listaReglas.add(regla62);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("estar");
        listaCondicion.add("asfixiar");

        Regla regla63 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla63.setId(30.0);
        listaReglas.add(regla63);

        Regla regla64 = new Regla(listaCondicion,GPSPOLICIA);
        regla64.setId(30.1);
        listaReglas.add(regla64);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("perder");
        listaCondicion.add("conocimiento");

        Regla regla65 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla65.setId(31.0);
        listaReglas.add(regla65);

        Regla regla66 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla66.setId(31.1);
        listaReglas.add(regla66);

        Regla regla67 = new Regla(listaCondicion, LLAMAAMBULANCIA);
        regla67.setId(31.2);
        listaReglas.add(regla67);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("estar");
        listaCondicion.add("fuego");

        Regla regla68 = new Regla(listaCondicion,LLAMABOMBERO);
        regla68.setId(32.0);
        listaReglas.add(regla68);

        Regla regla69 = new Regla(listaCondicion,GPSPOLICIA);
        regla69.setId(32.1);
        listaReglas.add(regla69);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("herir");
        listaCondicion.add("disparar");

        Regla regla70 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla70.setId(33.0);
        listaReglas.add(regla70);

        Regla regla71 = new Regla(listaCondicion,GPSPOLICIA);
        regla71.setId(33.1);
        listaReglas.add(regla71);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("conocimiento");

        Regla regla72 = new Regla(listaCondicion,SONARALARMAGPSPOLICIA);
        regla72.setId(34.0);
        listaReglas.add(regla72);

        Regla regla73 = new Regla(listaCondicion,LLAMAPOLICIA);
        regla73.setId(34.1);
        listaReglas.add(regla73);

        Regla regla74 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla74.setId(34.2);
        listaReglas.add(regla74);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("chocar");
        listaCondicion.add("herir");

        Regla regla75 = new Regla(listaCondicion,LLAMAAMBULANCIA);
        regla75.setId(35.0);
        listaReglas.add(regla75);

        Regla regla76 = new Regla(listaCondicion,GPSPOLICIA);
        regla76.setId(35.1);
        listaReglas.add(regla76);

        listaCondicion= new ArrayList<>();
        listaCondicion.add("clave");

        Regla regla77 = new Regla(listaCondicion,LLAMAFAMILIA);
        regla77.setId(36.0);
        listaReglas.add(regla77);

        Regla regla78 = new Regla(listaCondicion,LLAMA911);
        regla78.setId(36.1);
        listaReglas.add(regla78);

        Regla regla79 = new Regla(listaCondicion,GPSPOLICIA);
        regla79.setId(36.2);
        listaReglas.add(regla79);

        return listaReglas;
    }
}
