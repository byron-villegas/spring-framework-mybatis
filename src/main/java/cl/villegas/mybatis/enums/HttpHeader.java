package cl.villegas.mybatis.enums;

public enum HttpHeader {
    /**
     * Disposicion del contenido {@code content-disposition}.
     */
    CONTENT("content-disposition"),
    /**
     * Formato para el nombre del archivo {@code inline; filename=}.
     */
    FILENAME("inline; filename=");

    private final String value;

    private HttpHeader(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}