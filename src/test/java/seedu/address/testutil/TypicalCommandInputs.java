package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONTACT_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CYCLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;

/**
 * Typical command input values and prefixed input fragments used across parser and command tests.
 */
public final class TypicalCommandInputs {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";

    public static final String VALID_EMAIL_AMY = "amy@stripe.com";
    public static final String VALID_EMAIL_BOB = "bob@google.com";

    public static final String VALID_CONTACT_ROLE_AMY = "recruiter";
    public static final String VALID_CONTACT_ROLE_BOB = "hiring manager";

    public static final String VALID_COMPANY_AMY = "Stripe";
    public static final String VALID_COMPANY_BOB = "Google";

    public static final String VALID_ROLE_AMY = "SWE Intern";
    public static final String VALID_ROLE_BOB = "Backend Intern";

    public static final String VALID_STATUS_AMY = "APPLIED";
    public static final String VALID_STATUS_BOB = "INTERVIEW";

    public static final String VALID_CYCLE_AMY = "SUMMER 2025";
    public static final String VALID_CYCLE_BOB = "WINTER 2025";

    public static final String VALID_PHONE_AMY = "91234567";
    // No phone number for Bob

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;

    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;

    public static final String CONTACT_ROLE_DESC_AMY = " " + PREFIX_CONTACT_ROLE + VALID_CONTACT_ROLE_AMY;
    public static final String CONTACT_ROLE_DESC_BOB = " " + PREFIX_CONTACT_ROLE + VALID_CONTACT_ROLE_BOB;

    public static final String COMPANY_DESC_AMY = " " + PREFIX_COMPANY + VALID_COMPANY_AMY;
    public static final String COMPANY_DESC_BOB = " " + PREFIX_COMPANY + VALID_COMPANY_BOB;

    public static final String ROLE_DESC_AMY = " " + PREFIX_ROLE + VALID_ROLE_AMY;
    public static final String ROLE_DESC_BOB = " " + PREFIX_ROLE + VALID_ROLE_BOB;

    public static final String STATUS_DESC_AMY = " " + PREFIX_STATUS + VALID_STATUS_AMY;
    public static final String STATUS_DESC_BOB = " " + PREFIX_STATUS + VALID_STATUS_BOB;

    public static final String CYCLE_DESC_AMY = " " + PREFIX_CYCLE + VALID_CYCLE_AMY;
    public static final String CYCLE_DESC_BOB = " " + PREFIX_CYCLE + VALID_CYCLE_BOB;

    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_CLEAR = " " + PREFIX_PHONE;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + " ";
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "notanemail";
    public static final String INVALID_CONTACT_ROLE_DESC = " " + PREFIX_CONTACT_ROLE + " ";
    public static final String INVALID_COMPANY_DESC = " " + PREFIX_COMPANY + " ";
    public static final String INVALID_ROLE_DESC = " " + PREFIX_ROLE + " ";
    public static final String INVALID_STATUS_DESC = " " + PREFIX_STATUS + "UNKNOWN";
    public static final String INVALID_CYCLE_DESC = " " + PREFIX_CYCLE + "Autumn 2025";
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "67";

    public static final String LEADING_WHITESPACE = "\t  \r  \n";
    public static final String EXTRA_TEXT_AT_START = " EXTRA TEXT";

    // Prevent instantiation
    private TypicalCommandInputs() {}
}
