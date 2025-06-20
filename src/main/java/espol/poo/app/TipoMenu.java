/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package espol.poo.app;

/**
 *
 * @author TOSHIBA
 */
public enum TipoMenu {
     AUSPICIANTES("1", new MenuAuspiciantes()),
    EMPRENDEDORES("2", new MenuEmprendedores()),
    FERIAS("3", new MenuFerias()),
    STANDS ("4",new MenuStands());

    private final String codigo;
    private final InterfaceMenu menu;

    TipoMenu(String codigo, InterfaceMenu menu) {
        this.codigo = codigo;
        this.menu = menu;
    }

    public String getCodigo() {
        return codigo;
    }

    public InterfaceMenu getMenu() {
        return menu;
    }

    public static TipoMenu desdeCodigo(String codigo) {
        for (TipoMenu tipo : values()) {
            if (tipo.getCodigo().equals(codigo)){ 
                return tipo;
            }
        }
        return null;
    }
}
