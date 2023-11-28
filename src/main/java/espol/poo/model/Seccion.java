package espol.poo.model;
import java.util.ArrayList;

public class Seccion{
  private int id;
  private ArrayList<Stand> lstStands;
  private int codigoFeria;

  public Seccion(int id, ArrayList<Stand> lstStands, int codigoFeria){
    this.id = id;
    this.lstStands = lstStands;
    this.codigoFeria = codigoFeria;
  }

  public int getId(){
    return this.id;
  }

  public ArrayList<Stand> getLstStands(){
    return this.lstStands;
  }

  public int getCodigoFeria(){
    return this.codigoFeria;
  }

  public String toString(){
    return "Seccion: Id - " + this.id + ", Código Feria - " + this.codigoFeria + ", Lista de Stands - " + this.lstStands;
  }

}