package seedu.address.model.opportunity;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a contact's name in the tracker.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String MESSAGE_CONSTRAINTS =
        "Names must be 1-60 characters and can contain alphabetic characters (including accented "
            + "and Unicode letters), digits, spaces, and the following punctuation marks (e.g. ' - . , ( ) &) "
            + "and must not be blank";

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 60;

    /*
     * Allow names to start with any permitted character (alphabetic, digit, or punctuation).
     * This supports placeholder values like "...", "(TBD)", or "---" when the name is unknown.
     * The first character must not be a whitespace (enforced by trim()).
     */
    public static final String VALIDATION_REGEX = "[\\p{IsAlphabetic}0-9'\\-.,()&][\\p{IsAlphabetic}0-9 '\\-.,()&]*";

    public final String fullName;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid name.
     */
    public Name(String name) {
        requireNonNull(name);
        String trimmedName = name.trim();
        checkArgument(isValidName(trimmedName), MESSAGE_CONSTRAINTS);
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        requireNonNull(test);
        String trimmedTest = test.trim();
        return trimmedTest.length() >= MIN_LENGTH
            && trimmedTest.length() <= MAX_LENGTH
            && trimmedTest.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Name)) {
            return false;
        }

        Name otherName = (Name) other;
        return fullName.equals(otherName.fullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
