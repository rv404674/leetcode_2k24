import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveTheComments {
    public static List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean multiLineEncountered = false;
        String lastEncountered = "";

        for (String line : source) {
            if (!multiLineEncountered && line.contains("//")) {
                String[] parts = line.split("//", 2);
                if (!Objects.equals(parts[0], ""))
                    ans.add(parts[0]);

                continue;
            }

            if (line.contains("/*")) {
                String[] parts = line.split("/\\*", 2);
                lastEncountered = parts[0];

                multiLineEncountered = true;
                continue;
            }

            if (line.contains("*/")) {
                String[] parts = line.split("\\*/", 2);
                lastEncountered = lastEncountered + parts[1];
                if (!lastEncountered.equals("")) {
                    ans.add(lastEncountered);
                    lastEncountered = "";
                }


                multiLineEncountered = false;
                continue;
            }

            if (!multiLineEncountered) {
                ans.add(line);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] ut1 = {"abc/*Test program", "int */main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(removeComments(ut1));
    }
}
