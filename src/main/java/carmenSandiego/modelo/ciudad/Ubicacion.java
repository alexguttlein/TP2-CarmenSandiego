package carmenSandiego.modelo.ciudad;

public class Ubicacion {
    double latitud;
    double longitud;

    public Ubicacion(double latitud, double longitud) {
        this.setLatitud(latitud);
        this.setLongitud(longitud);
    }

    public double getLatitud(){return this.latitud;}
    public double getLongitud(){return this.longitud;}

    public double obtenerDistancia(double latitudDestino, double longitudDestino) {
        double latitudSalida = this.latitud;
        double longitudSalida = this.longitud;

        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(latitudDestino - latitudSalida);
        double dLng = Math.toRadians(longitudDestino - longitudSalida);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(latitudSalida)) * Math.cos(Math.toRadians(latitudDestino));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return Math.floor(distancia);
    }

    public int obtenerHorasDeViaje(Ubicacion ubicacionOrigen, int velocidad){
        return (int) Math.round((ubicacionOrigen.obtenerDistancia(this.latitud, this.longitud)/velocidad));
    }
};
