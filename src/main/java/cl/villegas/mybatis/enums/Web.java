package cl.villegas.mybatis.enums;

public enum Web {
    /**
     * Busqueda de las librerias de swagger ui con parametro {@code swagger-ui.html} con valor {@code classpath:/META-INF/resources/}.
     */
    SWAGGER("swagger-ui.html", "classpath:/META-INF/resources/"),
    /**
     * Busqueda de las librerias de java con parametro {@code /webjars/**} con valor {@code classpath:/META-INF/resources/webjars/}.
     */
    WEBJAR("/webjars/**", "classpath:/META-INF/resources/webjars/"),
    /**
     * Busqueda de las views con parametro {@code /WEB-INF/views/} con extension {@code .jsp}.
     */
    RESOLVER("/WEB-INF/views/", ".jsp"),
    /**
     * Busqueda de las templates con parametro {@code freemarker} con valor {@code classpath:/templates/}.
     */
    FREEMARKER("utf-8", "classpath:/templates/");

    private final String parameter;
    private final String value;

    private Web(final String parameter, final String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public String getParameter() {
        return parameter;
    }

    public String getValue() {
        return value;
    }
}