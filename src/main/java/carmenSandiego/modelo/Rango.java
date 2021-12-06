package carmenSandiego.modelo;

public class Rango {
    private String rangoActual;
    private int cantidadDeArrestos;

    public Rango(){
        this.cantidadDeArrestos = 0;
        verificarRango();
    }

    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    public void addArresto(){
        this.cantidadDeArrestos += 1;
        verificarRango();
    }

    public String getRango(){return this.rangoActual;}

    private void verificarRango(){
        if(getCantidadDeArrestos() % 5 == 0)
            aumentarRango(getCantidadDeArrestos() / 5);
    }

    private void aumentarRango(int grado){
        switch(grado){
            case 0:
                this.setRango("Novato");
                break;
            case 1:
                this.setRango("Detective");
                break;
            case 2:
                this.setRango("Investigador");
                break;
            case 4:
                this.setRango("Sargento");
                break;
        }
    }

    private void setRango(String rangoActual){
        this.rangoActual = rangoActual;
    }

    public int getVelocidad(){return 1100;} //Está hardcodeado, hay que cambiarlo
}
