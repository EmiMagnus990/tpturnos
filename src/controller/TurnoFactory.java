package controller;

import model.Turno;
import model.Paciente;
import model.Medico;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoFactory {

    public static Turno crear(String tipo, Paciente p, Medico m, LocalDate fecha, LocalTime hora) {
        return new Turno(tipo, p, m, fecha, hora);
    }

}