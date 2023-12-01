package espol.poo.models;

import java.util.ArrayList;

public class Feria {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String lugar;
    private String fechaInicio;
    private String fechaFin;
    private String horario;
    private ArrayList<AuspicianteEnFeria> auspiciantes;
    private ArrayList<Emprendedor> emprendedores;
    private Seccion[] secciones;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<AuspicianteEnFeria> getAuspiciantes() {
        return auspiciantes;
    }

    public void setAuspiciantes(ArrayList<AuspicianteEnFeria> auspiciantes) {
        this.auspiciantes = auspiciantes;
    }

    public ArrayList<Emprendedor> getEmprendedores() {
        return emprendedores;
    }

    public void setEmprendedores(ArrayList<Emprendedor> emprendedores) {
        this.emprendedores = emprendedores;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public Feria(String nombre, String descripcion, String lugar, String fechaInicio, String fechaFin, String horario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horario = horario;
    }

    public String toString() {
        return "";
    }

    public void asignarAuspiciante(Auspiciante auspiciante, String descripcion, boolean tieneStand) {
        this.auspiciantes.add(new AuspicianteEnFeria(auspiciante, descripcion, tieneStand));
    }

    public String distribucionStands() {
        int i = 1;
        StringBuilder str = new StringBuilder();
        for (Seccion seccion : secciones) {
            str.append("\nSeccion " + i + "\n");
            for (Stand stand : seccion.getLstStands()) {
                String mensaje = stand.getReservado() ? "*" : "";
                str.append("[" + stand.getCodigo() + mensaje + "]");
            }
        }
        return str.toString();
    }

    public String consultarEmprendedores() {
        StringBuilder str = new StringBuilder();
        for (Emprendedor emprendedor : emprendedores) {
            str.append("\n" + emprendedor.toString());
        }
        return str.toString();
    }

    public void reservarStand(Persona persona) {

    }

    public String informacionStand(String codigoStand) {
        for (Seccion seccion : this.secciones) {
            for (Stand stand : seccion.getLstStands()) {
                if (stand.getCodigo().equals(codigoStand)) {
                    return stand.toString();
                }
            }
        }
        return null;
    }

    public static Feria buscarFeria(ArrayList<Feria> ferias, int codigo) {
        for (Feria feria : ferias) {
            if (feria.getCodigo() == codigo) {
                return feria;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Feria other = (Feria) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}
