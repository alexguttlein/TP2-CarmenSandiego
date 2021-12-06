package carmenSandiego.modelo;

public class CalculadorTiempoViaje {
    private int velocidad;
    private double latitudSalida;
    private double longitudSalida;
    private double latitudDestino;
    private double longitudDestino;

    public CalculadorTiempoViaje(int velocidad, double latitudSalida, double longitudSalida, double latitudDestino, double longitudDestino){
        this.velocidad = velocidad;
        this.latitudSalida = latitudSalida;
        this.longitudSalida = longitudSalida;
        this.latitudDestino = latitudDestino;
        this.longitudDestino = longitudDestino;
    }


    private double obtenerDistancia() {
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(latitudDestino - latitudSalida);
        double dLng = Math.toRadians(longitudDestino - longitudSalida);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(latitudSalida)) * Math.cos(Math.toRadians(latitudDestino));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
    }

    public void hacerViaje() {
        Reloj reloj = Reloj.getInstance();
        int horasDeViaje = (int)(obtenerDistancia() / velocidad);
        reloj.agregarHoras(horasDeViaje);
    }
}
