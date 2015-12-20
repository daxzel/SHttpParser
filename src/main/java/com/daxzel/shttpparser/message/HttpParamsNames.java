package com.daxzel.shttpparser.message;

import java.util.Set;

/**
 * Gives access to the full set of parameter names.
 *
 * @see HttpParams
 *
 * @since 4.2
 *
 * @deprecated (4.3) use configuration classes provided 'org.apache.http.config'
 *  and 'org.apache.http.client.config'
 */
@Deprecated
public interface HttpParamsNames {

    /**
     * Returns the current set of names;
     * in the case of stacked parameters, returns the names
     * from all the participating HttpParams instances.
     *
     * Changes to the underlying HttpParams are not reflected
     * in the set - it is a snapshot.
     *
     * @return the names, as a Set&lt;String&gt;
     */
    Set<String> getNames();

}
