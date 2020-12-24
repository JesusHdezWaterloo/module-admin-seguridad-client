package com.jhw.module.admin.seguridad.ui.rol;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.*;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.swing.prepared.textfield.MaterialPreparedTextFactory;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class RolInputView extends CleanCRUDInputView<RolDomain> {

    public static RolInputView from() {
        return new RolInputView(null);
    }

    public static RolInputView fromModel(RolDomain model) {
        return new RolInputView(model);
    }

    private RolInputView(RolDomain model) {
        super(model, SeguridadSwingModule.rolUC, RolDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Rol", "Editar Rol");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre del rol");
        textFieldNombre.setLabel("Rol");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldNivelAcceso = MaterialPreparedTextFactory.buildIntegerIcon();
        textFieldNivelAcceso.setHint("Nivel de acceso del rol");
        textFieldNivelAcceso.setLabel("Nivel de acceso");

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldNivelAcceso);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldNivelAcceso;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreRol", textFieldNombre);
        map.put("nivelAcceso", textFieldNivelAcceso);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
