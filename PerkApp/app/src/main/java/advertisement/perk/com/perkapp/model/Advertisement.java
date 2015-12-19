package advertisement.perk.com.perkapp.model;

/**
 * Created by Agoel on 19-12-2015.
 */
public class Advertisement {

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String heading;
    private String description;
    private boolean status;
}
