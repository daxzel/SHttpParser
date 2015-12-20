package com.daxzel.shttpparser.message;

import java.util.Set;

/**
 * Abstract base class for parameter collections.
 * Type specific setters and getters are mapped to the abstract,
 * generic getters and setters.
 *
 * @since 4.0
 *
 * @deprecated (4.3) use configuration classes provided 'org.apache.http.config'
 *  and 'org.apache.http.client.config'
 */
@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {

    /**
     * Instantiates parameters.
     */
    protected AbstractHttpParams() {
        super();
    }

    public long getLongParameter(final String name, final long defaultValue) {
        final Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Long) param).longValue();
    }

    public HttpParams setLongParameter(final String name, final long value) {
        setParameter(name, Long.valueOf(value));
        return this;
    }

    public int getIntParameter(final String name, final int defaultValue) {
        final Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Integer) param).intValue();
    }

    public HttpParams setIntParameter(final String name, final int value) {
        setParameter(name, Integer.valueOf(value));
        return this;
    }

    public double getDoubleParameter(final String name, final double defaultValue) {
        final Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Double) param).doubleValue();
    }

    public HttpParams setDoubleParameter(final String name, final double value) {
        setParameter(name, Double.valueOf(value));
        return this;
    }

    public boolean getBooleanParameter(final String name, final boolean defaultValue) {
        final Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Boolean) param).booleanValue();
    }

    public HttpParams setBooleanParameter(final String name, final boolean value) {
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public boolean isParameterTrue(final String name) {
        return getBooleanParameter(name, false);
    }

    public boolean isParameterFalse(final String name) {
        return !getBooleanParameter(name, false);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dummy implementation - must be overridden by subclasses.
     *
     * @since 4.2
     * @throws UnsupportedOperationException - always
     */
    public Set<String> getNames(){
        throw new UnsupportedOperationException();
    }

} // class AbstractHttpParams
