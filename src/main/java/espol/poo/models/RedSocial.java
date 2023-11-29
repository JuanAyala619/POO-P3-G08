package espol.poo.models;


public class RedSocial {
    private TipoRedSocial tipo;
    private String usuario;
    private String enlace;
    
    //Constructor con todos los parametros
    public RedSocial(TipoRedSocial tipo, String usuario, String enlace) {
        this.tipo = tipo;
        this.usuario = usuario;
        this.enlace = enlace;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return tipo.toString();
    }
    
    // Getter y Setter para 'tipo'
    public TipoRedSocial getTipo() {
        return tipo;
    }

    public void setTipo(TipoRedSocial tipo) {
        this.tipo = tipo;
    }

    // Getter y Setter para 'usuario'
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para 'enlace'
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
 
}
