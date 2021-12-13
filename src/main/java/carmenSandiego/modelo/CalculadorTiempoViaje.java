package carmenSandiego.modelo;

public class CalculadorTiempoViaje {
    private int velocidad;
    private Ubicacion ubicacionSalida;
    private Ubicacion ubicacionDestino;

    public CalculadorTiempoViaje(int velocidad, Ubicacion ubicacionSalida, Ubicacion ubicacionDestino){
        this.velocidad = velocidad;
        this.ubicacionSalida = ubicacionSalida;
        this.ubicacionDestino = ubicacionDestino;
    }


    public double obtenerDistancia() {
        double latitudSalida = this.ubicacionSalida.getLatitud();
        double longitudSalida = this.ubicacionSalida.getLongitud();
        double latitudDestino = this.ubicacionDestino.getLatitud();
        double longitudDestino = this.ubicacionDestino.getLongitud();

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

    public int obtenerHorasDeViaje() {
        return (int)(obtenerDistancia() / velocidad);
    }
}
