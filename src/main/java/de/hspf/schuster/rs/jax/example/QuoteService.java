package de.hspf.schuster.rs.jax.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author thomas.schuster
 */
@Stateless
@Path("quotes")
public class QuoteService {

    @Inject
    QuotesLoaderBean quoteLoader;

    @GET
    @Path("getquote")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(quoteLoader.getQuote());
    }
    
    @GET
    @Path("getcitation")
    @Produces(MediaType.APPLICATION_JSON)
    public Citation getCitation() {
        return quoteLoader.getCitation();
    }

    @POST
    @Path("createquote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Citation createQuote(String quote) {
        return quoteLoader.createCitation(quote);
    }

}
