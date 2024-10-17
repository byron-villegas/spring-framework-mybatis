package cl.villegas.mybatis.enums;

public enum Report {
    /**
     * Ruta de los reportes {@code /reports/}.
     */
    PATH("/reports/"),
    /**
     * Extension de los reportes {@code .jrxml}.
     */
    FILE(".jrxml");

    private final String value;

    private Report(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}