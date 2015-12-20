package com.daxzel.shttpparser.message;


/**
 * Basic implementation of {@link HeaderElement}
 *
 * NotThreadSafe
 */
public class BasicHeaderElement implements HeaderElement, Cloneable {

    private final String name;
    private final String value;
    private final NameValuePair[] parameters;

    /**
     * Constructor with name, value and parameters.
     *
     * @param name header element name
     * @param value header element value. May be {@code null}
     * @param parameters header element parameters. May be {@code null}.
     *   Parameters are copied by reference, not by value
     */
    public BasicHeaderElement(
            final String name,
            final String value,
            final NameValuePair[] parameters) {
        super();
        this.name = name;
        this.value = value;
        if (parameters != null) {
            this.parameters = parameters;
        } else {
            this.parameters = new NameValuePair[] {};
        }
    }

    /**
     * Constructor with name and value.
     *
     * @param name header element name
     * @param value header element value. May be {@code null}
     */
    public BasicHeaderElement(final String name, final String value) {
        this(name, value, null);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public NameValuePair[] getParameters() {
        return this.parameters.clone();
    }

    public int getParameterCount() {
        return this.parameters.length;
    }

    public NameValuePair getParameter(final int index) {
        // ArrayIndexOutOfBoundsException is appropriate
        return this.parameters[index];
    }

    public NameValuePair getParameterByName(final String name) {
        NameValuePair found = null;
        for (final NameValuePair current : this.parameters) {
            if (current.getName().equalsIgnoreCase(name)) {
                found = current;
                break;
            }
        }
        return found;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof HeaderElement) {
            final BasicHeaderElement that = (BasicHeaderElement) object;
            return this.name.equals(that.name)
                    && LangUtils.equals(this.value, that.value)
                    && LangUtils.equals(this.parameters, that.parameters);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        for (final NameValuePair parameter : this.parameters) {
            hash = LangUtils.hashCode(hash, parameter);
        }
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(this.name);
        if (this.value != null) {
            buffer.append("=");
            buffer.append(this.value);
        }
        for (final NameValuePair parameter : this.parameters) {
            buffer.append("; ");
            buffer.append(parameter);
        }
        return buffer.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // parameters array is considered immutable
        // no need to make a copy of it
        return super.clone();
    }

}

