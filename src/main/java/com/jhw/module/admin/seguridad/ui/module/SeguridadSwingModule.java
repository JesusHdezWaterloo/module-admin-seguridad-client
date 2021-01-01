package com.jhw.module.admin.seguridad.ui.module;

import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.admin.seguridad.consume.module.SeguridadConsumeCoreModule;
import com.jhw.module.admin.seguridad.service.ResourceServiceClientImplementation;
import com.jhw.module.admin.seguridad.service.ResourceServiceImplementation;
import com.jhw.module.admin.seguridad.consume.usecase_def.*;
import com.jhw.module.admin.seguridad.ui.UsuariosMainPanel;
import com.jhw.module.admin.seguridad.ui.rol.RolDetailView;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

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
