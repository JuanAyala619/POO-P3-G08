/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.poo.models;

import java.time.LocalDate;

/**
 *
 * @author TOSHIBA
 */
public class GestorStandenFeria {
        private Feria feria;
        public GestorStandenFeria(Feria feria) {
        this.feria = feria;
    }

    public void reservarStand(String codigoStand, AsignadaAStand persona, LocalDate date) {
        for (Seccion seccion : feria.getSecciones()) {
            for (Stand stand : seccion.getLstStands()) {
                if (stand.getCodigo().equals(codigoStand)) {
                    stand.setFechaAsignacion(date);
                    stand.setPersonaAsignada(persona);
                    return;
                }
            }
        }
    }

    public void asignarNumeroStands(int st1, int st2, int st3, int st4) {
        String[] letrasCodigo = {"A", "B", "C", "D"};
        int[] numeros = {st1, st2, st3, st4};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < numeros[i]; j++) {
                String codigo = letrasCodigo[i] + (j + 1);
                feria.getSecciones()[i].addStand(codigo);
            }
        }
    }

    public String informacionStand(String codigoStand) {
        for (Seccion seccion : feria.getSecciones()) {
            for (Stand stand : seccion.getLstStands()) {
                if (stand.getCodigo().equals(codigoStand)) {
                    return stand.toString();
                }
            }
        }
        return null;
    }

    public String distribucionStands() {
        StringBuilder str = new StringBuilder();
        for (Seccion seccion : feria.getSecciones()) {
            str.append("\nSeccion ").append(seccion.getId()).append("\n");
            for (Stand stand : seccion.getLstStands()) {
                String mensaje = (stand.getPersonaAsignada() != null) ? "*" : "";
                str.append("[").append(stand.getCodigo()).append(mensaje).append("]");
            }
        }
        return str.toString();
    }
}
