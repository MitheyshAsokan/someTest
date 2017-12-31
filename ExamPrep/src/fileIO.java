import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class fileIO {
	public static void main(String[] args) throws FileNotFoundException {
		crawl(new File("myFile"));
	}
	
	public static void crawl(File target) {
		crawl(target, 0);
	}
	
	public static void crawl(File target, int indent) {
		if(!target.isDirectory()) {
			System.out.println(indent + target.getName());
		}else {
			System.out.println(indent + target.getName());
			File[] myList = target.listFiles();
			for(File some : myList) {
				crawl(some, indent + 1);
			}
			
		}
	}
}
