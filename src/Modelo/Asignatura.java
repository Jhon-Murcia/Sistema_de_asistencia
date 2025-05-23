package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private String codigo;
    private String seccion;
    private String semestre;
    private int creditos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asistencia> asistencias;

    public Asignatura(String nombre, String codigo, String seccion, String semestre, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.seccion = seccion;
        this.semestre = semestre;
        this.creditos = creditos;
        this.estudiantes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getSemestre() {
        return semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public boolean adicionarEstudiante(Estudiante e) {
        if (!estudiantes.contains(e)) {
            estudiantes.add(e);
            return true;
        }
        return false;
    }

    public boolean adicionarAsistencia(String fecha, String horaInicio, String horaFin, ArrayList<Estudiante> listaEstudiantes) {
        Asistencia asistencia = new Asistencia(fecha, horaInicio, horaFin);
        for (Estudiante e : listaEstudiantes) {
            asistencia.adicionarAsistencia(e, 0);
        }
        asistencias.add(asistencia);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Asignatura) {
            Asignatura a = (Asignatura) obj;
            return codigo.equals(a.getCodigo()) &&
                    seccion.equals(a.getSeccion()) &&
                    semestre.equals(a.getSemestre());
        }
        return false;
    }

    public Asistencia obtenerAsistencia(String fecha, String hora) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getFecha().equals(fecha) && asistencia.getHorainicial().equals(hora)) {
                return asistencia;
            }
        }
        return null;
    }
}