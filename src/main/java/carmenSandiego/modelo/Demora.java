package carmenSandiego.modelo;

public class Demora implements ComportamientoDeDemora{
    private int demora;

    public void calcularDemora(int vecesVisitado){

        switch (vecesVisitado){
            case 1:
                this.demora = 1;
                break;
            case 2:
                this.demora = 2;
                break;
            default:
                this.demora = 3;
                break;
        }
    }

    public int getDemora(int vecesVisitados){
        this.calcularDemora(vecesVisitados);
        return demora;
    }
}
