package cl.villegas.mybatis.enums;

public enum MediaTypeParam {
    /**
     * Formato para el tipo xlsx {@code application/vnd.ms-excel} con extension {@code .xlsx}.
     */
    XLSX("application/vnd.ms-excel", ".xlsx"),
    /**
     * Formato para el tipo pdf {@code application/pdf} con extension {@code .pdf}.
     */
    PDF("application/pdf", ".pdf"),
    /**
     * Formato para el tipo csv {@code text/csv} con extension {@code .csv}
     */
    CSV("text/csv", ".csv"),
    /**
     * Formato para el tipo html {@code text/html} con extension {@code .html}.
     */
    HTML("text/html", ".html");

    private final String type;
    private final String file;

    private MediaTypeParam(final String type, final String file) {
        this.type = type;
        this.file = file;
    }

    public String getType() {
        return this.type;
    }

    public String getFile() {
        return this.file;
    }
}