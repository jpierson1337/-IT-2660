public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Best-case scenario: pattern is at the beginning of the text
    String bestCase = "ABCDEF";

    // Initialize startTime for best-case scenario
    long startTime = System.nanoTime();
    int index = match(text, bestCase);
    // Initialize endTime for best-case scenario
    long endTime = System.nanoTime();
    // Calculate elapsedTime for best-case scenario
    long elapsedTime = endTime - startTime;

    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");
    System.out.println("Elapsed time for best-case scenario: " + elapsedTime + " nanoseconds");

    // Worst-case scenario: pattern is not in the text or at the end
    String worstCase = "789XYZ";

    // Initialize startTime for worstcase
    startTime = System.nanoTime();
    index = match(text, worstCase);
    // Initialize endTime for worstcase
    endTime = System.nanoTime();
    // Calculate elapsedTime for worstcase
    elapsedTime = endTime - startTime;

    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");
    System.out.println("Elapsed time for worst-case scenario: " + elapsedTime + " nanoseconds");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }

  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text,
                                   String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }

    return true;
  }
}