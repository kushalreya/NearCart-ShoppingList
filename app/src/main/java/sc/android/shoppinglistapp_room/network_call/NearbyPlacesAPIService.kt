package sc.android.shoppinglistapp_room.network_call

import retrofit2.http.GET
import retrofit2.http.Query
import sc.android.shoppinglistapp_room.model.NearbyPlacesResponse

interface NearbyPlacesAPIService {
    @GET("maps/api/place/nearbysearch/json")
    suspend fun getNearbyPlaces(
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
        @Query("keyword") keyword: String? = null,
        @Query("pagetoken") pagetoken: String? = null,
        @Query("key") key: String
    ): NearbyPlacesResponse
}