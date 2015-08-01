
package live.trademe;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class GeographicLocation {

    @Expose
    private Double Latitude;
    @Expose
    private Double Longitude;
    @Expose
    private Integer Northing;
    @Expose
    private Integer Easting;
    @Expose
    private Integer Accuracy;

    /**
     * 
     * @return
     *     The Latitude
     */
    public Double getLatitude() {
        return Latitude;
    }

    /**
     * 
     * @param Latitude
     *     The Latitude
     */
    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    /**
     * 
     * @return
     *     The Longitude
     */
    public Double getLongitude() {
        return Longitude;
    }

    /**
     * 
     * @param Longitude
     *     The Longitude
     */
    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

    /**
     * 
     * @return
     *     The Northing
     */
    public Integer getNorthing() {
        return Northing;
    }

    /**
     * 
     * @param Northing
     *     The Northing
     */
    public void setNorthing(Integer Northing) {
        this.Northing = Northing;
    }

    /**
     * 
     * @return
     *     The Easting
     */
    public Integer getEasting() {
        return Easting;
    }

    /**
     * 
     * @param Easting
     *     The Easting
     */
    public void setEasting(Integer Easting) {
        this.Easting = Easting;
    }

    /**
     * 
     * @return
     *     The Accuracy
     */
    public Integer getAccuracy() {
        return Accuracy;
    }

    /**
     * 
     * @param Accuracy
     *     The Accuracy
     */
    public void setAccuracy(Integer Accuracy) {
        this.Accuracy = Accuracy;
    }

}
