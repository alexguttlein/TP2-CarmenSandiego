package carmenSandiego.modelo;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int vecesHeridoPorCuchillo;
    private EstadoJugador estadoJugador;
    private Tiempo reloj;

    public Jugador(String nombre, Tiempo reloj){
        this.nombre = nombre;
        this.setRango(new RangoNovato(0));
        this.vecesHeridoPorCuchillo = 0;
        this.estadoJugador = new EstadoSano();
        this.setReloj(reloj);
    }

    private void setRango(Rango rango){
        this.rango = rango;
    }

    public Rango getRango(){
        return this.rango;
    }

    public String getNombre(){return this.nombre;}

    public String getNombreRango(){return this.rango.getNombreRango();}

    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}

    public void addArresto(){
        this.rango.addArresto();
        this.rango = rango.verificarRango();
    }

    public Ciudad getCiudadActual(){return this.ciudadActual;}

    public void setCiudadActual(Ciudad ciudadActual){
        this.ciudadActual = ciudadActual;
    }

    public void dormir(){
        setEstadoJugador(new EstadoDormido());
        estadoJugador.pasarTiempo(this.getReloj());
        this.sanar();
    }

    public void serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(getVecesHeridoPorCuchillo() == 1) {
            setEstadoJugador(new EstadoHeridoConCuchillo());
        }
        else {
            setEstadoJugador(new EstadoHeridoConCuchilloMultiplesVeces());
        }
        estadoJugador.pasarTiempo(this.getReloj());
        this.sanar();
    }

    public void serHeridoPorArmaDeFuego(){
        setEstadoJugador(new EstadoHeridoPorArmaDeFuego());
        estadoJugador.pasarTiempo(this.getReloj());
        this.sanar();
    }

    public void sanar(){
        setEstadoJugador(new EstadoSano());
    }

    private void setEstadoJugador(EstadoJugador estado){
        this.estadoJugador = estado;
    }

    public int getVecesHeridoPorCuchillo(){
        return this.vecesHeridoPorCuchillo;
    }

    public void viajar(Ciudad ciudadSiguiente){
        //ciudadActual.viajarDesde(rango.getVelocidad(), ciudadSiguiente); //habría que cambiarle el nombre
        int horasViaje = this.getCiudadActual().viajarHasta(rango.getVelocidad(), ciudadSiguiente);
        this.getReloj().addHoras(horasViaje);
        this.setCiudadActual(ciudadSiguiente);
    }

    private void setReloj(Tiempo reloj){
        this.reloj = reloj;
    }

    private Tiempo getReloj(){
        return this.reloj;
    }

    public void visitarEdificio(Edificio edificio) {
        this.getReloj().addHoras(this.getCiudadActual().visitarEdificio(edificio));
    }
    
}
