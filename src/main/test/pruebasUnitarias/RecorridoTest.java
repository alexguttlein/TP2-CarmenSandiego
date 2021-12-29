package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.ObjetoRobado;
import edu.fiuba.algo3.modelo.Recorrido;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class RecorridoTest {

    ArrayList pistasCiudadBuenosAires = new ArrayList(Arrays.asList("Buenos Aires","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "-34.58952254327074", "-58.34678308238882"));

    Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");

    @Test
    public void seCreaUnRecorridoCon4CiudadesPrincipales(){  //Objeto robado comun
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Comun"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        assertEquals(4, unRecorrido.getRecorridoReal().size());
    }

    @Test
    public void seCreaUnRecorridoCon5CiudadesPrincipales(){  //Objeto robado importante
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        assertEquals(5, unRecorrido.getRecorridoReal().size());
    }

    @Test
    public void seCreaUnRecorridoCon7CiudadesPrincipales(){  //Objeto robado muy importante
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Muy importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        assertEquals(7, unRecorrido.getRecorridoReal().size());
    }

    @Test
    public void cadaCiudadTieneLaCantidadDeCiudadesSecundariasCorrectasCon4Principales(){
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Comun"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        Ciudad ciudad1 = unRecorrido.getRecorridoReal().get(0);
        Ciudad ciudad2 = unRecorrido.getRecorridoReal().get(1);
        Ciudad ciudad3 = unRecorrido.getRecorridoReal().get(2);
        Ciudad ciudad4 = unRecorrido.getRecorridoReal().get(3);

        assertEquals(2, ciudad1.getCiudadesSecundarias().size());
        assertEquals(2, ciudad2.getCiudadesSecundarias().size());
        assertEquals(2, ciudad3.getCiudadesSecundarias().size());
        assertEquals(2, ciudad4.getCiudadesSecundarias().size());
    }

    @Test
    public void cadaCiudadTieneLaCantidadDeCiudadesSecundariasCorrectasCon5Principales(){
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        Ciudad ciudad1 = unRecorrido.getRecorridoReal().get(0);
        Ciudad ciudad2 = unRecorrido.getRecorridoReal().get(1);
        Ciudad ciudad3 = unRecorrido.getRecorridoReal().get(2);
        Ciudad ciudad4 = unRecorrido.getRecorridoReal().get(3);
        Ciudad ciudad5 = unRecorrido.getRecorridoReal().get(4);

        assertEquals(2, ciudad1.getCiudadesSecundarias().size());
        assertEquals(2, ciudad2.getCiudadesSecundarias().size());
        assertEquals(2, ciudad3.getCiudadesSecundarias().size());
        assertEquals(2, ciudad4.getCiudadesSecundarias().size());
        assertEquals(2, ciudad5.getCiudadesSecundarias().size());
    }

    @Test
    public void cadaCiudadTieneLaCantidadDeCiudadesSecundariasCorrectasCon7Principales(){
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Muy importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        Ciudad ciudad1 = unRecorrido.getRecorridoReal().get(0);
        Ciudad ciudad2 = unRecorrido.getRecorridoReal().get(1);
        Ciudad ciudad3 = unRecorrido.getRecorridoReal().get(2);
        Ciudad ciudad4 = unRecorrido.getRecorridoReal().get(3);
        Ciudad ciudad5 = unRecorrido.getRecorridoReal().get(4);
        Ciudad ciudad6 = unRecorrido.getRecorridoReal().get(5);
        Ciudad ciudad7 = unRecorrido.getRecorridoReal().get(6);

        assertEquals(2, ciudad1.getCiudadesSecundarias().size());
        assertEquals(2, ciudad2.getCiudadesSecundarias().size());
        assertEquals(2, ciudad3.getCiudadesSecundarias().size());
        assertEquals(2, ciudad4.getCiudadesSecundarias().size());
        assertEquals(2, ciudad5.getCiudadesSecundarias().size());
        assertEquals(2, ciudad6.getCiudadesSecundarias().size());
        assertEquals(2, ciudad7.getCiudadesSecundarias().size());
    }

    @Test
    public void ladronPasaPorTodasLasCiudadesPrincipales() {
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Muy importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        Ciudad ciudad1 = unRecorrido.getRecorridoReal().get(0);
        Ciudad ciudad2 = unRecorrido.getRecorridoReal().get(1);
        Ciudad ciudad3 = unRecorrido.getRecorridoReal().get(2);
        Ciudad ciudad4 = unRecorrido.getRecorridoReal().get(3);
        Ciudad ciudad5 = unRecorrido.getRecorridoReal().get(4);
        Ciudad ciudad6 = unRecorrido.getRecorridoReal().get(5);
        Ciudad ciudad7 = unRecorrido.getRecorridoReal().get(6);

        assertTrue(ciudad1.getPasoLadron());
        assertTrue(ciudad2.getPasoLadron());
        assertTrue(ciudad3.getPasoLadron());
        assertTrue(ciudad4.getPasoLadron());
        assertTrue(ciudad5.getPasoLadron());
        assertTrue(ciudad6.getPasoLadron());
        assertTrue(ciudad7.getPasoLadron());
    }

    @Test
    public void ladronNopasaPorLasCiudadesSecundarias() {
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Muy importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        for (Ciudad actual : unRecorrido.getRecorridoReal()){
            for (Ciudad actualSecundaria : actual.getCiudadesSecundarias()){
                assertFalse(actualSecundaria.getPasoLadron());
                System.out.print(actual.getNombre().getCaracteristica() + ": ");
                System.out.println(actualSecundaria.getNombre().getCaracteristica());
            }
        }
    }

    /*
    @Test
    public void cadaCiudadTieneCiudadesSecundariasDiferentes(){
        Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
        ObjetoRobado unObjetoRobado = new ObjetoRobado(new Caracteristica("Copa Stanley"), ciudadBuenosAires, new Caracteristica("Muy importante"));
        Recorrido unRecorrido = new Recorrido(unObjetoRobado, ciudades);

        Ciudad ciudad1 = unRecorrido.getRecorridoReal().get(0);
        Ciudad ciudad2 = unRecorrido.getRecorridoReal().get(1);
        Ciudad ciudad3 = unRecorrido.getRecorridoReal().get(2);
        Ciudad ciudad4 = unRecorrido.getRecorridoReal().get(3);
        Ciudad ciudad5 = unRecorrido.getRecorridoReal().get(4);
        Ciudad ciudad6 = unRecorrido.getRecorridoReal().get(5);
        Ciudad ciudad7 = unRecorrido.getRecorridoReal().get(6);

        for (int i = 0; i < 7; i++){
            ArrayList<Ciudad> ciudadesSecundarias = unRecorrido.getRecorridoReal().get(i).getCiudadesSecundarias();
            System.out.println("CIUDAD: " + unRecorrido.getRecorridoReal().get(i).getNombre().getCaracteristica());
            for (int j = 0; j < 2; j++){
                System.out.println(ciudadesSecundarias.get(j).getNombre().getCaracteristica());
            }
        }
    }

     */
}
