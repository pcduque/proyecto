package co.edu.uniquindio.proyecto.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniquindio.banco.entidades.Marca;
import co.edu.uniquindio.proyecto.ejb.PersonaEJB;

@Path("/marcas")
public class MarcaREST {
	
	@EJB
	private PersonaEJB unimotorEJB;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response listaMarcas(){
		return Response.status(200).entity(unimotorEJB.listaMarcas()).build() ;
	}
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response obtenerMarca(@PathParam("id") Integer id) {
		try {
			Marca marca = unimotorEJB.obtenerMarca(id);
			return Response.status(200).entity(marca).build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"mensaje\" : \""+e.getMessage()+"\"}").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response registrarMarca(Marca marca){
		try {
			unimotorEJB.guardarMarca(marca);
			return Response.status(200).entity("{\"mensaje\" : \"la marca de registro correctamente\"}").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"mensaje\" : \""+e.getMessage()+"\"}").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response actualizarMarca(Marca marca){
		try {
			unimotorEJB.actualizarMarca(marca);
			return Response.status(200).entity("{\"mensaje\" : \"la marca de actualizo correctamente\"}").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"mensaje\" : \""+e.getMessage()+"\"}").type(MediaType.APPLICATION_JSON).build();
		}		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response eliminarMarca( @PathParam("id") Integer id){
		try {
			unimotorEJB.eliminarMarca(id);
			return Response.status(200).entity("{\"mensaje\" : \"la marca de elimino correctamente\"}").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"mensaje\" : \""+e.getMessage()+"\"}").type(MediaType.APPLICATION_JSON).build();
		}
	}

}
