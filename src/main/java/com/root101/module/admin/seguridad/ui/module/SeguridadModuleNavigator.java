/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.ui.module;

import com.root101.clean.core.app.services.NavigationService;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.derivable_icons.DerivableIcon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
