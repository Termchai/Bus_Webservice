package t3s.smartbus.resource;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.eclipse.jetty.http.HttpHeader;

import t3s.smartbus.entity.Bus;
import t3s.smartbus.memory.BusMemoryCache;
/**
 * 
 * @author Termchai, Supavit
 *
 */

@Path("/busesposition")
public class BusResource {
	private BusMemoryCache cache = BusMemoryCache.getInstance(null);
	
	@Context
	UriInfo uriInfo;

//	@GET
//	@Path("{id}")
//	public Response getProductByID(@PathParam("id") String id, @HeaderParam ("If-None-Match") String none_match, @HeaderParam ("If-Match") String match)
//	{
//		Bus p = dao.find(Long.parseLong(id));
//		if (p==null)
//			return Response.status(Status.NOT_FOUND).build();
//		if (none_match != null && none_match.equals("\""+p.hashCode()+"\"") || match != null && !match.equals("\""+p.hashCode()+"\""))
//			return Response.status(Status.NOT_MODIFIED).build();
//		
//		return Response.ok(p).tag(new EntityTag(p.hashCode()+"")).build();
//	}
	
	/**
	 * Get all buses by bus id number.
	 * @param id the id number of bus
	 * @return HttpStatusCode
	 */
	@GET
	@Path("{id:\\d*}")
	@Produces (MediaType.APPLICATION_XML)
	public Response getBusByIdNumber(@PathParam("id") long id){
		List<Bus> busList = cache.findAll();
		List<Bus> busid = new ArrayList<Bus> ();
		for(Bus b : busList){
			if(b.getId() == id){
				busid.add(b);
			}
		}
		GenericEntity<List<Bus>> entity = new GenericEntity<List<Bus>>(busid){};
		System.out.println(entity.toString());
		return Response.ok(entity).build();
	}

	/**
	 * Get all buses of particular line number.
	 * @param id 
	 * @return HttpStatusCode
	 */
	@GET
	@Path("{number:\\d*}")
	@Produces (MediaType.APPLICATION_XML)
	public Response getBusesByLineNumber(@PathParam("number") long number){
		List<Bus> busList = cache.findAll();
		List<Bus> busLine = new ArrayList<Bus>();
		for(Bus b : busList){
			if(b.getBusLineNumber() == number){
				busLine.add(b);
			}
		}
		GenericEntity<List<Bus>> entity = new GenericEntity<List<Bus>>(busLine){};
		System.out.println(entity.toString());
		return Response.ok(entity).build();
	}
	
	/**
	 * Get all buses available at that time.
	 * @return HttpStatus Code
	 */
	@GET
	@Produces (MediaType.APPLICATION_XML)
	public Response getAllBuses()
	{
		GenericEntity<List<Bus>> entity;
		entity = new GenericEntity<List<Bus>>(cache.findAll()) {};
		System.out.println(entity.toString());
		return Response.ok(entity).build();
	}

}
