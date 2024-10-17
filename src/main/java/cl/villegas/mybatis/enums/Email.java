package cl.villegas.mybatis.enums;

public enum Email {
    /**
     * Host de servidor de correos {@code 1.0.0.0}.
     */
    HOST("1.0.0.0"),
    /**
     * Tipo de contenido {@code text/HTML; charset=UTF-8}.
     */
    CONTENT("text/HTML; charset=UTF-8"),
    /**
     * Formato {@code flowed}.
     */
    FORMAT("flowed"),
    /**
     * Codificacion de transferencia de contenido {@code 8bit}.
     */
    ENCODING("8bit"),
    /**
     * Correo de salida {@code noreply@villegas.cl}.
     */
    EMAIL("noreply@villegas.cl"),
    /**
     * Nombre de contacto {@code Noreply Villegas}.
     */
    TITLE("Noreply Villegas"),
    /**
     * Charset del correo {@code UTF-8}.
     */
    CHARSET("UTF-8");

    private final String value;

    private Email(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}