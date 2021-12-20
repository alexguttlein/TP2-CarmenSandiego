package carmenSandiego.modelo.edificio.comportamiento.demora;

public class Demora implements ComportamientoDeDemora {

    public int calcularDemora(int vecesVisitado){
        int demora;
        switch (vecesVisitado){
            case 1:
                demora = 1;
                break;
            case 2:
                demora = 2;
                break;
            default:
                demora = 3;
                break;
        }
        return demora;
    }
}
