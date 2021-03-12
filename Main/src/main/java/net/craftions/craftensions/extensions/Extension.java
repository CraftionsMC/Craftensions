/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.craftensions.extensions;

import java.util.ArrayList;

public class Extension {

    public static ArrayList<Extension> installedExtensions = new ArrayList<>();
    public static ArrayList<Extension> availableExtensions = new ArrayList<>();



    private String name;
    private String currentVersion;
    private String downloadUrl;
    private String parent;

    public Extension(String name, String currentVersion, String downloadUrl, String parent) {
        this.name = name;
        this.currentVersion = currentVersion;
        this.downloadUrl = downloadUrl;
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public String getName() {
        return name;
    }
}
