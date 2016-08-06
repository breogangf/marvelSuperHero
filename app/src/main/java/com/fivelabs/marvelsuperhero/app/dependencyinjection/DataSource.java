package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.data.ComicData;
import com.fivelabs.marvelsuperhero.data.ServiceData;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class DataSource {

    @Provides
    @Named("marvel_endpoint")
    public String getBaseURLEndpoint() {
        return "http://gateway.marvel.com";
    }

    @Provides
    @Named("marvel_public_api_key")
    public String getApiPublicKey() {
        return "PLACE_HERE_YOUR_PUBLIC_API_KEY";
    }

    @Provides
    @Named("marvel_private_api_key")
    public String getApiPrivateKey() {
        return "PLACE_HERE_YOUR_PRIVATE_API_KEY";
    }

    @Provides
    @Singleton
    public ComicData getService(@Named("marvel_endpoint") String endpoint,
                                @Named("marvel_public_api_key") String publicKey,
                                @Named("marvel_private_api_key") String privateKey) {
        return new ServiceData(endpoint, publicKey, privateKey);
    }
}
