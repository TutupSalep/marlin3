package com.rakasettya.marlin3.data.api;

import com.rakasettya.marlin3.data.model.signup.BodyLogin;
import com.rakasettya.marlin3.data.model.signup.Login;
import com.rakasettya.marlin3.data.model.test2.Response;
import com.rakasettya.marlin3.data.model.user.ResponseUser;
import com.rakasettya.marlin3.helper.cons.UrlCons;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by rakhadota2 on 2/15/18.
 */

public interface NetworkService {
    @GET(UrlCons.URL_DataMarlin)
    Observable<Response> getdataMarlin();
//    @POST(UrlCons.URL_USER)
//    Observable<ResponseUser> user();
}
