import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello
{
    public static void main(String[] args) {
        String myString= "a+b-c*d/e";
        String [] result = myString.split("(?<=[-+*/])|(?=[-+*/])");
        System.out.println(Arrays.toString(result));
    }
}
