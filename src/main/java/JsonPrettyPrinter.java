/**
 * 
 * @author srt4@uw.edu
 */
public class JsonPrettyPrinter {

    public static void main(final String[] args) {
        System.out.println(new JsonPrettyPrinter().prettyPrintJson(Joiner.on(' ').join(args)));
    }

    /**
     *
     * @param input unformatted JSON, e.g. { firstName: "Bob", lastName: "Dole", occupation: { status: "retired" }}
     * @return
     * {
     *    firstName: "Bob",
     *    lastName: "Dole",
     *    occupation: {
     *        status: "retired"
     *    }
     * }
     */
    private String prettyPrintJson(final String input) {
        final StringBuilder sb = new StringBuilder((int) (input.length() * 1.5));
        int indentation = 0;
        for (char c : input.toCharArray()) {
            // handle whether indentation needs to be increased/decreased
            if (c == '{') {
                indentation++;
            }
            else if (c == '}') {
                indentation--;
            }

            // case 1: print the character, and then a linebreak
            if (c == '{' || c == ',') {
                sb.append(c);
                sb.append('\n');
                appendSpaces(sb, indentation);
            }
            // case 2: print a linebreak, and then the character
            else if (c == '}') {
                sb.append('\n');
                appendSpaces(sb, indentation);
                sb.append(c);
            }
            // case 3: print the character if it's non-whitespace 
            else if (c != '\n') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private void appendSpaces(final StringBuilder sb, final int numberOfSpaces) {
        for (int i = 0; i < numberOfSpaces * 3; i++) {
            sb.append(' ');
        }
    }

}
