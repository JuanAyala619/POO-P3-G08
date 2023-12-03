package espol.poo.models;

import java.util.ArrayList;

public class Seccion {
  private int id;
  private ArrayList<Stand> lstStands;

  public Seccion(int id, ArrayList<Stand> lstStands) {
    this.id = id;
    this.lstStands = lstStands;
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

  public String toString() {
    return "Seccion: Id - " + this.id + ", Lista de Stands - "
        + this.lstStands;
  }

}