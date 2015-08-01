
package live.trademe;

import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ListingGroup {

    @Expose
    private Integer TotalCount;
    @Expose
    private Integer Page;
    @Expose
    private Integer PageSize;
    @Expose
    private java.util.List<live.trademe.List> List = new ArrayList<live.trademe.List>();

    /**
     * 
     * @return
     *     The TotalCount
     */
    public Integer getTotalCount() {
        return TotalCount;
    }

    /**
     * 
     * @param TotalCount
     *     The TotalCount
     */
    public void setTotalCount(Integer TotalCount) {
        this.TotalCount = TotalCount;
    }

    /**
     * 
     * @return
     *     The Page
     */
    public Integer getPage() {
        return Page;
    }

    /**
     * 
     * @param Page
     *     The Page
     */
    public void setPage(Integer Page) {
        this.Page = Page;
    }

    /**
     * 
     * @return
     *     The PageSize
     */
    public Integer getPageSize() {
        return PageSize;
    }

    /**
     * 
     * @param PageSize
     *     The PageSize
     */
    public void setPageSize(Integer PageSize) {
        this.PageSize = PageSize;
    }

    /**
     * 
     * @return
     *     The List
     */
    public java.util.List<live.trademe.List> getList() {
        return List;
    }

    /**
     * 
     * @param List
     *     The List
     */
    public void setList(java.util.List<live.trademe.List> List) {
        this.List = List;
    }

}
