package co.edu.uniquindio.banco.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "AUTENTICAR PERSONA", query = "select p from Persona p where p.email = :email and p.clave = :clave"),
	@NamedQuery(name = "LISTA_PERSONA_FAVORITOS", query = "select f.vehiculo from Persona p join p.favoritos f where p.email = :email"),
    @NamedQuery(name = "LISTA_PERSONAS_ORDENADA", query = "select p from Persona p order by p.nombre asc"),
    @NamedQuery(name = "BUSCAR_POR_EMAIL", query = "select p from Persona p where p.email = :email"),
    @NamedQuery(name = "COUNT_PERSONAS", query = "select count (p) from Persona p"),
    @NamedQuery(name = "LISTA_PERSONAS", query = "select p from Persona p"),
	@NamedQuery(name = "PERSONA_POR_NOMBRE", query = "select p from Persona p where p.nombre = :nombre")


})

public class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 100, nullable = false)
	private Integer id;
	
	@NotBlank(message = "el nombre no puede ser vacio")
	@Column(name = "nombre", length = 200, nullable = false)
	private String nombre;
	
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "la clave no puede ser vacio")
	@Column(name = "clave", length = 100, nullable = false)
	private String clave;
	
	@Column(name = "direccion", length = 200, nullable = false)
	private String direccion;
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "codigo_ciudad", nullable = false)
	@ManyToOne
	private Ciudad ciudad ;
	
	@ElementCollection
	private java.util.Map<String,Integer> telefonos;
	
	
	@OneToMany(mappedBy = "idpersona")
	private java.util.List<Vehiculo> vehiculos;
	 
	
	@OneToMany(mappedBy = "persona")
	private List<Favorito> favoritos;
	
	@OneToMany(mappedBy = "persona")
	private List<Pregunta> preguntas;
	
	

	public Persona(String nombre, String email, String clave, String direccion, Ciudad ciudad,
			Map<String, Integer> telefonos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefonos = telefonos;
	}

	public Persona() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public java.util.Map<String, Integer> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(java.util.Map<String, Integer> telefonos) {
		this.telefonos = telefonos;
	}

	public java.util.List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(java.util.List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", clave=" + clave + ", direccion="
				+ direccion + ", ciudad=" + ciudad + "]";
	}
	
	
   
}
