package cl.villegas.mybatis.model;

import io.swagger.annotations.ApiModelProperty;

public class Person {
	@ApiModelProperty(notes = "ID generado por la base de datos")
	private long id;
	@ApiModelProperty(notes = "El rut de la persona")
	private String rut;
	@ApiModelProperty(notes = "Los nombres de la persona")
	private String names;
	@ApiModelProperty(notes = "Los apellidos de la persona")
	private String surnames;
	@ApiModelProperty(notes = "La edad de la persona")
	private short age;

	public Person() {
		this.id = 0;
		this.rut = null;
		this.names = null;
		this.surnames = null;
		this.age = 0;
	}

	public Person(long id, String rut, String names, String surnames, short age) {
		this.id = id;
		this.rut = rut;
		this.names = names;
		this.surnames = surnames;
		this.age = age;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Person[id='%d', names='%s', surnames='%s', age='%d']", this.id, this.names, this.surnames,
				this.age);
	}
}