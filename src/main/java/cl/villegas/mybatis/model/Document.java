package cl.villegas.mybatis.model;

import io.swagger.annotations.ApiModelProperty;

public class Document {
    @ApiModelProperty(notes = "ID generado por la base de datos")
    private long id;
    @ApiModelProperty(notes = "El nombre del archivo")
    private String name;
    @ApiModelProperty(notes = "El archivo en bytes")
    private byte[] file;
    @ApiModelProperty(notes = "El tipo de contenido del archivo")
    private String contentType;

    public Document() {
        this.id = 0;
        this.name = null;
        this.file = null;
        this.contentType = null;
    }

    public Document(long id, String name, byte[] file, String contentType) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.contentType = contentType;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return this.file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return String.format("Document [id='%d', name='%s', contentType='%s']", this.id, this.name, this.contentType);
    }
}