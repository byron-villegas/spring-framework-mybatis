package cl.villegas.mybatis.enums;

public enum App {
    /**
     * Perfil de Spring Framework {@code default}.
     */
    PROFILE("default");

    private final String value;

    private App(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}