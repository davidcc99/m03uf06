/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_m03uf6;

import java.sql.Date;

/**
 *
 * @author davidcc99
 */
public class Event {

    private int id;
    private String nom;
    private String descripcio;
    private Date data_event;
    private boolean system;

    public Event(String nom, String descripcio, Date fechaNacimiento, boolean system) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.data_event = fechaNacimiento;
        this.system = system;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getData_event() {
        return data_event;
    }

    public void setData_event(Date data_event) {
        this.data_event = data_event;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", data_event=" + data_event + ", system=" + system + '}';
    }

}
