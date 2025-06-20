package espol.poo.models;

import java.util.ArrayList;

public class Emprendedor extends Persona implements AsignadaAStand {
  private String descripcionServicios;
  private ArrayList<RedSocial> redesSociales;
  public Emprendedor(String ruc, String nombre, String telefono, String email, String direccion, String sitioWeb,
      String personaResponsable, String descripcionServicios) {
    super(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable);
    this.descripcionServicios = descripcionServicios;
    redesSociales = new ArrayList<RedSocial>();
  }
  @Override
  public String getNombre(){
        return super.getNombre();
    }
    public void agregarRedSocial(String tipo, String usuario, String enlace) {
        TipoRedSocial red = TipoRedSocial.Twitter;
        if (tipo.equals("Twitter")) {
            red = TipoRedSocial.Twitter;
        } else if (tipo.equals("Facebook")) {
            red = TipoRedSocial.Facebook;
        } else if (tipo.equals("Instagram")) {
            red = TipoRedSocial.Instagram;
        } else if (tipo.equals("Youtube")) {
            red = TipoRedSocial.Youtube;
        } else if (tipo.equals("TikTok")) {
            red = TipoRedSocial.TikTok;
        } else if (tipo.equals("LinkedIn")) {
            red = TipoRedSocial.LinkedIn;
        } else if (tipo.equals("Pinterest")) {
            red = TipoRedSocial.Pinterest;
        } else {
        }
        redesSociales.add(new RedSocial(red, usuario, enlace));
    }
  public String toString() {
    return super.toString() +"\nRedes Sociales: " + redesSociales 
            +"\nDescripcion: " + descripcionServicios;
    
  }

  public String getDescripcionServicios() {
    return this.descripcionServicios;
  }

  public void setDescripcionServicios(String descripcion) {
    this.descripcionServicios = descripcion;
  }
      // Getter y Setter para 'redesSociales'
    public ArrayList<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(ArrayList<RedSocial> redesSociales) {
        this.redesSociales = redesSociales;
    }
}