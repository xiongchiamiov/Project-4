package ifixit;

import babysfirst.BabysFirst;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Main
{
    public final static void main(String[] args)
	{
		LinkedHashMap<Pattern, String> urlMapping = new LinkedHashMap<Pattern, String>();
		// Fill in urlMapping.
        BabysFirst app = new BabysFirst(args, urlMapping);
        app.run();
    }
}

