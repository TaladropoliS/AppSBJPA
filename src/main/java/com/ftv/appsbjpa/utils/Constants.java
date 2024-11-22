package com.ftv.appsbjpa.utils;

public final class Constants {
    // Mensajes
    public static final String MSG_REGISTRO_CREADO = "Registro creado exitosamente";
    public static final String MSG_REGISTRO_ACTUALIZADO = "Registro actualizado exitosamente";
    public static final String MSG_REGISTRO_ELIMINADO = "Registro eliminado exitosamente";

    // Rutas
    public static final String REDIRECT_LISTAR = "redirect:/listar";

    // Validaciones
    public static final int MIN_NOMBRE_LENGTH = 3;
    public static final int MAX_NOMBRE_LENGTH = 50;

    private Constants() {
        // Constructor privado para evitar instanciación
    }
}