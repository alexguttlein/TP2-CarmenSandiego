package pruebasUnitarias;

import carmenSandiego.modelo.CalculadorTiempoViaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadorTiempoViajeTests {

    CalculadorTiempoViaje calculadorTiempoViaje = new CalculadorTiempoViaje(1100, 45.573279804398034, -73.49124739806629, 23.564780856080713, -101.16072897108585);
    //las primera latitud y longitud son de Montreal y las otras son de Mexico.
    //las horas de viaje se redondean para abajo

    @Test
    public void obtengoLaDistanciaEntreLasCoordenadas(){
        double distanciaObtenida = calculadorTiempoViaje.obtenerDistancia();

        assertEquals(3466,distanciaObtenida,100);
    }

    @Test
    public void obtengoLaCantidadDeHorasQueLlevaViajarDesdeMontrealAMexico(){
        int horasDeViaje = calculadorTiempoViaje.obtenerHorasDeViaje();

        assertEquals(3, horasDeViaje);
    }

}
