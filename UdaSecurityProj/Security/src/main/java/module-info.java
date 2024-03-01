module Security {
    requires miglayout;
    requires java.desktop;
    requires guava;
    requires com.google.gson;
    requires java.prefs;
    requires Image;
    opens com.udacity.catpoint.security.data to com.google.gson;
    opens com.udacity.catpoint.security.service;
}