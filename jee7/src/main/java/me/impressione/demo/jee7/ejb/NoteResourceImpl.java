package me.impressione.demo.jee7.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import me.impressione.demo.jee7.entity.Note;
import me.impressione.demo.jee7.rest.NoteResource;

@Stateless
public class NoteResourceImpl implements NoteResource {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Note> getNotes() {
		return entityManager.createQuery("from Note order by id", Note.class)
				.getResultList();
	}

	@Override
	public void removeNote(Long noteId) {
		final Note note = entityManager.find(Note.class, noteId);
		if (null == note) {
			throw new NoResultException("No note with id " + noteId + " found");
		}
		entityManager.remove(note);
	}

	@Override
	public Note saveNote(Note note) {
		entityManager.persist(note);
		return note;
	}
}
