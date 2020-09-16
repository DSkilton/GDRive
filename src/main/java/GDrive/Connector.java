/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GDrive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.client.http.HttpTransport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author MC03353
 */
public abstract class Connector {
    private String appName;
    private String userDir;
    private String userFileName = "credentials.json";
    
    private FileDataStoreFactory dataStoreFactory;
    private JsonFactory jsonFactory;
    private HttpTransport httpTransport;
    private List<String> scopes;
    
    public Connector (String appName, List<String> scopes, String userDir) throws GeneralSecurityException, IOException{
        this.appName = appName;
        //returns global thread safe instance
        jsonFactory = JacksonFactory.getDefaultInstance();
        httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        dataStoreFactory = new FileDataStoreFactory(new java.io.File(userDir));
    }// end of Connector constructor 
    
    public HttpTransport getHttpTransport(){
        return httpTransport;
    }
    
    public JsonFactory getJsonFactory(){
        return jsonFactory;
    }
    
    public String getAppName(){
        return appName;
    }
    
    public void setUserFileName(String userFileName){
        this.userFileName = userFileName;
    }
    
}// end of class
