package Vista;

import Controlador.ElControlador;
import Modelo.Asistencia.Registro;
import Modelo.Estudiante;
import Modelo.Asignatura;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElControlador controlador = ElControlador.getInstancia();
        controlador.crearDepartamento("Departamento de Programación");
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar departamento (solo se muestra el nombre del departamento)");
            System.out.println("2. Modificar nombre de departamento");
            System.out.println("3. Registrar estudiante al departamento");
            System.out.println("4. Consultar estudiante en departamento");
            System.out.println("5. Modificar estudiante en departamento");
            System.out.println("6. Agregar asignatura");
            System.out.println("7. Consultar asignatura");
            System.out.println("8. Modificar asignatura");
            System.out.println("9. Registrar estudiante en asignatura");
            System.out.println("10. Consultar estudiantes en asignatura");
            System.out.println("11. Crear lista de asistencia vacía");
            System.out.println("12. Llenar asistencia");
            System.out.println("13. Modificar asistencia");
            System.out.println("14. Listar asistencia");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                System.out.println("Departamento: " + controlador.consultarNombreDepartamento());
            } else if (opcion == 2) {
                System.out.print("Nuevo nombre de departamento: ");
                String nuevoNombreDepto = sc.nextLine();
                controlador.modificarNombreDepartamento(nuevoNombreDepto);
                System.out.println("Nombre del departamento modificado.");
            } else if (opcion == 3) {
                System.out.print("Nombre: ");
                String nombreEstudiante = sc.nextLine();
                System.out.print("Tipo de documento: ");
                String tipoDocEstudiante = sc.nextLine();
                System.out.print("Número de documento: ");
                String numDocEstudiante = sc.nextLine();
                controlador.registrarEstudiante(nombreEstudiante, tipoDocEstudiante, numDocEstudiante);
                System.out.println("Estudiante registrado.");
            } else if (opcion == 4) {
                System.out.print("Tipo de documento: ");
                String tipoDocConsulta = sc.nextLine();
                System.out.print("Número de documento: ");
                String numDocConsulta = sc.nextLine();
                Estudiante estudianteConsultado = controlador.consultarEstudiante(tipoDocConsulta, numDocConsulta);
                if (estudianteConsultado != null) {
                    System.out.println("Nombre: " + estudianteConsultado.getNombre());
                    System.out.println("Tipo de documento: " + estudianteConsultado.getTipo());
                    System.out.println("Número de documento: " + estudianteConsultado.getDocumento());
                } else {
                    System.out.println("Estudiante no encontrado.");
                }
            } else if (opcion == 5) {
                System.out.print("Tipo de documento actual: ");
                String tipoDocActual = sc.nextLine();
                System.out.print("Número de documento actual: ");
                String numDocActual = sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombreEstudiante = sc.nextLine();
                System.out.print("Nuevo tipo de documento: ");
                String nuevoTipoDocEstudiante = sc.nextLine();
                boolean estudianteModificado = controlador.modificarEstudiante(tipoDocActual, numDocActual, nuevoNombreEstudiante, nuevoTipoDocEstudiante);
                System.out.println(estudianteModificado ? "Estudiante modificado." : "Estudiante no encontrado.");
            } else if (opcion == 6) {
                System.out.print("Nombre asignatura: ");
                String nombreAsignatura = sc.nextLine();
                System.out.print("Código: ");
                String codigoAsignatura = sc.nextLine();
                System.out.print("Sección: ");
                String seccionAsignatura = sc.nextLine();
                System.out.print("Créditos: ");
                int creditosAsignatura = Integer.parseInt(sc.nextLine());
                System.out.print("Semestre: ");
                String semestreAsignatura = sc.nextLine();
                controlador.agregarAsignatura(nombreAsignatura, codigoAsignatura, seccionAsignatura, semestreAsignatura, creditosAsignatura);
                System.out.println("Asignatura agregada.");
            } else if (opcion == 7) {
                System.out.print("Código: ");
                String codigoConsulta = sc.nextLine();
                System.out.print("Sección: ");
                String seccionConsulta = sc.nextLine();
                System.out.print("Semestre: ");
                String semestreConsulta = sc.nextLine();
                Asignatura asignaturaConsultada = controlador.consultarAsignatura(codigoConsulta, seccionConsulta, semestreConsulta);
                if (asignaturaConsultada != null) {
                    System.out.println("Nombre: " + asignaturaConsultada.getNombre());
                    System.out.println("Créditos: " + asignaturaConsultada.getCreditos());
                } else {
                    System.out.println("Asignatura no encontrada.");
                }
            } else if (opcion == 8) {
                System.out.print("Código: ");
                String codigoModificar = sc.nextLine();
                System.out.print("Sección: ");
                String seccionModificar = sc.nextLine();
                System.out.print("Semestre: ");
                String semestreModificar = sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombreAsignatura = sc.nextLine();
                System.out.print("Nuevos créditos: ");
                int nuevosCreditosAsignatura = Integer.parseInt(sc.nextLine());
                boolean asignaturaModificada = controlador.modificarAsignatura(codigoModificar, seccionModificar, semestreModificar, nuevoNombreAsignatura, nuevosCreditosAsignatura);
                System.out.println(asignaturaModificada ? "Asignatura modificada." : "Asignatura no encontrada.");
            } else if (opcion == 9) {
                System.out.print("Tipo de documento del estudiante: ");
                String tipoDocInscripcion = sc.nextLine();
                System.out.print("Número de documento del estudiante: ");
                String numDocInscripcion = sc.nextLine();
                System.out.print("Código de asignatura: ");
                String codigoInscripcion = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionInscripcion = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreInscripcion = sc.nextLine();
                boolean inscripcionExitosa = controlador.registrarEstudianteEnAsignatura(tipoDocInscripcion, numDocInscripcion, codigoInscripcion, seccionInscripcion, semestreInscripcion);
                System.out.println(inscripcionExitosa ? "Estudiante inscrito en asignatura." : "Error en inscripción.");
            } else if (opcion == 10) {
                System.out.print("Código de asignatura: ");
                String codigoEstudiantesAsignatura = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionEstudiantesAsignatura = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreEstudiantesAsignatura = sc.nextLine();
                ArrayList<Estudiante> estudiantesAsignatura = controlador.consultarEstudiantesEnAsignatura(codigoEstudiantesAsignatura, seccionEstudiantesAsignatura, semestreEstudiantesAsignatura);
                if (estudiantesAsignatura.isEmpty()) {
                    System.out.println("No hay estudiantes registrados en la asignatura.");
                } else {
                    for (Estudiante estudiante : estudiantesAsignatura) {
                        System.out.println("Tipo de documento: " + estudiante.getTipo() + ", Número de documento: " + estudiante.getDocumento());
                    }
                }
            } else if (opcion == 11) {
                System.out.print("Código de asignatura: ");
                String codigoListaAsistencia = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionListaAsistencia = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreListaAsistencia = sc.nextLine();
                System.out.print("Fecha: ");
                String fechaListaAsistencia = sc.nextLine();
                System.out.print("Hora inicial: ");
                String horaInicioListaAsistencia = sc.nextLine();
                System.out.print("Hora final: ");
                String horaFinListaAsistencia = sc.nextLine();
                boolean listaAsistenciaCreada = controlador.crearListaAsistenciaVacia(codigoListaAsistencia, seccionListaAsistencia, semestreListaAsistencia, fechaListaAsistencia, horaInicioListaAsistencia, horaFinListaAsistencia);
                System.out.println(listaAsistenciaCreada ? "Lista de asistencia creada." : "Error al crear lista de asistencia.");
            } else if (opcion == 12) {
                System.out.print("Código de asignatura: ");
                String codigoLlenarAsistencia = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionLlenarAsistencia = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreLlenarAsistencia = sc.nextLine();
                System.out.print("Fecha: ");
                String fechaLlenarAsistencia = sc.nextLine();
                System.out.print("Hora: ");
                String horaLlenarAsistencia = sc.nextLine();
                boolean asistenciaLlenada = controlador.llenarAsistencia(codigoLlenarAsistencia, seccionLlenarAsistencia, semestreLlenarAsistencia, fechaLlenarAsistencia, horaLlenarAsistencia);
                System.out.println(asistenciaLlenada ? "Asistencia registrada." : "Error al registrar asistencia.");


            } else if (opcion == 13) {
                System.out.print("Código de asignatura: ");
                String codigoModificarAsistencia = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionModificarAsistencia = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreModificarAsistencia = sc.nextLine();
                System.out.print("Fecha: ");
                String fechaModificarAsistencia = sc.nextLine();
                System.out.print("Hora: ");
                String horaModificarAsistencia = sc.nextLine();
                System.out.print("Número de documento del estudiante: ");
                String numDocModificarAsistencia = sc.nextLine();
                System.out.print("Nuevo estado de asistencia (0=No asistió, 1=Asistió, 2=Asistió tarde): ");
                int nuevoEstadoModificarAsistencia = Integer.parseInt(sc.nextLine());
                boolean asistenciaModificada = controlador.modificarAsistencia(codigoModificarAsistencia, seccionModificarAsistencia, semestreModificarAsistencia, fechaModificarAsistencia, horaModificarAsistencia, numDocModificarAsistencia, nuevoEstadoModificarAsistencia);
                System.out.println(asistenciaModificada ? "Asistencia modificada." : "Error al modificar asistencia.");
            } else if (opcion == 14) {
                System.out.print("Código de asignatura: ");
                String codigoListarAsistencia = sc.nextLine();
                System.out.print("Sección de asignatura: ");
                String seccionListarAsistencia = sc.nextLine();
                System.out.print("Semestre de asignatura: ");
                String semestreListarAsistencia = sc.nextLine();
                System.out.print("Fecha: ");
                String fechaListarAsistencia = sc.nextLine();
                System.out.print("Hora: ");
                String horaListarAsistencia = sc.nextLine();
                ArrayList<Registro> listaAsistencia = controlador.listarAsistencia(codigoListarAsistencia, seccionListarAsistencia, semestreListarAsistencia, fechaListarAsistencia, horaListarAsistencia);
                if (listaAsistencia.isEmpty()) {
                    System.out.println("No hay registros de asistencia.");
                } else {
                    for (Registro registro : listaAsistencia) {
                        System.out.println("Tipo de documento: " + registro.getEstudiante().getTipo() + ", Número de documento: " + registro.getEstudiante().getDocumento() + ", Nombre: " + registro.getEstudiante().getNombre() + ", Estado: " + registro.getEstado());
                    }
                }
            } else if (opcion == 15) {
                salir = true;
                System.out.println("¡Hasta luego!");
            } else {
                System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}
