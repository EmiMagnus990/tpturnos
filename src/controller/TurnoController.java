package controller;

import dao.TurnoDAO;
import model.Turno;
import model.Medico;
import model.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TurnoController {

    private TurnoDAO turnoDAO;

    public TurnoController() {
        turnoDAO = new TurnoDAO();
    }

    public boolean crearTurno(String tipo, Paciente p, Medico m, LocalDate fecha, LocalTime hora) {
        try {
            Turno turno = new Turno(tipo, p, m, fecha, hora);
            turnoDAO.insertar(turno);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelarTurno(int idTurno) {
        try {
            turnoDAO.eliminar(idTurno);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Turno> listarTurnos() {
        return turnoDAO.obtenerTodos();
    }
}