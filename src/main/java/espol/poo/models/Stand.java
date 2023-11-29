package espol.poo.models;

public class Stand{
  private int id;
  private String codigo;
  private int idSeccion;
  private String fechaAsignacion;
  private Persona personaAsignada;
  private boolean reservado;
  

  public Stand(int id, String codigo, int idSeccion, String fechaAsignacion, Persona personaAsignada, boolean reservado){
    this.id = id;
    this.codigo = codigo;
    this.idSeccion = idSeccion;
    this.fechaAsignacion = fechaAsignacion;
    this.personaAsignada = personaAsignada;
    this.reservado = reservado;
  }

  public int getId(){
    return this.id;
  }

  public String getCodigo(){
    return this.codigo;
  }

  public int getIdSeccion(){
    return this.idSeccion;
  }

  public String getFechaAsignacion(){
    return this.fechaAsignacion;
  }

  public Persona getPersonaAsignada(){
    return this.personaAsignada;
  }

  public boolean getReservado(){
    return this.reservado;
  }

  public String toString(){
    return "Stand: Id - " + this.id + ", Codigo - " + this.codigo + ", Id Seccion - " + this.idSeccion + ", Fecha Asignada - " + this.fechaAsignacion + ", Persona Asignada - " + this.personaAsignada + ", Reservado - " + this.reservado;
    
  }
}