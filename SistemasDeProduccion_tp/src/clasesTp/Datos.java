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
    static List<Regla> listaRestoEstimulos;
    private static String[][] arregloProfesorLugar;
    private static String[][] arregloMateriaCursar;   
    private static String[][] arregloMateriaRendir;
    private static Map<String, int[]> puntoFacultad = new HashMap<>();
    private static String[][] arregloProfesoresDictado;
    
    public static List<Regla> cargarDatos(){
        
        listaReglas = new ArrayList<>();
        List<String> listaCondicion;
        /*Saludo
        
        listaCondicion.add("hola");
        Regla regla1= new Regla(listaCondicion,"Buenas");
        regla1.setId(1.0);
        listaReglas.add(regla1);

        Regla regla2= new Regla(listaCondicion,"Hola!");
        regla2.setId(1.1);
        listaReglas.add(regla2);*/
        
        //Buscar Persona
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("estar");
        listaCondicion.add("profesoridentificado");
        
        
        Regla regla3 = new Regla(listaCondicion," se encuentra en ");
        regla3.setId(2.0);
        listaReglas.add(regla3);
        
        
        Regla regla4 = new Regla(listaCondicion," en ");
        regla4.setId(2.1);
        listaReglas.add(regla4);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("que");
        listaCondicion.add("lugar");
        listaCondicion.add("estar");
        listaCondicion.add("profesoridentificado");
        Regla regla5 = new Regla(listaCondicion," se encuentra en ");
        regla5.setId(2.0);
        listaReglas.add(regla5);
        
        Regla regla6 = new Regla(listaCondicion," en ");
        regla6.setId(2.1);
        listaReglas.add(regla6);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("estar");
        listaCondicion.add("profesoridentificado");
        Regla regla7 = new Regla(listaCondicion,"Si");
        regla7.setId(3.0);
        listaReglas.add(regla7);
        
        Regla regla8 = new Regla(listaCondicion,"Si, se encuentra en ");
        regla8.setId(3.1);
        listaReglas.add(regla8);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("localizar");
        listaCondicion.add("profesoridentificado");
        Regla regla9 = new Regla(listaCondicion,"Si");
        regla9.setId(3.0);
        listaReglas.add(regla9);
        
        Regla regla10 = new Regla(listaCondicion,"Si, se encuentra en ");
        regla10.setId(3.1);
        listaReglas.add(regla10);
        
         listaCondicion= new ArrayList<>();
        listaCondicion.add("profesoridentificado");
        listaCondicion.add("estar");
        listaCondicion.add("lugarfacultad");
        Regla regla11 = new Regla(listaCondicion,"Si");
        regla11.setId(3.0);
        listaReglas.add(regla11);
        
        Regla regla12 = new Regla(listaCondicion,"Si, se encuentra en ");
        regla12.setId(3.1);
        listaReglas.add(regla12);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla13 = new Regla(listaCondicion,"Si");
        regla13.setId(4.0);
        listaReglas.add(regla13);
        
        Regla regla14 = new Regla(listaCondicion,"No");
        regla14.setId(4.1);
        listaReglas.add(regla14);
        
        Regla regla15 = new Regla(listaCondicion,"Si, se rinde en ");
        regla15.setId(4.2);
        listaReglas.add(regla15);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla16 = new Regla(listaCondicion," se rinde en ");
        regla16.setId(5.0);
        listaReglas.add(regla16);
        
        Regla regla17 = new Regla(listaCondicion,"El examen es en ");
        regla17.setId(5.1);
        listaReglas.add(regla17);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("examen");
        listaCondicion.add("materiadetectada");
       
        Regla regla18 = new Regla(listaCondicion," se rinde en ");
        regla18.setId(5.0);
        listaReglas.add(regla18);
        
        Regla regla19 = new Regla(listaCondicion,"El examen es en ");
        regla19.setId(5.1);
        listaReglas.add(regla19);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("lugar");
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla20 = new Regla(listaCondicion," se rinde en ");
        regla20.setId(5.0);
        listaReglas.add(regla20);
        
        Regla regla21 = new Regla(listaCondicion,"El examen es en ");
        regla21.setId(5.1);
        listaReglas.add(regla21);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("cual");
        listaCondicion.add("aula");
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla22 = new Regla(listaCondicion," se rinde en ");
        regla22.setId(5.0);
        listaReglas.add(regla22);
        
        Regla regla23 = new Regla(listaCondicion,"El examen es en ");
        regla23.setId(5.1);
        listaReglas.add(regla23);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("que");
        listaCondicion.add("aula");
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla24 = new Regla(listaCondicion," se rinde en ");
        regla24.setId(5.0);
        listaReglas.add(regla24);
        
        Regla regla25 = new Regla(listaCondicion,"El examen es en ");
        regla25.setId(5.1);
        listaReglas.add(regla25);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("cursar");
        listaCondicion.add("materiadetectada");
       
        Regla regla26 = new Regla(listaCondicion," se cursa en ");
        regla26.setId(6.0);
        listaReglas.add(regla26);
        
        Regla regla27 = new Regla(listaCondicion," se dicta en ");
        regla27.setId(6.1);
        listaReglas.add(regla27);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("donde");
        listaCondicion.add("dictar");
        listaCondicion.add("materiadetectada");
       
        Regla regla28 = new Regla(listaCondicion," se cursa en ");
        regla28.setId(6.0);
        listaReglas.add(regla28);
        
        Regla regla29 = new Regla(listaCondicion," se dicta en ");
        regla29.setId(6.1);
        listaReglas.add(regla29);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("como");
        listaCondicion.add("llegar");
        listaCondicion.add("lugarfacultad");
       
        Regla regla30 = new Regla(listaCondicion,"Para llegar a lugarfacultad es");
        regla30.setId(7.0);
        listaReglas.add(regla30);
        
        Regla regla31 = new Regla(listaCondicion,"Para llegar a lugarfacultad tenes que");
        regla31.setId(7.1);
        listaReglas.add(regla31);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("camino");
        listaCondicion.add("lugarfacultad");
       
        Regla regla32 = new Regla(listaCondicion,"Para llegar a lugarfacultad es");
        regla32.setId(7.0);
        listaReglas.add(regla32);
        
        Regla regla33 = new Regla(listaCondicion,"Para llegar a lugarfacultad tenes que");
        regla33.setId(7.1);
        listaReglas.add(regla33);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("como");
        listaCondicion.add("ir");
        listaCondicion.add("lugarfacultad");
       
        Regla regla34 = new Regla(listaCondicion,"Para llegar a lugarfacultad es");
        regla34.setId(7.0);
        listaReglas.add(regla34);
        
        Regla regla35 = new Regla(listaCondicion,"Para llegar a lugarfacultad tenes que");
        regla35.setId(7.1);
        listaReglas.add(regla35);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("que");
        listaCondicion.add("piso");
        listaCondicion.add("lugarfacultad");
       
        Regla regla36 = new Regla(listaCondicion,"Queda en pisofacultad");
        regla36.setId(8.0);
        listaReglas.add(regla36);
        
        Regla regla37 = new Regla(listaCondicion,"lugarfacultad esta en pisofacultad");
        regla37.setId(8.1);
        listaReglas.add(regla37);
      
        Regla regla38 = new Regla(listaCondicion,"pisofacultad");
        regla38.setId(8.2);
        listaReglas.add(regla38);
      
        listaCondicion= new ArrayList<>();
        listaCondicion.add("hola");
       
        Regla regla39 = new Regla(listaCondicion,"Hola!");
        regla39.setId(9.0);
        listaReglas.add(regla39);
        
        Regla regla40 = new Regla(listaCondicion,"Buenas");
        regla40.setId(9.1);
        listaReglas.add(regla40);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("como");
        listaCondicion.add("estar");
       
        Regla regla41 = new Regla(listaCondicion,"Bien y espero que vos tambien");
        regla41.setId(10.0);
        listaReglas.add(regla41);
        
        Regla regla42 = new Regla(listaCondicion,"Hola! Los robots no sentimos :(");
        regla42.setId(10.1);
        listaReglas.add(regla42);
        
        Regla regla43 = new Regla(listaCondicion,"Hola! En que te puedo ayudar?");
        regla43.setId(10.2);
        listaReglas.add(regla43);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("que");
        listaCondicion.add("tal");
       
        Regla regla44 = new Regla(listaCondicion,"Bien y espero que vos tambien");
        regla44.setId(10.0);
        listaReglas.add(regla44);
        
        Regla regla45 = new Regla(listaCondicion,"Hola! Los robots no sentimos :(");
        regla45.setId(10.1);
        listaReglas.add(regla45);
        
        Regla regla46 = new Regla(listaCondicion,"Hola! En que te puedo ayudar?");
        regla46.setId(10.2);
        listaReglas.add(regla46);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("gracias");
       
        Regla regla47 = new Regla(listaCondicion,"Gracias a vos");
        regla47.setId(11.0);
        listaReglas.add(regla47);
        
        Regla regla48 = new Regla(listaCondicion,"De nada");
        regla48.setId(11.1);
        listaReglas.add(regla48);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("chau");
       
        Regla regla49 = new Regla(listaCondicion,"Hasta la proxima");
        regla49.setId(12.0);
        listaReglas.add(regla49);
        
        Regla regla50 = new Regla(listaCondicion,"Hasta la proxima");
        regla50.setId(12.1);
        listaReglas.add(regla50);
        
        Regla regla51 = new Regla(listaCondicion,"Chau");
        regla51.setId(12.2);
        listaReglas.add(regla51);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("decir");
        listaCondicion.add("algo");
       
        Regla regla52 = new Regla(listaCondicion,"En que te puedo ayudar?");
        regla52.setId(13.0);
        listaReglas.add(regla52);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("favor");
       
        Regla regla53 = new Regla(listaCondicion,"En que te puedo ayudar?");
        regla53.setId(13.0);
        listaReglas.add(regla53);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("necesitar");
       
        Regla regla54 = new Regla(listaCondicion,"En que te puedo ayudar?");
        regla54.setId(13.0);
        listaReglas.add(regla54);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("quien");
        listaCondicion.add("dictar");
        listaCondicion.add("materiadetectada");
  
        Regla regla55 = new Regla(listaCondicion," es dictada por ");
        regla55.setId(15.0);
        listaReglas.add(regla55);
        Regla regla56 = new Regla(listaCondicion,"Los profesores a cargo son: ");
        regla56.setId(15.1);
        listaReglas.add(regla56);
        Regla regla57 = new Regla(listaCondicion," estan a cargo de ");
        regla57.setId(15.2);
        listaReglas.add(regla57);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("que");
        listaCondicion.add("profesor");
        listaCondicion.add("dictar");
        listaCondicion.add("materiadetectada");
  
        Regla regla58 = new Regla(listaCondicion," es dictada por ");
        regla58.setId(15.0);
        listaReglas.add(regla58);
        Regla regla59 = new Regla(listaCondicion,"La dictan");
        regla59.setId(15.1);
        listaReglas.add(regla59);
        Regla regla60 = new Regla(listaCondicion," estan a cargo de ");
        regla60.setId(15.2);
        listaReglas.add(regla60);
        
        listaCondicion= new ArrayList<>();
        listaCondicion.add("estar");
        listaCondicion.add("rendir");
        listaCondicion.add("materiadetectada");
       
        Regla regla61 = new Regla(listaCondicion,"Si");
        regla61.setId(4.0);
        listaReglas.add(regla61);
        
        Regla regla62 = new Regla(listaCondicion,"No");
        regla62.setId(4.1);
        listaReglas.add(regla62);
        
        Regla regla63 = new Regla(listaCondicion,"Si, se rinde en ");
        regla63.setId(4.2);
        listaReglas.add(regla63);

      

        
        
        setProfesoresDictado();
        setLugar();
        setMateriaCursan();
        setMatriaRendir();
        setRestoEstimulos();
        setPuntoLugar();
        return listaReglas;
    }
    private static void setLugar(){
        
        String[][] arreglo = {{"milagros gutierrez","cidisi"},        
            {"jorge roa","cidisi"},
            {"ignacio gomez","anexo"},
            {"luciana ballejos","cidisi"},
            {"aldo vechietti","depto isi"},
            {"rodrigo ledesma","depto isi"},
            {"silvio gonnet","cidisi"},
            {"sonia pastorelli","materias basicas"},
            {"carlos suarez","lab fisica"},
            {"juan fernandez","depto electrica"},
            {"oscar maggi","depto civil"},
            {"victor tucci","depto industrial"},
            {"arnoldo reutemann","depto mecanica"},
            {"laura caliusco","relaciones internacionales"}};
        arregloProfesorLugar =arreglo;
    }
    public static String getLugar(String profesorIdentificado){
        for(String[] parPersonaLugar: arregloProfesorLugar){
            if(parPersonaLugar[0].equals(profesorIdentificado))
                return parPersonaLugar[1];
        }
        return "no encontrado";
    }
    private static void setMateriaCursan(){
        String[][] arreglo={{"analisis matematico i","aula 1"},
                {"analisis matematico ii","aula 20"},
                {"fisica i","lab fisica"},
                {"fisica ii","lab fisica"},
                {"algebra","aula 14"},
                {"matematica superior","aula 16"},
                {"matematica discreta","multimedios 5"},
                {"algoritmos","e3"},
                {"materiales","aula 21"},
                {"quimica","lab quimica"},
                {"inteligencia artificial","lab4"},
                {"sistemas de gestion","multimedios 1"},
                {"sistemas operativos","aula 19"},
                {"sistemas y organizaciones","aula 20"},
                {"comunicaciones","lab conectividad"},
                {"redes","lab conectividad"},
                {"gestion de datos","aula 4"}};
        arregloMateriaCursar=arreglo;
    }
    public static String getMateriaCursar(String materia){
        for(String[] parMateriaLugar: arregloMateriaCursar){
            if(parMateriaLugar[0].equals(materia))
                return parMateriaLugar[1];
        }
        return "lugar no encontrado";
    }
    public static void setMatriaRendir(){
        String[][] arreglo={{"analisis matematico i","aula 22"},
                {"fisica ii","lab fisica"},
                {"matematica superior","aula 18"},
                {"quimica","lab quimica"},
                {"inteligencia artificial","aula 1"}};
        arregloMateriaRendir=arreglo;
        
    }
    public static String getMateriaRendir(String materia){
        for(String[] parMateriaLugar: arregloMateriaRendir){
            if(parMateriaLugar[0].equals(materia))
                return parMateriaLugar[1];
        }
        return null;
    }
    
    public static List<Regla> getRestoEstimulos(){
        return listaRestoEstimulos;
       
        
    }
    public static void setRestoEstimulos(){
        listaRestoEstimulos=new ArrayList<>();
        List<String> condicion;
        condicion= new ArrayList<>();
        
        condicion.add("no");
        
               
        Regla regla1 = new Regla(condicion,"No te entiendo");
        regla1.setId(14.0);
        listaRestoEstimulos.add(regla1);
        
        Regla regla2 = new Regla(condicion,"No se que quisiste decir");
        regla2.setId(14.1);
        listaRestoEstimulos.add(regla2);
        
        Regla regla3 = new Regla(condicion,"Podes reformular la pregunta de manera mas entendible?");
        regla3.setId(14.2);
        listaRestoEstimulos.add(regla3);
    }
    public static void setPuntoLugar(){
        int[] arreglo1={124,60,3};
        puntoFacultad.put("cidisi",arreglo1);
        int[] arreglo2={137,67,2};
        puntoFacultad.put("anexo",arreglo2);
        int[] arreglo3={120,61,3};
        puntoFacultad.put("depto isi",arreglo3);
        int[] arreglo4={107,41,1};
        puntoFacultad.put("materias basicas",arreglo4);
        int[] arreglo5={158,38,0};
        puntoFacultad.put("lab fisica",arreglo5);
        int[] arreglo6={121,66,0};
        puntoFacultad.put("depto electrica",arreglo6);
        int[] arreglo7={111,71,1};
        puntoFacultad.put("depto civil",arreglo7);
        int[] arreglo8={119,87,1};
        puntoFacultad.put("depto industrial",arreglo8);
        int[] arreglo9={110,54,0};
        puntoFacultad.put("depto mecanica",arreglo9);
        
        int[] arreglo10={110,30,0};
        puntoFacultad.put("aula 1",arreglo10);
        
        int[] arreglo11={119,61,1};
        puntoFacultad.put("aula 20",arreglo11);
        
        int[] arreglo12={138,63,2};
        puntoFacultad.put("aula 22",arreglo12);
        int[] arreglo13={158,38,0};
        puntoFacultad.put("lab fisica",arreglo13);
        
        
        int[] arreglo14={152,33,1};
        puntoFacultad.put("aula 16",arreglo14);
        int[] arreglo15={158,38,1};
        puntoFacultad.put("aula 18",arreglo15);      
        int[] arreglo16={64,83,1};
        puntoFacultad.put("multimedios 5",arreglo16);
        int[] arreglo17={82,72,1};
        puntoFacultad.put("e3",arreglo17);
        int[] arreglo18={132,75,2};
        puntoFacultad.put("aula21",arreglo18);
        
        int[] arreglo19={154,56,3};
        puntoFacultad.put("lab 4",arreglo19);
        int[] arreglo20={52,88,1};
        puntoFacultad.put("multimedios 1",arreglo20);
        int[] arreglo21={141,37,1};
        puntoFacultad.put("aula 19",arreglo21);
        int[] arreglo22={144,59,3};
        puntoFacultad.put("lab conectividad",arreglo22);
        int[] arreglo23={134,33,0};
        puntoFacultad.put("aula 4",arreglo23);
	int[] arreglo24={158,34,0};
        puntoFacultad.put("lab quimica",arreglo24);
        int[] arreglo25={140,33,1};
        puntoFacultad.put("aula 14",arreglo25);
	
	
	
	
	
	
	
        

        
	
	
    }
    public static int[] getPuntoFacultad(String claveLugar){
        return puntoFacultad.get(claveLugar);
    }
     private static void setProfesoresDictado(){
        String[][] arreglo={{"analisis matematico i","Silvina Suau y Mauricio Botta"},
                {"analisis matematico ii","Sonia Pastorelli y Valeria Bertossi"},
                {"fisica i","Carlos Suarez y Fabian Gon"},
                {"fisica ii","Susana Roldan y Juan Alberto"},
                {"algebra","Adriana Frausini y Cristian Bernal"},
                {"matematica superior","Bianculi Luis y Pablo Kler"},
                {"matematica discreta","Fumero Yanina, Gagiardo Alejandra y Bernal Cristian"},
                {"algoritmos","Ambort Daniel, Castellaro Marta y Golobisky Fernanda"},
                {"materiales","Leurino Rodrigo Cesar y Gaitan Julio"},
                {"quimica","Alvis Carlos Alberto"},
                {"inteligencia artificial","Gutierrez Milagros, Roa Jorge y Gomez Ignacio"},
                {"sistemas de gestion","Villareal Pablo y Arriondo Alberto"},
                {"sistemas operativos","Pessolani Pablo, Chevalier Alicia, Alemandi Mariela y Padula Diego"},
                {"sistemas y organizaciones","Portillo Rosana y Martinez Ernesto "},
                {"comunicaciones","Bracalenti Tomas y Filippa Gabriel"},
                {"redes","Romaniz Susana y Chevalier Alicia"},
                {"gestion de datos","Vechietti Aldo y Golobisky Fernanda"}};
        arregloProfesoresDictado=arreglo;
    }
    public static String getProfesoresDictado(String materia){
        for(String[] parMateriaProfesores: arregloProfesoresDictado){
            if(parMateriaProfesores[0].equals(materia))
                return parMateriaProfesores[1];
        }
        return "profesores no encontrados";
    }
}

