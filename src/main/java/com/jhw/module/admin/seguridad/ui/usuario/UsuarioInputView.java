package com.jhw.module.admin.seguridad.ui.usuario;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.module.admin.seguridad.ui.rol.RolICBS;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.passwordfield.MaterialPasswordFieldFactory;
import com.jhw.swing.material.components.passwordfield.MaterialPasswordFieldIcon;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.*;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class UsuarioInputView extends CleanCRUDInputView<UsuarioDomain> {

    public static UsuarioInputView from() {
        return new UsuarioInputView(null);
    }

    public static UsuarioInputView fromModel(UsuarioDomain model) {
        return new UsuarioInputView(model);
    }

    private UsuarioInputView(UsuarioDomain model) {
        super(model, SeguridadSwingModule.usuarioUC, UsuarioDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Usuario", "Editar Usuario");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de usuario");
        textFieldNombre.setLabel("Usuario");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldEmail = MaterialTextFactory.buildIcon();
        textFieldEmail.setHint("Email de contacto");
        textFieldEmail.setLabel("Email");
        textFieldEmail.setIcon(MaterialIcons.EMAIL);

        passwordField = MaterialPasswordFieldFactory.buildIcon();
        passwordField.setHint("Contraseña");
        passwordField.setLabel("Contraseña");
        passwordField.setIcon(MaterialIcons.SECURITY);

        passwordFieldCheck = MaterialPasswordFieldFactory.buildIcon();
        passwordFieldCheck.setHint("Confirmación de contraseña");
        passwordFieldCheck.setLabel("Confirmación");
        passwordFieldCheck.setIcon(MaterialIcons.VPN_KEY);

        rolICBS = new RolICBS();

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldEmail);
        vlc.add(passwordField);
        vlc.add(rolICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldEmail;
    private MaterialPasswordFieldIcon passwordField;
    private MaterialPasswordFieldIcon passwordFieldCheck;
    private RolICBS rolICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public void update() {
        super.update();
        passwordField.setObject("");
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("username", textFieldNombre);
        map.put("email", textFieldEmail);
        map.put("password", passwordField);
        map.put("rolFk", rolICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
