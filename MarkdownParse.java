//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.File;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            currentIndex = closeParen + 1;
            if (currentIndex == markdown.length() - 1) {
                break;
            }
            if (openBracket == -1) {
                break;
            }
            if (closeBracket == -1) {
                break;
            }
            if (openParen == -1) {
                break;
            }
            if (closeParen == -1) {
                break;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            
            System.out.println(openBracket);
            System.out.println(closeBracket);
            System.out.println(openParen);
            System.out.println(closeParen);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        File fileContent = new File(args[0]);
        String content = Files.readString(fileName);
        if (fileContent.isDirectory()) {
            for (File inFolder : fileContent.listFiles()) {
                fileName = Path.of(fileContent.getName() + "/" + inFolder.getName());
                System.out.println(fileName.getFileName());
                ArrayList<String> links = getLinks(content);
                System.out.println(links);
            }
        } else {
            System.out.println(fileName);
            ArrayList<String> links = getLinks(content);
	        System.out.println(links);
        }
    }
}
