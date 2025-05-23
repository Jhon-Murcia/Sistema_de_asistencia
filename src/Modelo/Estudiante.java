package Modelo;

public class Estudiante {
    private String nombre;
    private String tipoDocumento;
    private String documento;

    public Estudiante(String nombre, String tipoDocumento, String documento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Estudiante) {
            Estudiante otro = (Estudiante) obj;
            return this.tipoDocumento.equals(otro.getTipo()) &&
                    this.documento.equals(otro.getDocumento());
        }
        return false;
    }
}

