/**
 * Created by Tanner on 9/27/2016.
 */
public enum StudentStatus {
    UNDERGRADUATE(15),
    GRADUATE(9),
    OPENENROLLED(3),
    DEFAULT(0);

    private final int fullLoad;

    StudentStatus(int fullLoad) {
        this.fullLoad = fullLoad;
    }

    public int getFullLoad() {
        return fullLoad;
    }
}
