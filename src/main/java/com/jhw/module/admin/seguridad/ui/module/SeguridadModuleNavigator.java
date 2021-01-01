package com.jhw.module.admin.seguridad.ui.module;

import com.root101.clean.core.app.services.NavigationService;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.derivable_icons.DerivableIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadModuleNavigator implements NavigationService {

    public static final String GROUP = "modulos.seguridad";

    public static final String SEGURIDAD = "Seguridad";
    public static final String ROL = "Rol";
    public static final String USUARIO = "Usuarios";

    public static final DerivableIcon ICON_SEGURIDAD = MaterialIcons.SECURITY;
    public static final DerivableIcon ICON_ROL = MaterialIcons.WORK;
    public static final DerivableIcon ICON_USUARIO = MaterialIcons.PEOPLE;

    public static final String NAV_ROL = GROUP + ".rol";
    public static final String NAV_USUARIO = GROUP + ".usuario";

    @Override
    public void navigateTo(String string, Object... os) {
    }

}
