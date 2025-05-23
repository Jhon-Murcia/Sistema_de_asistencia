package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ElControlador {
    private static ElControlador instancia;
    private Departamento departamento;


    private ElControlador() {
    }


    public static ElControlador getInstancia() {
        if (instancia == null) {
            instancia = new ElControlador();
        }
        return instancia;
    }

    public void crearDepartamento(String nombre) {
        this.departamento = new Departamento(nombre);
    }

    public String consultarNombreDepartamento() {
        if (departamento != null) {
            return departamento.getNombre();
        }
        return "No hay un departamento registrado.";
    }

    public void modificarNombreDepartamento(String nuevoNombre) {
        if (departamento != null) {
            departamento.setNombre(nuevoNombre);
        }
    }

    public void registrarEstudiante(String nombre, String tipo, String doc) {
        if (departamento != null) {
            Estudiante e = new Estudiante(nombre, tipo, doc);
            departamento.adicionarEstudiante(e);
        }
    }

    public Estudiante consultarEstudiante(String tipo, String doc) {
        if (departamento != null) {
            return departamento.consultarEstudiante(tipo, doc);
        }
        return null;
    }

    public boolean modificarEstudiante(String tipoActual, String docActual, String nuevoNombre, String nuevoTipo) {
        if (departamento != null) {
            return departamento.modificarEstudiante(tipoActual, docActual, nuevoNombre, nuevoTipo);
        }
        return false;
    }

    public void agregarAsignatura(String nombre, String codigo, String seccion, String semestre, int creditos) {
        if (departamento != null) {
            departamento.adicionarAsignatura(nombre, codigo, seccion, semestre, creditos);
        }
    }

    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        if (departamento != null) {
            return departamento.consultarAsignatura(codigo, seccion, semestre);
        }
        return null;
    }

    public boolean modificarAsignatura(String codigo, String seccion, String semestre, String nuevoNombre, int nuevosCreditos) {
        if (departamento != null) {
            return departamento.modificarAsignatura(codigo, seccion, semestre, nuevoNombre, nuevosCreditos);
        }
        return false;
    }

    public boolean registrarEstudianteEnAsignatura(String tipo, String doc, String codigo, String seccion, String semestre) {
        if (departamento != null) {
            return departamento.inscribirEstudianteAsignatura(tipo, doc, codigo, seccion, semestre);
        }
        return false;
    }

    public ArrayList<Estudiante> consultarEstudiantesEnAsignatura(String codigo, String seccion, String semestre) {
        if (departamento != null) {
            return departamento.consultarEstudiantesAsignatura(codigo, seccion, semestre);
        }
        return new ArrayList<>();
    }

    public boolean crearListaAsistenciaVacia(String codigo, String seccion, String semestre, String fecha, String hIni, String hFin) {
        if (departamento != null) {
            return departamento.crearListaAsistenciaVacia(codigo, seccion, semestre, fecha, hIni, hFin);
        }
        return false;
    }


    public boolean modificarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora, String documento, int nuevoEstado) {
        if (departamento != null) {
            return departamento.modificarAsistencia(codigo, seccion, semestre, fecha, hora, documento, nuevoEstado);
        }
        return false;
    }

    public ArrayList<Asistencia.Registro> listarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora) {
        if (departamento != null) {
            return departamento.listarAsistencia(codigo, seccion, semestre, fecha, hora);
        }
        return new ArrayList<>();
    }

    public boolean llenarAsistencia(String codigo, String seccion, String semestre, String fecha, String hora) {
        if (departamento != null) {
            Asignatura asignatura = departamento.consultarAsignatura(codigo, seccion, semestre);
            if (asignatura != null) {
                Asistencia asistencia = asignatura.obtenerAsistencia(fecha, hora);
                if (asistencia != null) {
                    Scanner scanner = new Scanner(System.in);
                    for (Estudiante estudiante : asignatura.getEstudiantes()) {
                        if (asistencia.obtenerRegistro(estudiante.getDocumento()) == null) {
                            System.out.print(estudiante.getTipo() + " | " + estudiante.getDocumento() + " | " + estudiante.getNombre() + " | ");
                            System.out.print("Estado de asistencia (0=No asistió, 1=Asistió, 2=Asistió tarde): ");
                            int estado = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner
                            asistencia.modificarAsistencia(estudiante.getDocumento(), estado);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

