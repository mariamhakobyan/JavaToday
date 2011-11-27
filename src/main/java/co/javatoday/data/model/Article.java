package co.javatoday.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.Document;

@Document
public class Article {

	@Id
	private String id;
	private String title;
	private String text;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	    return "Article [id=" + id + ", text=" + text + ", title=" + title
	            + "]";
    }
	

}