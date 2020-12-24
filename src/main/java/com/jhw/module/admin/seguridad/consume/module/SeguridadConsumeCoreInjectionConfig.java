package com.jhw.module.admin.seguridad.consume.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.consume.usecase_def.*;
import com.jhw.module.admin.seguridad.consume.usecase_impl.*;
import com.jhw.module.admin.seguridad.core.usecase_def.*;

/**
 * Configuracion del injection del modulo de Seguridad-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadConsumeCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(RolUseCase.class).to(RolUseCaseImpl.class).in(Singleton.class);
        bind(RolUseCaseConsume.class).to(RolUseCaseImpl.class).in(Singleton.class);
        
        bind(UsuarioUseCase.class).to(UsuarioUseCaseImpl.class).in(Singleton.class);
        bind(UsuarioUseCaseConsume.class).to(UsuarioUseCaseImpl.class).in(Singleton.class);
    }

}
