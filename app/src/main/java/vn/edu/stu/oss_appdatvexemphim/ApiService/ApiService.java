package vn.edu.stu.oss_appdatvexemphim.ApiService;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.stu.oss_appdatvexemphim.DTO.Request.LoginRequest;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.AccountResponse;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.ApiResponse;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.BookingResponse;
import vn.edu.stu.oss_appdatvexemphim.DTO.Response.MovieResponse;

public interface ApiService {
    @DELETE("/movies/{id}")
    Call<ApiResponse<String>> deleteMovie(@Path("id") int movieId);

    @GET("/movies")
        // Thay {id} bằng ID phim
    Call<ApiResponse<List<MovieResponse>>> getAllMovie();
    @GET("/accounts/{username}")
    Call<ApiResponse<AccountResponse>> findAccountByUsername(@Path("username") String username);
    @Multipart
    @PUT("/movies/{id}")
    Call<ApiResponse<MovieResponse>> updateMovie(
            @Path("id") int id,
            @Query("movieName") String movieName,
            @Query("movieDes") String movieDes,
            @Query("movieGenres") String movieGenres,
            @Query("movieRelease") String movieRelease,
            @Query("movieLength") int movieLength,
            @Part MultipartBody.Part moviePoster
    );
    @Multipart
    @POST("/movies")
    Call<ApiResponse<MovieResponse>> addMovies(
            @Query("movieName") String movieName,
            @Query("movieDes") String movieDes,
            @Query("movieGenres") String movieGenres,
            @Query("movieRelease") String movieRelease,
            @Query("movieLength") int movieLength,
            @Part MultipartBody.Part moviePoster
    );
    @GET("/bookings")
    Call<ApiResponse<List<BookingResponse>>> getAllBooking();

    @POST("/auth/login")
    Call<ApiResponse<Void>> login(@Body LoginRequest loginRequest);

}
