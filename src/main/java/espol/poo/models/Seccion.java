package espol.poo.models;

import java.util.ArrayList;

public class Seccion {
  private int id;
  private ArrayList<Stand> lstStands;
  private int codigoFeria;

  public Seccion(int id, ArrayList<Stand> lstStands, int codigoFeria) {
    this.id = id;
    this.lstStands = lstStands;
    this.codigoFeria = codigoFeria;
  }

  public Seccion(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public ArrayList<Stand> getLstStands() {
    return this.lstStands;
  }

  public int getCodigoFeria() {
    return this.codigoFeria;
  }

  public String toString() {
    return "Seccion: Id - " + this.id + ", Código Feria - " + this.codigoFeria + ", Lista de Stands - "
        + this.lstStands;
  }

}