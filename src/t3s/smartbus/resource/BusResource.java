package t3s.smartbus.resource;


import java.net.*;
import java.util.*;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
			if(b.getLineNumber() == number){
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
