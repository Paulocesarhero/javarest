/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.Catalogo;

/**
 * REST Web Service
 *
 * @author paulo
 */
@Path("catalogos")
public class CatalogoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CatalogoWS
     */
    public CatalogoWS() {
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<Catalogo> getAll(){
        List<Catalogo> list = new ArrayList<Catalogo>();
        Catalogo c;
        for(int i = 1; i<=100; i++){
            c = new Catalogo(i,"Catalogo prueba"+1,200+i,i);
            list.add(c);
        }
        return list;    
    }
        
    @Path("byId/{idcatalogo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Catalogo getCatalogoById(
            @PathParam("idcatalogo") Integer idcatalogo){
        Catalogo c = new Catalogo(idcatalogo,
                "Catalogo"+idcatalogo, +200+idcatalogo,0);
        return c;
    }
        
}
