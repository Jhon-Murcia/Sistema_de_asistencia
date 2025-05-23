package Modelo;

import java.util.ArrayList;

public class Asistencia {

    private String fecha;
    private String horainicial;
    private String horafinal;
    private ArrayList<Registro> registros = new ArrayList<>();

    public Asistencia(String fecha, String horainicial, String horafinal) {
        this.fecha = fecha;
        this.horainicial = horainicial;
        this.horafinal = horafinal;
    }

    public void adicionarAsistencia(Estudiante estudiante, int estado) {
        registros.add(new Registro(estudiante, estado));
    }

    public String consultarAsistencia(String documento) {
        for (Registro r : registros) {
            if (r.estudiante.getDocumento().equalsIgnoreCase(documento)) {
                return String.valueOf(r.estado);
            }
        }
        return null;
    }

    public boolean modificarAsistencia(String documento, int nuevoEstado) {
        for (Registro r : registros) {
            if (r.estudiante.getDocumento().equalsIgnoreCase(documento)) {
                r.estado = nuevoEstado;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHorainicial() {
        return horainicial;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public static class Registro {
        Estudiante estudiante;
        int estado;

        public Registro(Estudiante estudiante, int estado) {
            this.estudiante = estudiante;
            this.estado = estado;
        }

        public Estudiante getEstudiante() {
            return estudiante;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }
    }

    public Registro obtenerRegistro(String documento) {
        for (Registro registro : registros) {
            if (registro.getEstudiante().getDocumento().equalsIgnoreCase(documento)) {
                return registro;
            }
        }
        return null;
    }
}