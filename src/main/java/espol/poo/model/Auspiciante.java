package espol.poo.model;
import java.util.ArrayList;


public class Auspiciante extends Persona{
  private ArrayList<TipoSectores> lstTipoSectores;

  public Auspiciante(String ruc, String nombre, String telefono, String email, String direccion, String sitioWeb, String personaResponsable){
    super(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable);
    this.lstTipoSectores = new ArrayList<TipoSectores>();
  }

  public String toString(){
    return super.toString();
  }

  public ArrayList getLstTipoSectores(){
    return this.lstTipoSectores;
  }
  
  public void agregarSectores(){
      
  }
  
}