package dao;

import model.Turno;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {

    // Simula datos en memoria hasta que exista BD
    private static List<Turno> listaTurnos = new ArrayList<>();

    public void insertar(Turno turno) {
        listaTurnos.add(turno);
    }

    public void eliminar(int id) {
        // cuando tengan BD, se cambia
        if (id >= 0 && id < listaTurnos.size()) {
            listaTurnos.remove(id);
        }
    }

    public List<Turno> obtenerTodos() {
        return listaTurnos;
    }
}