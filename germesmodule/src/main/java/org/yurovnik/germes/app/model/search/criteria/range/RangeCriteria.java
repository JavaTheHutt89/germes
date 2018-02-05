package org.yurovnik.germes.app.model.search.criteria.range;


import org.yurovnik.germes.app.infra.exception.flow.InvalidParameterException;
import org.yurovnik.germes.app.infra.util.Checks;

public class RangeCriteria {
    /**
     * page index (0-based)
     */
    private final int page;

    /**
     * Number of elements per page.
     * Zero means that we should return all the elements
     */
    private final int rowCount;

    public RangeCriteria(int page, int rowCount) {
        Checks.checkParameter(page >= 0,"Incorrect page index: " + page);
        Checks.checkParameter(rowCount >= 0,"Incorrect row count: " + page);
        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
