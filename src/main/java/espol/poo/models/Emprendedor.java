package espol.poo.models;

public class Emprendedor extends Persona {
  private String descripcionServicios;

  public Emprendedor(String ruc, String nombre, String telefono, String email, String direccion, String sitioWeb,
      String personaResponsable, String descripcionServicios) {
    super(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable);
    this.descripcionServicios = descripcionServicios;
  }

  public String toString() {
    return super.toString() + descripcionServicios + "\n";
  }

  public String getDescripcionServicios() {
    return this.descripcionServicios;
  }

  public void setDescripcionServicios(String descripcion) {
    this.descripcionServicios = descripcion;
  }

}