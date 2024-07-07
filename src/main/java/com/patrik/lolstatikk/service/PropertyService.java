package com.patrik.lolstatikk.service;

import java.io.IOException;

public interface PropertyService {

    public void updateVersion(String version) throws IOException;

    public String getVersion() throws IOException;

}
