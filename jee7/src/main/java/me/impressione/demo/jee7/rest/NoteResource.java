package me.impressione.demo.jee7.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import me.impressione.demo.jee7.entity.Note;

@Path("/note")
public interface NoteResource {

	@GET
	@Path("/")
	List<Note> getNotes();

	@DELETE
	@Path("/{id}")
	void removeNote(@PathParam("id") Long noteId);

	@POST
	@Path("/")
	Note saveNote(Note note);
}
