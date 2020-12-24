package com.jhw.module.admin.seguridad.ui.rol;

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
public class RolDetailView extends _MaterialPanelDetail<RolDomain> {

    private static final String COL_NOMBRE = "Nombre";

    public RolDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build()
        );

        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();

        this.setHeaderText("Roles");
        this.setIcon(SeguridadModuleNavigator.ICON_ROL);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(SeguridadSwingModule.rolUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(RolDomain obj) {
        return new Object[]{
            obj.getNombreRol()
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, RolInputView.from());
    }

    @Override
    protected RolDomain deleteAction(RolDomain obj) {
        try {
            return SeguridadSwingModule.rolUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(RolDomain obj) {
        new DialogModelInput(this, RolInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(RolDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
}
