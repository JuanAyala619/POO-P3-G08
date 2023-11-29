package espol.poo.model;
import java.util.ArrayList;
import java.util.Scanner;


public class Auspiciante extends Persona{
  private ArrayList<TipoSectores> lstTipoSectores;

  //Constructor de un objeto Auspiciante
  public Auspiciante(String ruc, String nombre, String telefono, String email, String direccion, String sitioWeb, String personaResponsable){
    super(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable);
    this.lstTipoSectores = new ArrayList<TipoSectores>();
  }

  public String toString(){
    return super.toString() + lstTipoSectores + "\n";
  }

  public ArrayList getLstTipoSectores(){
    return this.lstTipoSectores;
  }
  
  public void agregarSectores(int opcion){
    if(opcion == 1){
        this.lstTipoSectores.add(TipoSectores.ALIMENTACION);
    }else if(opcion == 2){
        this.lstTipoSectores.add(TipoSectores.EDUCACION);
    }else if(opcion == 3){
        this.lstTipoSectores.add(TipoSectores.SALUD);
    }else if(opcion == 4){
        this.lstTipoSectores.add(TipoSectores.VESTIMENTA);
    }
  }
}