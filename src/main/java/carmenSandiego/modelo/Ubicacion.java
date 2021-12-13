package carmenSandiego.modelo;

public class Ubicacion {
    double latitud;
    double longitud;

    public Ubicacion(double latitud, double longitud) {
        this.setLatitud(latitud);
        this.setLongitud(longitud);
    }

    private void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    private void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLatitud(){return this.latitud;}

    public double getLongitud(){return this.longitud;}
}
