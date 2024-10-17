package cl.villegas.mybatis.enums;

public enum Swagger {
    /**
     * Package base para los controladores {@code cl.villegas.mybatis.controller}.
     */
    PACKAGE("cl.villegas.mybatis.controller"),
    /**
     * Titulo para la documentacion {@code SPRING FRAMEWORK MYBATIS API}.
     */
    TITLE("SPRING FRAMEWORK MYBATIS API"),
    /**
     * Descripcion para la documentacion {@code Spring Framework MyBatis API}.
     */
    DESCRIPTION("Spring Framework MyBatis API"),
    /**
     * Nombre del contacto {@code Byron Stevens Villegas Moya}.
     */
    NAME("Byron Stevens Villegas Moya"),
    /**
     * URL del contacto {@code https://gitlab.com/users/byron.villegas/projects}.
     */
    URL("https://gitlab.com/users/byron.villegas/projects"),
    /**
     * Correo del contacto {@code byronvillegasm@gmail.com}.
     */
    EMAIL("byronvillegasm@gmail.com"),
    /**
     * Licencia de la documentacion {@code Apache 2.0}.
     */
    LICENSE("Apache 2.0"),
    /**
     * Url de la liencia {@code http://www.apache.org/licenses/LICENSE-2.0.html}.
     */
    LICENSEURL("http://www.apache.org/licenses/LICENSE-2.0.html"),
    /**
     * Version de la licencia {@code 1.0.0}.
     */
    LICENSEVERSION("1.0.0");

    private final String value;

    private Swagger(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}