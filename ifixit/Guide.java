package ifixit;

import babysfirst.BabysFirst;

import java.util.Hashtable;

public class Guide
{
    /**
     * The controller for viewing the list of guides.
     */
    public static String list()
    {
        Hashtable<String, Object> values = new Hashtable<String, Object>();

        // Fetch guides from iFixit API
        // Store guides in `values`

        return BabysFirst.render_to_response("templates/guide_list.tpl", values);
    }
    
    /**
     * The controller for viewing the details of a particular guide.
     */
    public static String details(String guide)
    {
        Hashtable<String, Object> values = new Hashtable<String, Object>();

        // Fetch guide details from iFixit API
        // Store details in `values`

        return BabysFirst.render_to_response("templates/guide_details.tpl", values);
    }
}

