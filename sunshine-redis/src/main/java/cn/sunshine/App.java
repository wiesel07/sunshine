package cn.sunshine;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String[] cacheNames = new String[] {"aa"};
		Optional<String[]> aOptional = Optional.ofNullable(cacheNames);
		if (aOptional.isPresent()) {
			System.out.println(1);
		}else {
			System.out.println("test");
		}
    }
}
