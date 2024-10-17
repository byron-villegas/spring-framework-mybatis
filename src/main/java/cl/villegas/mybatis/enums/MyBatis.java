package cl.villegas.mybatis.enums;

public enum MyBatis {
    /**
     * Package para la busqueda de clases {@code cl.villegas.mybatis.model}.
     */
    PACKAGEALIASE("cl.villegas.mybatis.model"),
    /**
     * Package para la busqueda de handlers {@code cl.villegas.mybatis.typehandler}.
     */
    PACKAGEHANDLER("cl.villegas.mybatis.typehandler");

    private final String value;

    private MyBatis(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}