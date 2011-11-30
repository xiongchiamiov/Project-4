package ifixit;

import babysfirst.BabysFirst;

import java.util.Hashtable;

public class Device
{
    public static String list()
    {
        Hashtable<String, Object> values = new Hashtable<String, Object>();

        // Fetch devices from iFixit API
        // Store devices in `values`

        return BabysFirst.render_to_response("templates/device_list.tpl", values);
    }

    public static String details(String device)
    {
        Hashtable<String, Object> values = new Hashtable<String, Object>();

        // Fetch device details from iFixit API
        // Store details in `values`

        return BabysFirst.render_to_response("templates/device_details.tpl", values);
    }
}

