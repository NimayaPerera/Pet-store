package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.petstore.DB.db;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pettypes")
@Produces("application/json")
public class PetTypeResource {

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
    @GET
    public Response getPetsTypes() {

        return Response.ok(DB.getTypeTable()).build();

    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
            @APIResponse(responseCode = "404", description = "No Pet found for the id.") })
    @GET
    @Path("{petTypeId}")
    public Response getPetType(@PathParam("petTypeId") int id) {
        PetType type = null;
        for(PetType temp : DB.getTypeTable()){
            if(temp.getPetTypeId() == id){
                type=temp;
            }
        }

        return Response.ok(type).build();

    }

    @POST
    @Path("addPetType")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "Pet Type adding failed.") })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPetType(@RequestBody PetType type) {
        PetType savedType = DB.savePetType(type);
        return Response.ok(savedType).build();
    }

    //update
    @Path("updatePettype")
    @PUT
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type updated", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "Pet Type updating failed.") })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePetType(@RequestBody PetType type) {
        PetType updatedPetType = null;
        for (PetType temp : DB.getTypeTable()) {
            if (temp.getPetTypeId() == type.getPetTypeId()){
                updatedPetType = DB.updateType(temp, type);
            }
        }
        return Response.ok(updatedPetType).build();
    }

    //delete
    @Path("deletePettype")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePet(@RequestBody PetType type) {
        for (PetType temp : DB.getTypeTable()) {
            if (temp.getPetTypeId() == type.getPetTypeId()){
                DB.deleteType(temp);
            }
        }
    }
}


