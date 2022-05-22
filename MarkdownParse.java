// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.List;


public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();

        if (! markdown.contains("[") || ! markdown.contains("]")) {
            return toReturn;
        }

        if (! markdown.contains("(") || ! markdown.contains(")")) {
            return toReturn;
        }



        if (markdown.contains("![")) {
            return toReturn;
        }

        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            if(openBracket == -1 || closeBracket == openBracket+1) {
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            if (! markdown.substring(currentIndex).contains("[") 
                || ! markdown.substring(currentIndex).contains("]")
                || ! markdown.substring(currentIndex).contains("(")
                || ! markdown.substring(currentIndex).contains("[")) {
                    break;
                }
        }
        toReturn.add("no link");

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}