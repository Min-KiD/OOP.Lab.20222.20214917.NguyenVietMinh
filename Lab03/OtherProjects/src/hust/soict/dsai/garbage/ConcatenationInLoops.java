package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        int iterations = 200000;
        
        // Test '+'
        long startTime = System.currentTimeMillis();
        String concatenatedString = "";
        for (int i = 0; i < iterations; i++) {
            concatenatedString += "a";
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("String concatenation using '+': " + time);
        
        // Test StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("a");
        }
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println("String concatenation using StringBuffer: " + time);
        
        // Test StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("a");
        }
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println("String concatenation using StringBuilder: " + time);
    }
}