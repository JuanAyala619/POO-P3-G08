package espol.poo.models;

import java.util.ArrayList;

public abstract class Persona {
    private String ruc;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private String sitioWeb;
    private String personaResponsable;


    // Constructor con todos los parámetros menos redesSociales
    public Persona(String ruc, String nombre, String telefono, String email,
            String direccion, String sitioWeb, String personaResponsable) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.sitioWeb = sitioWeb;
        this.personaResponsable = personaResponsable;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nRuc/Cedula: " + ruc +
                "\nTelefono: " + telefono +
                "\nEmail: " + email +
                "\nDireccion: " + direccion +
                "\nSitioWeb: " + sitioWeb +
                "\nPersonaResponsable: " + personaResponsable;
    }

    // Getter y Setter para 'ruc'
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'telefono'
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getter y Setter para 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para 'direccion'
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y Setter para 'sitioWeb'
    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    // Getter y Setter para 'personaResponsable'
    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }
}
