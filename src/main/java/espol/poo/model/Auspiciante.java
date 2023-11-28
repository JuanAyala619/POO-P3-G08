package espol.poo.model;
import java.util.ArrayList;

public class Auspiciante extends Persona{
  private ArrayList<sectores> lstTipoSectores;
  private ArrayList<descripcionServicios> lstDscServicios;

  public Auspiciante(String ruc, String nombre, String telefono, String email, String direccion, String sitioWeb, String personaResponsable){
    super(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable);
    this.lstTipoSectores = new ArrayList<sectores>();
    this.lstDscServicios = new ArrayList<descripcionServicios>();
  }

  public String toString(){
    return super.toString();
  }

  public Array getLstTipoSectores(){
    return this.lstTipoSectores;
  }

  public Array getLstDscServicios(){
    return this.lstDscServicios;
  }
  
}