package mx.cuu.dev.security.model;

import java.util.Date;

/**
 * To Do Item model.
 * 
 * @author Julio Cesar Bolaños Palacios.
 *
 */
public class ToDoItem {

    private Integer id;

    private String name;

    private Date registerDate;

    private boolean completed;

    /**
     * Constructor of the class.
     */
    public ToDoItem() {
        super();
    }

    /**
     * Constructor of the class.
     *
     * @param id
     * @param name
     * @param registerDate
     * @param completed
     */
    public ToDoItem(final Integer id, final String name, final Date registerDate, final boolean completed) {
        super();
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
        this.completed = completed;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the registerDate
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     *            the registerDate to set
     */
    public void setRegisterDate(final Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return the completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * @param completed
     *            the completed to set
     */
    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

}
