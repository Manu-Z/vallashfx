package co.edu.uniquindio.vallashfx.vallashapp.Model;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;

import java.util.ArrayList;

public class SalonVallash {

    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Tratamiento> listaTratamientos = new ArrayList<>();
    ArrayList<Tecnico> listaTecnicos = new ArrayList<>();
    ArrayList<Cita> listaCitas = new ArrayList<>();

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Tratamiento> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(ArrayList<Tratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }


}
