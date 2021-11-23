public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxRep = 0;
        int currentRep = 0;
        int i = 0;
        while (i < dna.length() - 2) {
            String subStr = dna.substring(i, i+3);
            // StdOut.println(subStr);
            if (subStr.equals("CAG")) {
                currentRep++;
                i += 3;
            }
            else {
                if (currentRep > maxRep) maxRep = currentRep;
                currentRep = 0;
                i++;
            }
        }
        if (currentRep > maxRep) maxRep = currentRep;
        return maxRep;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String tmp = s;
        tmp = tmp.replace("\n", "");
        tmp = tmp.replace("\t", "");
        tmp = tmp.replace(" ", "");
        return tmp;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats <= 39) return "high risk";
        else return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String file = args[0];
        In in = new In(file);
        String repeats = in.readAll();
        String nowhitespaces = removeWhitespace(repeats);
        int repCounter = maxRepeats(nowhitespaces);
        StdOut.println("max repeats = " + repCounter);
        StdOut.println(diagnose(repCounter));
    }
}