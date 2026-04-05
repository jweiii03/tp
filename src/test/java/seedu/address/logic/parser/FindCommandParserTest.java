package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.getErrorMessageForDuplicatePrefixes;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ARCHIVE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.FindCommandParser.MESSAGE_AMBIGUOUS_ARCHIVE_KEYWORDS;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.opportunity.OpportunityContainsSubstringPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, " c/ ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, " Alice c/ ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, " a/ ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, " a/ c/ ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_nameOnlyArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "Alice Bob", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindCommand);
    }

    @Test
    public void parse_companyOnlyArgs_returnsFindCommand() {
        FindCommand expectedFindCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of(), List.of("Visa")));
        assertParseSuccess(parser, "c/Visa", expectedFindCommand);
        assertParseSuccess(parser, " c/Visa ", expectedFindCommand);
    }

    @Test
    public void parse_nameAndCompanyArgs_returnsFindCommand() {
        FindCommand expectedFindCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of("Alice"), List.of("Tik")));
        assertParseSuccess(parser, "Alice c/Tik", expectedFindCommand);
        assertParseSuccess(parser, " \n Alice \t c/Tik  ", expectedFindCommand);
    }

    @Test
    public void parse_archivedArgs_returnsFindCommand() {
        FindCommand expectedArchivedNameCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of("Jan")), true);
        FindCommand expectedArchivedCompanyCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of(), List.of("Visa")), true);
        FindCommand expectedArchivedNameAndCompanyCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of("Alice"), List.of("Tik")), true);
        FindCommand expectedArchivedMultiNameCommand =
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of("Jane", "Lim")), true);

        // keyword as a/ value
        assertParseSuccess(parser, "a/Jan", expectedArchivedNameCommand);
        assertParseSuccess(parser, "a/ Jan", expectedArchivedNameCommand);
        // keyword in preamble, a/ as valueless flag
        assertParseSuccess(parser, "Jan a/", expectedArchivedNameCommand);
        assertParseSuccess(parser, "Jane Lim a/", expectedArchivedMultiNameCommand);
        // company-only search with a/
        assertParseSuccess(parser, " a/ c/Visa ", expectedArchivedCompanyCommand);
        // name via a/ value with company prefix
        assertParseSuccess(parser, "a/Alice c/Tik", expectedArchivedNameAndCompanyCommand);
        assertParseSuccess(parser, " \n a/ \t Alice \t c/Tik  ", expectedArchivedNameAndCompanyCommand);
        // name in preamble with company and a/ flag
        assertParseSuccess(parser, " Alice a/ c/Tik", expectedArchivedNameAndCompanyCommand);
        // a/ after c/
        assertParseSuccess(parser, "c/Visa a/Jan",
                new FindCommand(new OpportunityContainsSubstringPredicate(List.of("Jan"), List.of("Visa")), true));
    }

    @Test
    public void parse_ambiguousArchiveKeywords_throwsParseException() {
        assertParseFailure(parser, "alice a/bob", MESSAGE_AMBIGUOUS_ARCHIVE_KEYWORDS);
        assertParseFailure(parser, "Jane a/Lim", MESSAGE_AMBIGUOUS_ARCHIVE_KEYWORDS);
    }

    @Test
    public void parse_duplicatePrefixes_throwsParseException() {
        assertParseFailure(parser, "Alice c/Stripe c/Google", getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY));
        assertParseFailure(parser, "a/ Alice c/Stripe c/Google",
                getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY));
        assertParseFailure(parser, "a/Jane a/Lim", getErrorMessageForDuplicatePrefixes(PREFIX_ARCHIVE));
    }
}
