package br.com.larimaia.rest;

import br.com.larimaia.bo.EstadoBO;
import br.com.larimaia.entity.Estado;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 07/12/2015.
 */
@Path("/estado")
public class EstadoResource {

    @Inject
    EstadoBO estadoBO;

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Estado e){
        estadoBO.salvar(e);
        return Response.status(200).entity(e).build();

    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(estadoBO.Editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){estadoBO.excluir(id); }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        return Response.status(200).entity(estadoBO.listar()).build();
    }
}
