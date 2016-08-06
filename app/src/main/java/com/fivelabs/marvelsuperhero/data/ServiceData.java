package com.fivelabs.marvelsuperhero.data;

import com.fivelabs.marvelsuperhero.data.model.ComicsResponse;
import com.fivelabs.marvelsuperhero.domain.mapper.ComicsMapperResponse;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.google.gson.Gson;
import java.util.List;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

/**
 * Created by breogangf on 6/8/16.
 */
public class ServiceData implements ComicData {

  private Service service;
  private String baseUrl;
  private String publicKey;
  private String privateKey;
  private ComicsMapperResponse comicsMapperResponse;

  public ServiceData(String baseUrl, String publicKey, String privateKey) {
    this.baseUrl = baseUrl;
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    init();
  }

  private void init() {
    RestAdapter restAdapter =
            new RestAdapter.Builder().setRequestInterceptor(new Interceptor(publicKey, privateKey))
                    .setConverter(new GsonConverter(new Gson()))
                    .setEndpoint(baseUrl)
                    .build();
    service = restAdapter.create(Service.class);
    comicsMapperResponse = new ComicsMapperResponse();
  }


  @Override
  public List<MarvelComic> getComicList(int limit, int characterId) throws ComicsException {
    try {
      ComicsResponse marvelResult = service.getComicList(limit, characterId);
      return comicsMapperResponse.map(marvelResult);
    } catch (RetrofitError error) {
      ComicsException comicsException = new ComicsException();
      comicsException.setStackTrace(error.getStackTrace());
      throw comicsException;
    }
  }

    @Override
    public List<MarvelComic> getComicList(int limit, int offset, int characterId)
            throws ComicsException {
        try {
            ComicsResponse marvelResult = service.getComicList(limit, offset, characterId);
            return comicsMapperResponse.map(marvelResult);
        } catch (RetrofitError error) {
            ComicsException comicsException = new ComicsException();
            comicsException.setStackTrace(error.getStackTrace());
            throw comicsException;
        }
    }
}
