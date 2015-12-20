package com.daxzel.shttpparser;

/**
 * HTTP Message constraints: line length and header count.
 * <p>
 * Please note that line length is defined in bytes and not characters.
 * This is only relevant however when using non-standard HTTP charsets
 * for protocol elements such as UTF-8.
 * </p>
 *
 * @since 4.3
 */
public class MessageConstraints implements Cloneable {

    public static final MessageConstraints DEFAULT = new Builder().build();

    private final int maxLineLength;
    private final int maxHeaderCount;

    MessageConstraints(final int maxLineLength, final int maxHeaderCount) {
        super();
        this.maxLineLength = maxLineLength;
        this.maxHeaderCount = maxHeaderCount;
    }

    public int getMaxLineLength() {
        return maxLineLength;
    }

    public int getMaxHeaderCount() {
        return maxHeaderCount;
    }

    @Override
    protected MessageConstraints clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[maxLineLength=").append(maxLineLength)
                .append(", maxHeaderCount=").append(maxHeaderCount)
                .append("]");
        return builder.toString();
    }

    public static MessageConstraints lineLen(final int max) {
        return new MessageConstraints(max, -1);
    }

    public static MessageConstraints.Builder custom() {
        return new Builder();
    }

    public static MessageConstraints.Builder copy(final MessageConstraints config) {
        return new Builder()
                .setMaxHeaderCount(config.getMaxHeaderCount())
                .setMaxLineLength(config.getMaxLineLength());
    }

    public static class Builder {

        private int maxLineLength;
        private int maxHeaderCount;

        Builder() {
            this.maxLineLength = -1;
            this.maxHeaderCount = -1;
        }

        public Builder setMaxLineLength(final int maxLineLength) {
            this.maxLineLength = maxLineLength;
            return this;
        }

        public Builder setMaxHeaderCount(final int maxHeaderCount) {
            this.maxHeaderCount = maxHeaderCount;
            return this;
        }

        public MessageConstraints build() {
            return new MessageConstraints(maxLineLength, maxHeaderCount);
        }

    }

}
