/**
 * Enumeration for the student statuses. Mapped to each status is the amount of hours to be considered full time.
 */
public enum StudentStatus {
    /**
     * Student type undergraduate. 15 hour full load
     */
    UNDERGRADUATE(15),
    /**
     * Student type graduate. 9 hour full load
     */
    GRADUATE(9),
    /**
     * Student type open enrolled. 3 hour full load
     */
    OPENENROLLED(3),
    /**
     * Default student type.
     */
    DEFAULT(0);

    private final int fullLoad;

    /**
     * Sets the full load value of the student status
     * @param fullLoad Value of a full load for this student.
     */
    StudentStatus(int fullLoad) {
        this.fullLoad = fullLoad;
    }

    /**
     * Returns value of full load for specified student type
     * @return Value of full load
     */
    public int getFullLoad() {
        return fullLoad;
    }
}
