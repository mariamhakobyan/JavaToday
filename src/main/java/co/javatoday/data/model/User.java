package co.javatoday.data.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import co.javatoday.util.StringUtils;

public class User implements Serializable {

    private static final long serialVersionUID = -4623786185488515904L;
    
    
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String title;
	private int userSource;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
     * @return the userSource
     */
    public int getUserSource() {
    	return userSource;
    }

	/**
     * @param userSource the userSource to set
     */
    public void setUserSource(int userSource) {
    	this.userSource = userSource;
    }
    
    /**
     * @param userSource the userSource to set
     */
    public void setUserSource(UserSource userSource) {
    	this.userSource = userSource.getValue();
    }
	
    /**
     * @return the userSource
     */
    public UserSource getUserSourceAsEnum() {
    	for(UserSource source: UserSource.values()) {
    		if(userSource == source.getValue()) {
    			return source;
    		}
    	}
    	return null;
    }
    
    public String getName() {
    	StringBuilder name = new StringBuilder(getFirstName());
    	if(StringUtils.isNotBlank(getLastName())) {
    		name.append(" ").append(getLastName());
    	}
    	return name.toString();
    }

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	    return "User [id=" + id + ", firstName=" + firstName + ", lastName="
	            + lastName + ", title=" + title + ", userSource=" + userSource
	            + "]";
    }
    
}
