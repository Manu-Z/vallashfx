package co.edu.uniquindio.vallashfx.vallashapp.Model;

import java.util.ArrayList;

public class Cliente extends Persona {

    ArrayList<Cita>listaCitasCliente = new ArrayList<>();

    public Cliente() {

    }

    public ArrayList<Cita> getListaCitasCliente() {
        return listaCitasCliente;
    }

    public void setListaCitasCliente(ArrayList<Cita> listaCitasCliente) {
        this.listaCitasCliente = listaCitasCliente;
    }
}
