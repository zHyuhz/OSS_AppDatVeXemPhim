package vn.edu.stu.oss_appdatvexemphim.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import vn.edu.stu.oss_appdatvexemphim.DTO.Request.AccountUpdate;

import vn.edu.stu.oss_appdatvexemphim.DTO.Request.UserRequest;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.AccountResponse;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.ApiResponse;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.UserResponse;

public interface ApiService {
    @GET("/accounts/{username}")
    Call<ApiResponse<AccountResponse>> findAccountByUsername(@Path("username") String username);


    @GET("/accounts")
    Call<ApiResponse<List<AccountResponse>>> getAllAccount();

    @DELETE("/accounts/{userName}")
    Call<ApiResponse<String>> deleteAccount(@Path("userName") String userName);

    @PUT("/accounts/{userName}")
    Call<ApiResponse<AccountResponse>> updateAccount(@Path("userName") String userName, @Body AccountUpdate accountUpdate);

    @DELETE("/users/{id}")
    Call<ApiResponse<String>> deleteUser(@Path("id") int user_id);

    @GET("/users")
    Call<ApiResponse<List<UserResponse>>> getAllUsers();
    @PUT("/users/{id}")
    Call<ApiResponse<UserResponse>> updateUsers(@Path("id") int id,
                                                @Body UserRequest userRequest);


}
