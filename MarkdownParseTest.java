import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    
    @Test
    public void getLinksTest() throws IOException{
        Path fileName = Path.of("test-file1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void getLinksTest2() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void getLinksTest3() throws IOException{
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of(), links);
    }

    @Test
    public void getLinksTest4() throws IOException{
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of(), links);
    }

    @Test
    public void getLinksTest5() throws IOException{
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of("page.com"), links);
    }

    @Test
    public void getLinksTest6() throws IOException{
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of("page.com"), links);
    }

    @Test
    public void getLinksTest7() throws IOException{
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of(), links);
    }

    @Test
    public void getLinksTest8() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of("a link on the first line"), links);
    }

    @Test
    public void getLinksTest9() throws IOException{
        Path fileName = Path.of("new-test.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(List.of(), links);
    }
}
