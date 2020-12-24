package com.jhw.module.admin.seguridad.ui.usuario;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.ui.module.SeguridadModuleNavigator;
import com.jhw.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class UsuarioDetailView extends _MaterialPanelDetail<UsuarioDomain> {

    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_EMAIL = "E-Mail";
    private static final String COL_ROL = "Rol";

    public UsuarioDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_EMAIL).build(),
                Column.builder().name(COL_ROL).build()
        );

        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();

        this.setHeaderText("Usuarios");
        this.setIcon(SeguridadModuleNavigator.ICON_USUARIO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(SeguridadSwingModule.usuarioUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(UsuarioDomain obj) {
        return new Object[]{
            obj.getUsername(),
            obj.getEmail(),
            obj.getRolFk()
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, UsuarioInputView.from());
    }

    @Override
    protected UsuarioDomain deleteAction(UsuarioDomain obj) {
        try {
            return SeguridadSwingModule.usuarioUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(UsuarioDomain obj) {
        new DialogModelInput(this, UsuarioInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(UsuarioDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
}
