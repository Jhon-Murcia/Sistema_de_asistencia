package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;

    public Departamento() {
        nombre = "Departamento sin nombre";
        estudiantes = new ArrayList<>();
        asignaturas = new ArrayList<>();
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
        estudiantes = new ArrayList<>();
        asignaturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean adicionarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    public Estudiante consultarEstudiante(String tipo, String documento) {
        for (Estudiante e : estudiantes) {
            if (e.getTipo().equalsIgnoreCase(tipo) && e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

    public boolean modificarEstudiante(String tipoActual, String docActual, String nuevoNombre, String nuevoTipo) {
        Estudiante estudiante = consultarEstudiante(tipoActual, docActual);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            Estudiante nuevo = new Estudiante(nuevoNombre, nuevoTipo, docActual);
            estudiantes.add(nuevo);
            return true;
        }
        return false;
    }

    public boolean adicionarAsignatura(String nombre, String codigo, String seccion, String semestre, int creditos) {
        Asignatura a = new Asignatura(nombre, codigo, seccion, semestre, creditos);
        if (!asignaturas.contains(a)) {
            asignaturas.add(a);
            return true;
        }
        return false;
    }

    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equals(codigo) &&
                    a.getSeccion().equals(seccion) &&
                    a.getSemestre().equals(semestre)) {
                return a;
            }
        }
        return null;
    }

    public boolean modificarAsignatura(String codigo, String seccion, String semestre, String nuevoNombre, int nuevosCreditos) {
        Asignatura a = consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            asignaturas.remove(a);
            Asignatura nueva = new Asignatura(nuevoNombre, codigo, seccion, semestre, nuevosCreditos);
            asignaturas.add(nueva);
            return true;
        }
        return false;
    }

    public boolean inscribirEstudianteAsignatura(String tipo, String doc, String codigo, String seccion, String semestre) {
        Estudiante estudiante = consultarEstudiante(tipo, doc);
        if (estudiante != null) {
            Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
            if (asignatura != null) {
                boolean inscrito = asignatura.adicionarEstudiante(estudiante);
                if (inscrito) {
                    return true;
                } else {
                    System.out.println("El estudiante ya está inscrito en la asignatura.");
                    return false;
                }
            } else {
                System.out.println("La asignatura no existe.");
                return false;
            }
        } else {
            System.out.println("El estudiante no está registrado en el departamento.");
            return false;
        }
    }

    public ArrayList<Estudiante> consultarEstudiantesAsignatura(String codigo, String seccion, String semestre) {
        Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
        if (asignatura != null) {
            return asignatura.getEstudiantes();
        }
        return new ArrayList<>();
    }

    public boolean crearListaAsistenciaVacia(String codigo, String seccion, String semestre, String fecha, String hIni, String hFin) {
        Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
        if (asignatura != null) {
            return asignatura.adicionarAsistencia(fecha, hIni, hFin, asignatura.getEstudiantes());
        }
        return false;
    }

    public boolean llenarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora, String documento, int nuevoEstado) {
        Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
        if (asignatura != null) {
            for (Asistencia asistencia : asignatura.getAsistencias()) {
                if (asistencia.getFecha().equals(fecha) && asistencia.getHorainicial().equals(hora)) {
                    return asistencia.modificarAsistencia(documento, nuevoEstado);
                }
            }
        }
        return false;
    }

    public boolean modificarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora, String documento, int nuevoEstado) {
        return llenarAsistencia(codigo, seccion, semestre, fecha, hora, documento, nuevoEstado);
    }

    public ArrayList<Asistencia.Registro> listarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora) {
        Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
        if (asignatura != null) {
            for (Asistencia asistencia : asignatura.getAsistencias()) {
                if (asistencia.getFecha().equals(fecha) && asistencia.getHorainicial().equals(hora)) {
                    return asistencia.getRegistros();
                }
            }
        }
        return new ArrayList<>();
    }
}