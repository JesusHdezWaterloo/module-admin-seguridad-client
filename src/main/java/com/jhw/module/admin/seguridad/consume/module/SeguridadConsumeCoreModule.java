package com.jhw.module.admin.seguridad.consume.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.admin.seguridad.service.ResourceServiceClientImplementation;

/**
 * Modulo de Seguridad-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadConsumeCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new SeguridadConsumeCoreInjectionConfig());

    private static SeguridadConsumeCoreModule INSTANCE;

    public static SeguridadConsumeCoreModule getInstance() {
        if (INSTANCE == null) {
            init();
        }
        return INSTANCE;
    }

    /**
     * Es responsabilidad del init saber que tiene que inicializar
     *
     * @return
     */
    private static void init() {
        INSTANCE = new SeguridadConsumeCoreModule();
        ResourceServiceClientImplementation.init();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Seguridad Consume Core Module";
    }

}
