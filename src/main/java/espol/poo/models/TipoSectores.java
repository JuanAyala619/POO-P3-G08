package espol.poo.models;

public enum TipoSectores {
    ALIMENTACION,
    EDUCACION,
    SALUD,
    VESTIMENTA;

    // Método toString
    @Override
    public String toString() {
        switch (this) {
            case ALIMENTACION:
                return "Alimentación";
            case EDUCACION:
                return "Educación";
            case SALUD:
                return "Salud";
            case VESTIMENTA:
                return "Vestimenta";
            default:
                return "NULL";
        }
    }
}
