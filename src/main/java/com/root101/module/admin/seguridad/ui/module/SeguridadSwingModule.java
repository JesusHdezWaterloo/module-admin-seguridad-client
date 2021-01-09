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

import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.module.admin.seguridad.consume.module.SeguridadConsumeCoreModule;
import com.root101.module.admin.seguridad.service.ResourceServiceClientImplementation;
import com.root101.module.admin.seguridad.service.ResourceServiceImplementation;
import com.root101.module.admin.seguridad.ui.UsuariosMainPanel;
import com.root101.swing.material.components.taskpane.CollapseMenu;
import com.root101.module.admin.seguridad.consume.usecase_def.RolUseCaseConsume;
import com.root101.module.admin.seguridad.consume.usecase_def.UsuarioUseCaseConsume;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class SeguridadSwingModule extends DefaultAbstractSwingMainModule {

    private final SeguridadModuleNavigator navigator = new SeguridadModuleNavigator();

    public final static RolUseCaseConsume rolUC;
    public final static UsuarioUseCaseConsume usuarioUC;

    static {
        rolUC = SeguridadConsumeCoreModule.getInstance().getImplementation(RolUseCaseConsume.class);
        usuarioUC = SeguridadConsumeCoreModule.getInstance().getImplementation(UsuarioUseCaseConsume.class);
    }

    private SeguridadSwingModule() {
    }

    public static SeguridadSwingModule init() {
        System.out.println("Iniciando 'Seguridad'");

        ResourceServiceImplementation.init();//inicio el general
        ResourceServiceClientImplementation.init();//inicio el mio

        return new SeguridadSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        CollapseMenu menu = new CollapseMenu(SeguridadModuleNavigator.ICON_SEGURIDAD, SeguridadModuleNavigator.SEGURIDAD);
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);

        /*dash.addView(SeguridadModuleNavigator.NAV_ROL, new RolDetailView());
        menu.addMenuItem(new AbstractAction(SeguridadModuleNavigator.ROL, SeguridadModuleNavigator.ICON_ROL) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(SeguridadModuleNavigator.NAV_ROL);
            }
        });*/
        dash.addView(SeguridadModuleNavigator.NAV_USUARIO, new UsuariosMainPanel());
        menu.addMenuItem(new AbstractAction(SeguridadModuleNavigator.USUARIO, SeguridadModuleNavigator.ICON_USUARIO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(SeguridadModuleNavigator.NAV_USUARIO);
            }
        });
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
